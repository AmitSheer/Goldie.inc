package com.goldie.shop.shoppingcart;

import static com.goldie.shop.ShopActivity.order;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.account.data.UserData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.io.IOException;
import java.util.HashMap;

/**
 * This class represents the payment fragment that takes care of the payment of the orders from the user.
 */
public class PaymentFragment extends Fragment implements TextWatcher {
    int previousLength;
    Button payment;
    RadioButton credit;
    RadioButton cash;
    RadioGroup group;
    public static String order_id;
    private static Integer counter=0;
    public PaymentFragment() {
        super(R.layout.fragment_payment);
    }

    EditText creditExpireEt;
    EditText creditCVVEt;
    TextView total_price_view;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // After order is made, put an order id unique number with an order
//        order_id="Order ";
//        order_id+=counter.toString();
        counter++;
        ConstraintLayout credit_box = view.findViewById(R.id.credit_layout);
        total_price_view=view.findViewById(R.id.total_price);
        super.onViewCreated(view, savedInstanceState);
        group = view.findViewById(R.id.radioGroup);

        // Sum all the products price to a total price
//        Double total_price=0.0;
//        for (Product product: order.values()) {
//            total_price+=product.getPrice();
//        }
        total_price_view.setText(total_price_view.getText()+order.getTotalPrice().toString()+"$");

        payment = view.findViewById(R.id.order);
        order.setPhoneNumber(UserData.Phone);
        order.setUserName(UserData.FullName);
        // Upload to firebase the order that the user have made
        payment.setOnClickListener(v -> {
            if(group.getCheckedRadioButtonId()!=-1) {
                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").
                        child("Order " + order.getOrder_id());
                refNewOrder.setValue(order);
//                refNewOrder.child("User_ID").setValue(order.getUserUID());
//                refNewOrder.child("Products").setValue(order.products);
//                refNewOrder.child("Address").setValue(order.getAddress());
//                refNewOrder.child("PhoneNumber").setValue(order.getPhoneNumber());
//                refNewOrder.child("UserName").setValue(order.getUserName());
//                refNewOrder.child("Delivery").setValue(order.is_delivery);
                order = new Order();
                NavDirections action = PaymentFragmentDirections.actionPaymentFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
            else{
                Toast.makeText(requireActivity().getApplicationContext(), "Please payment method", Toast.LENGTH_SHORT).show();
            }
        });

        credit = view.findViewById(R.id.credit);
        cash = view.findViewById(R.id.cash);
        creditCVVEt = view.findViewById(R.id.credit_card_cvv_et);
        creditExpireEt = view.findViewById(R.id.credit_card_expire_et);
        creditExpireEt.addTextChangedListener(this);
        // Listens to credit card box being filled
        group.setOnCheckedChangeListener((group, checkedId) -> {
            boolean isChecked = credit.isChecked();
            if (isChecked) {
                credit_box.setVisibility(View.VISIBLE);
            } else {
                credit_box.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * This function is used to get the length of the previous text.
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        previousLength = creditExpireEt.getText().toString().length();
    }

    /**
     * This function is used for the credit box, it is used to check a legit input for the credit card.
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int length = creditExpireEt.getText().toString().trim().length();
        if (previousLength <= length && length < 3) {
            int month = Integer.parseInt(creditExpireEt.getText().toString());
            if (length == 1 && month >= 2) {
                String autoFixStr = "0" + month + "/";
                creditExpireEt.setText(autoFixStr);
                creditExpireEt.setSelection(3);
            } else if (length == 2 && month <= 12) {
                String autoFixStr = creditExpireEt.getText().toString() + "/";
                creditExpireEt.setText(autoFixStr);
                creditExpireEt.setSelection(3);
            } else if (length == 2 && month > 12) {
                creditExpireEt.setText("1");
                creditExpireEt.setSelection(1);
            }
        } else if (length == 5) {
            creditCVVEt.requestFocus(); // auto move to next edittext
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

}
