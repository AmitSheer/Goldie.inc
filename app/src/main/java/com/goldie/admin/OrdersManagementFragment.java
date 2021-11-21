package com.goldie.admin;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.goldie.R;
import com.goldie.admin.data.MainAdaptar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrdersManagementFragment extends Fragment {
    ExpandableListView expandableListView;
    public FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
    public DatabaseReference ref = mDatabase.getReference();
    public DatabaseReference readDB=mDatabase.getReference();
    ArrayList<String> listGroup=new ArrayList<>();
    HashMap<String,ArrayList<String>> listChild=new HashMap<>();
    MainAdaptar adaptar;
    public OrdersManagementFragment() {
        super(R.layout.fragment_orders_management);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        expandableListView=view.findViewById(R.id.exp_list_view);
//        for (int i = 0; i < 11; i++) {
//            listGroup.add("Order "+i);
//            ArrayList<String> arraylist=new ArrayList<>();
//            for (int j = 0; j < 6; j++) {
//                arraylist.add("Item"+j);
//            }
//            listChild.put(listGroup.get(i),arraylist);
//        }
//        adaptar = new MainAdaptar(this.getContext(),listGroup,listChild);
//        expandableListView.setAdapter(adaptar);
//        adaptar.notifyDataSetChanged();
    }




//    void readneworder(){
//        readDB.child("orders").child("500").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (int i=0;i<20;i++)
//                    System.out.println("WHAT\n");
//                Order order = dataSnapshot.getValue(Order.class);
//                Item temp=order.order_items.get(0);
//                System.out.println("HEREEEEEEEEEEEEEE     \n\n\n\n\n\n"+temp._id+"_____  I AMMMMMMMM____");
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });
//    }
//    void writeneworder(){
//        Order test=new Order();
//        List<Item> items = new ArrayList<>();
//        items.add(new Item("Chocolate",5));
//        Order ord=new Order(items,500);
//        ref.child("orders").child("500").setValue(ord);
//    }
//
//    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//        if (databaseError != null) {
//            System.out.println("Data could not be saved " + databaseError.getMessage());
//        } else {
//            System.out.println("Data saved successfully.");
//        }
//    }
}
