package com.goldie.admin.delivery;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldie.R;
import com.goldie.admin.data.DeliveryAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DeliveryMenuFragment extends Fragment {

    private FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference readDB=mDatabase.getReference();
    DeliveryAdapter adapter;
    RecyclerView orders_view;
    private ArrayList<String> order_list;
    public DeliveryMenuFragment() {
        super(R.layout.fragment_delivery_menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orders_view=view.findViewById(R.id.orders_list);
        readDB.child("Deliveries").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                order_list = new ArrayList<>();
                Iterable<DataSnapshot> content = task.getResult().getChildren();
                for (DataSnapshot child : content) {
                    order_list.add(child.getKey());
                }
                orders_view.setLayoutManager(new LinearLayoutManager(getActivity()));
                orders_view.scrollToPosition(0);
                adapter= new DeliveryAdapter(getContext(),order_list);
                orders_view.setAdapter(adapter);
            }
        });

    }
}
