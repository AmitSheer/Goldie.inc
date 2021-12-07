package com.goldie.shoppingcart;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.menu.IceCreamObject;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

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
