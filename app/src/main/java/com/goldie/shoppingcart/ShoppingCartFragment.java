package com.goldie.shoppingcart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import static com.goldie.MainActivity.order;

import com.goldie.R;
import com.goldie.admin.data.MainAdaptar;
import com.goldie.menu.CrepeObject;
import com.goldie.menu.FroyoObject;
import com.goldie.menu.IceCreamObject;
import com.goldie.menu.WaffleObject;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is representing the Entire Order that the user have made.
 * First there is a greeting line that Says Hello {User First Name, User Last name}
 * And than there is filling of the products purchased to the text View.
 */
public class ShoppingCartFragment extends Fragment {
    Button place_order;
    DatabaseReference refOrders;
    FirebaseAuth fb;
    //String orderUID = "";
    ExpandableListView exp_list;
    ArrayList<String> listProduct =new ArrayList<>();
    HashMap<String,ArrayList<String>> listAddOn =new HashMap<>();
    MainAdaptar adaptar;
    public ShoppingCartFragment() {
        super(R.layout.fragment_shopping_cart);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        place_order = view.findViewById(R.id.place_order);
        place_order.setOnClickListener(v -> {
                    NavDirections action = ShoppingCartFragmentDirections.actionShoppingCartFragmentToPaymentFragment2();
                    Navigation.findNavController(view).navigate(action);
                }
        );
        exp_list=view.findViewById(R.id.exp_list_view_shopping);
//        for (int i = 0; i < 11; i++) {
//            listGroup.add("com.goldie.menu.Order "+i);
//            ArrayList<String> arraylist=new ArrayList<>();
//            for (int j = 0; j < 6; j++) {
//                arraylist.add("Item"+j);
//            }
//            listChild.put(listGroup.get(i),arraylist);
//        }
        ArrayList<String> addons=new ArrayList<>();
        for (Map.Entry<String,Product> product:order.entrySet()) {
            listProduct.add(product.getValue().itemName+"_"+product.getKey());
            if(product.getValue() instanceof IceCreamObject) {
                addons.add("Served In: "+((IceCreamObject) product.getValue()).serveIn);
                addons.addAll(((IceCreamObject) product.getValue()).flavorArray);
            }
            if(product.getValue() instanceof FroyoObject) {
                addons.add("Cup Size:"+((FroyoObject) product.getValue()).cupSize);
                addons.add("Flavor: "+((FroyoObject) product.getValue()).flavor);
            }
            if(product.getValue() instanceof CrepeObject) {
                addons.add("Filling: "+((CrepeObject) product.getValue()).chocolateType);
                addons.addAll(((CrepeObject) product.getValue()).toppings);
            }
            if(product.getValue() instanceof WaffleObject) {
                addons.add("Type: "+((WaffleObject) product.getValue()).waffleType);
            }
            listAddOn.put(product.getKey(), (ArrayList<String>) addons.clone());
            addons.clear();
        }
        adaptar = new MainAdaptar(this.getContext(), listProduct, listAddOn);
        exp_list.setAdapter(adaptar);
        adaptar.notifyDataSetChanged();
//        refOrders = FirebaseDatabase.getInstance().getReference("Orders").child("User1");
//        ArrayList<String> orderInfoList = new ArrayList<>();
        TextView productsList = view.findViewById(R.id.TextViewProductsList);

        // Listener to fetch order from fb
//        ValueEventListener postListener = new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot ds : snapshot.getChildren()) {
//                    IceCreamObject iceCreamClass = new IceCreamObject(Objects.requireNonNull(ds.getValue(IceCreamObject.class)));
//                    String newOrder = "";
//                    newOrder += iceCreamClass.getClassName() + "\n";
//                    productsList.setText(newOrder);
//                    int sizeOfFlavorList = iceCreamClass.flavor.size();
//                    int sizeOfServeInList = iceCreamClass.serveIn.size();
//                    for (int i = 0; i < sizeOfFlavorList; i++) {
//                        Product flavorProduct = new Product(iceCreamClass.flavor.get(i));
//                    }
//                }
//            }
//
//            ;
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        };
        //refOrders.addValueEventListener(postListener);

//        ValueEventListener eventListener = new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapShot) {
//
//                Order currOrder = new Order(snapShot.getValue(Order.class));
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//
//        };
    }

}
