package com.goldie.admin;

import android.os.Bundle;
import android.view.View;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OrdersManagementFragment extends Fragment {
//    ExpandableListView expandableListView;
//    public FirebaseDatabase mDatabase=FirebaseDatabase.getInstance();
//    public DatabaseReference ref = mDatabase.getReference();
//    public DatabaseReference readDB=mDatabase.getReference();
//    ArrayList<String> listGroup=new ArrayList<>();
//    HashMap<String,ArrayList<String>> listChild=new HashMap<>();
//    MainAdaptar adaptar;
    public OrdersManagementFragment() {
        super(R.layout.fragment_orders_management);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        expandableListView=view.findViewById(R.id.exp_list_view);
//        for (int i = 0; i < 11; i++) {
//            listGroup.add("com.goldie.menu.Order "+i);
//            ArrayList<String> arraylist=new ArrayList<>();
//            for (int j = 0; j < 6; j++) {
//                arraylist.add("Item"+j);
//            }
//            listChild.put(listGroup.get(i),arraylist);
//        }
// adaptar = new MainAdaptar(this.getContext(),listGroup,listChild);
//        expandableListView.setAdapter(adaptar);
////        adaptar.notifyDataSetChanged();
    }




//    void readneworder(){
//        readDB.child("orders").child("500").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (int i=0;i<20;i++)
//                    System.out.println("WHAT\n");
//                com.goldie.menu.Order order = dataSnapshot.getValue(com.goldie.menu.Order.class);
//                Item temp=order.order_items.get(0);
//                System.out.println("HEREEEEEEEEEEEEEE     \n\n\n\n\n\n"+temp._id+"_____  I AMMMMMMMM____");
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });
//    }
//    void writeneworder(){
//        com.goldie.menu.Order test=new com.goldie.menu.Order();
//        List<Item> items = new ArrayList<>();
//        items.add(new Item("Chocolate",5));
//        com.goldie.menu.Order ord=new com.goldie.menu.Order(items,500);
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
