package com.goldie.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goldie.R;
import com.goldie.admin.data.OrderAdaptar;
import com.goldie.shop.shoppingcart.Order;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrdersManagementFragment extends Fragment {
//    ExpandableListView expandableListView;
    public FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
    public DatabaseReference ref = mDatabase.getReference();
    public DatabaseReference readDB=mDatabase.getReference();
//    ArrayList<String> listGroup=new ArrayList<>();
//    HashMap<String,ArrayList<String>> listChild=new HashMap<>();
//    MainAdaptar adaptar;
    OrderAdaptar adaptar;
    RecyclerView orders_view;
    public ArrayList<String> order_list;
    public OrdersManagementFragment() {
        super(R.layout.fragment_orders_management);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orders_view=view.findViewById(R.id.orders_list);
        readDB.child("Orders").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                order_list = new ArrayList<>();
                Iterable<DataSnapshot> content = task.getResult().getChildren();
                for (DataSnapshot child : content) {
                    order_list.add(child.getKey());
                }
                orders_view.setLayoutManager(new LinearLayoutManager(getActivity()));
                orders_view.addItemDecoration(new DividerItemDecoration(orders_view.getContext(), DividerItemDecoration.VERTICAL));
                orders_view.scrollToPosition(0);
                adaptar= new OrderAdaptar(getContext(),order_list);
                orders_view.setAdapter(adaptar);
            }
        });

    }


}
