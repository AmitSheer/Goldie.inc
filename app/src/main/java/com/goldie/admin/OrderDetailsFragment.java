package com.goldie.admin;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.goldie.R;
import com.goldie.admin.data.OrderDetailsAdaptar;
import com.goldie.shop.menu.CrepeObject;
import com.goldie.shop.menu.FroyoObject;
import com.goldie.shop.menu.IceCreamObject;
import com.goldie.shop.menu.WaffleObject;
import com.goldie.shop.shoppingcart.Order;
import com.goldie.shop.shoppingcart.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetailsFragment extends Fragment {
    public FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
    public DatabaseReference orders_ref =mDatabase.getReference();
    public DatabaseReference delivery_ref=mDatabase.getReference().child("Deliveries");
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "order_id";
    private Order order;
    private String mParam;
    Button deliver;
    OrderDetailsAdaptar adaptar;
    HashMap<String,ArrayList<String>> mapAddOn =new HashMap<>();
    //public
    public ExpandableListView exp_list;
    public OrderDetailsFragment() {
        super(R.layout.fragment_order_details);
        // Required empty public constructor
    }

    public static OrderDetailsFragment newInstance(String param) {
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
        //readDB.child()
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        deliver=view.findViewById(R.id.deliver);

        Context ct=this.getContext();
        order=new Order();
        exp_list=view.findViewById(R.id.products_list);
        deliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(order.isIs_delivery()){
                    delivery_ref.child(mParam).setValue(order);
                }
                orders_ref.child("Orders").child(mParam).removeValue();
            }
        });
        orders_ref.child("Orders").child(mParam).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                parse_order(task);
                ArrayList<String> addons=new ArrayList<>();
                // Loop over order map on all products and add to the list the products and to the map all the children's
                //ArrayList<Product> productsss= (ArrayList<Product>) order.values();
                int k=0;
                //HashMap<String,Product> product_list= (HashMap<String, Product>) order.values();
                for (Product product:order.values()) {
                    if(product instanceof IceCreamObject) {
                        addons.add("Served In: "+((IceCreamObject) product).serveIn);
                        addons.addAll(((IceCreamObject) product).flavorArray);
                    }
                    if(product instanceof FroyoObject) {
                        addons.add("Cup Size: "+((FroyoObject) product).cupSize);
                        addons.add("Flavor: "+((FroyoObject) product).flavor);
                    }
                    if(product instanceof CrepeObject) {
                        addons.add("Filling: "+((CrepeObject) product).chocolateType);
                        addons.addAll(((CrepeObject) product).toppings);
                    }
                    if(product instanceof WaffleObject) {
                        addons.add("Type: "+((WaffleObject) product).waffleType);
                    }
                    mapAddOn.put(product.getProduct_id(), (ArrayList<String>) addons.clone());
                    addons.clear();
                }
                ArrayList<Product> products = new ArrayList<>(order.getProducts().values());
                OrderDetailsAdaptar adaptar=new OrderDetailsAdaptar(ct,products, mapAddOn);
                exp_list.setAdapter(adaptar);
                adaptar.notifyDataSetChanged();
            }


        });


    }
    public void parse_order(Task<DataSnapshot> task){
        Iterable<DataSnapshot> content = task.getResult().getChildren();
        for (DataSnapshot child : content) {
            switch(child.getKey()){
                case "Address":{
                    order.setAddress((String)child.getValue());
                    break;
                }
                case "User_ID":{
                    order.setUserUID((String)child.getValue());
                    break;
                }
                case "Delivery":{
                    order.setIs_delivery((Boolean)child.getValue());
                    break;
                }
                case "Products":{
                    parse_products(child);
                    //order.setProducts((HashMap<String,Product>)child.getValue());
                }

            }
            //order_list.add(child.getKey());
        }
    }
    public void parse_products(DataSnapshot child){
        //Product product_spec=new Product();
        for (DataSnapshot product: child.getChildren()) {
            String key=product.getKey().substring(0,product.getKey().length()-2);
//            product_spec.product_id=product.getKey();
//            product_spec.setItemName((String)product.child("itemName").getValue());
//            product_spec.setPrice((Long)product.child("price").getValue());
//            product_spec.product_id=product.getKey();
            switch (key){
                case "Ice Cream":{
                    IceCreamObject ice_cream=new IceCreamObject();
                    ice_cream.serveIn=(String)product.child("serveIn").getValue();
                    for (DataSnapshot flavor:product.child("flavorArray").getChildren()) {
                        ice_cream.flavorArray.add((String)flavor.getValue());
                    }
                    order.put(product.getKey(),ice_cream);
                    break;
                }
                case "Crepe":{
                    CrepeObject crepe=new CrepeObject();
                    crepe.chocolateType=(String)product.child("chocolateType").getValue();
                    for (DataSnapshot flavor:product.child("toppings").getChildren()) {
                        crepe.toppings.add((String)flavor.getValue());
                    }
                    order.put(product.getKey(),crepe);
                    break;
                }
                case "Waffle":{
                    WaffleObject waffle=new WaffleObject();
                    waffle.waffleType=(String)product.child("waffleType").getValue();
                    order.put(product.getKey(),waffle);
                    break;
                }
                case "Froyo":{
                    FroyoObject froyo=new FroyoObject();
                    froyo.cupSize=(String)product.child("cupSize").getValue();
                    froyo.flavor=(String)product.child("flavor").getValue();
                    order.put(product.getKey(),froyo);
                    break;
                }
            }
            //order.put(product.getKey(),product_spec);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_details, container, false);
    }
}