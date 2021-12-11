package com.goldie.shoppingcart;

import static com.goldie.MainActivity.order;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.menu.FroyoMenuFragmentDirections;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class PaymentFragment extends Fragment implements TextWatcher {
    int previousLength;
    Button mLoginBtn;
    Button payment;
    RadioButton credit;
    RadioButton cash;
    RadioGroup group;
    public static String order_id;
    private static Integer counter=0;
    public PaymentFragment() {
        super(R.layout.fragment_payment);
    }

    // @BindView(R.id.credit_card_expire_et)
    EditText creditExpireEt;
    // @BindView(R.id.credit_card_cvv_et)
    EditText creditCVVEt;
    TextView total_price_view;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        order_id="Order ";
        order_id+=counter.toString();
        counter++;
        ConstraintLayout credit_box = view.findViewById(R.id.credit_layout);
        total_price_view=view.findViewById(R.id.total_price);
        //credit_box.setVisibility(View.INVISIBLE);
        super.onViewCreated(view, savedInstanceState);
        group = view.findViewById(R.id.radioGroup);
//        mLoginBtn = view.findViewById(R.id.button_login);
//
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections action = HomeFragmentDirections.actionHomeFragmentToLoginFragment();
//                Navigation.findNavController(view).navigate(action);
//            }
//        });   pa
        Double total_price=0.0;
        for (Product product:
             order.values()) {
            total_price+=product.getPrice();
        }
        total_price_view.setText(total_price_view.getText()+total_price.toString()+"$");
        payment = view.findViewById(R.id.order);
        payment.setOnClickListener(v -> {
            DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").
                    child(String.valueOf(order_id)).push();
            //CrepeObject crepeObject = new CrepeObject(chocolateType,topping);
                    refNewOrder.setValue(order);
                    order.clear();
                    NavDirections action = PaymentFragmentDirections.actionPaymentFragmentToMenuFragment();
                    Navigation.findNavController(view).navigate(action);});
        credit = view.findViewById(R.id.credit);
        cash = view.findViewById(R.id.cash);
        creditCVVEt = view.findViewById(R.id.credit_card_cvv_et);
        creditExpireEt = view.findViewById(R.id.credit_card_expire_et);
        creditExpireEt.addTextChangedListener(this);
        group.setOnCheckedChangeListener((group, checkedId) -> {
            boolean isChecked = credit.isChecked();
            //View credit_box=
            if (isChecked) {
                credit_box.setVisibility(View.VISIBLE);
            } else {
                credit_box.setVisibility(View.INVISIBLE);
            }
        });
    }
    
//    @OnTextChanged(value = R.id.credit_card_expire_et, callback = BEFORE_TEXT_CHANGED)
//    void beforeExpireEtChanged() {
//        previousLength = creditExpireEt.getText().toString().length();
//    }

//
//    @OnTextChanged(R.id.credit_card_expire_et)
//    void autoFixAndMoveToNext() {
//
//    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        previousLength = creditExpireEt.getText().toString().length();
    }

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
