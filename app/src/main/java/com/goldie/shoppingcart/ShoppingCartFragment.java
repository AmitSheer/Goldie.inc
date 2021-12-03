package com.goldie.shoppingcart;

import android.os.Bundle;
import android.view.View;

import com.goldie.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class is representing the Entire Order that the user have made.
 * First there is a greeting line that Says Hello {User First Name, User Last name}
 * And than there is filling of the products purchased to the text View.
 */
public class ShoppingCartFragment extends Fragment {
    DatabaseReference refOrders;
    FirebaseAuth fb;
    ArrayList<Order> clientOrder;
    // Need to get from neta the order uid from fb with intent.putExtra()
    // orderUID will be filled with the uid of the order number.
    String orderUID = "";

    public ShoppingCartFragment() {
        super(R.layout.fragment_shopping_cart);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refOrders = FirebaseDatabase.getInstance().getReference("Orders");

        // Listener to fetch order from fb
        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // map of uid (order number unique id), Order (class)
                Map<String, Order> allOrders = (Map<String, Order>) snapshot.getValue();
                Order order;

                for (Map.Entry<String, Order> currentOrder : allOrders.entrySet()) {
                    order = currentOrder.getValue();
                    if (order.getUserUID().equals(orderUID)) {
                        clientOrder.add(order);
                        break;
                    }
                }
            };

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        ValueEventListener eventListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapShot) {

                Order currOrder = new Order(snapShot.getValue(Order.class));

//               final LinearLayout viewLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
//               LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                       LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//               params.setMargins(0, 0, 0, 20);
//
//               ArrayList<Button> addButtons = new ArrayList<>();
//               ArrayList<Button> subButtons = new ArrayList<>();
//               ArrayList<EditText> amountOfProduct = new ArrayList<>();
//
//                LinearLayout layout = new LinearLayout(view.getContext());
//                layout.setOrientation(LinearLayout.VERTICAL);
//
//                TextView productName = new TextView(view.getContext());
//                productName.setText("Product name: " + clientOrder.getName());
//                ll.addView(productName)
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        };
    }
}
