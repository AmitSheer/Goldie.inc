package com.goldie.shop.shoppingcart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import static com.goldie.shop.ShopActivity.order;

public class DeliveryFragment extends Fragment {

    private Button payBtn;
    RadioButton delivery;
    RadioButton takeout;
    RadioGroup group;

    EditText City;
    EditText Street;
    EditText HouseNumber;


    public DeliveryFragment() {
        super(R.layout.fragment_delivery);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        group = view.findViewById(R.id.radioGroup);
        payBtn = view.findViewById(R.id.pay);
        delivery = view.findViewById(R.id.delivery);
        takeout = view.findViewById(R.id.takeout);
        City = view.findViewById(R.id.city);
        HouseNumber = view.findViewById(R.id.houseNumber);
        Street = view.findViewById(R.id.street);
        ConstraintLayout delivery_layout = view.findViewById(R.id.delivery_layout);

        if (order.isIs_delivery()) {
            group.check(delivery.getId());
        }

        group.setOnCheckedChangeListener((group, checkedId) -> {
            boolean isChecked = delivery.isChecked();
            if (isChecked) {
                delivery_layout.setVisibility(View.VISIBLE);
            } else {
                delivery_layout.setVisibility(View.INVISIBLE);
            }
        });

        payBtn.setOnClickListener(v -> {
            if (delivery.isChecked()) {
                if (checkValidAddress()) {
                    order.setIs_delivery(true);

                    if (HouseNumber.getText().toString().length() > 0) {
                        order.setAddress(City.getText().toString() + "," + Street.getText().toString() + "," + HouseNumber.getText().toString());
                    } else {
                        order.setAddress(City.getText().toString() + "," + Street.getText().toString());

                    }
                    NavDirections action = DeliveryFragmentDirections.actionDeliveryFragmentToPaymentFragment();
                    Navigation.findNavController(view).navigate(action);
                } else {
                    Toast.makeText(view.getContext(), "Invalid Address", Toast.LENGTH_SHORT).show();
                }
            } else if (takeout.isChecked()) {
                order.setIs_delivery(false);
                NavDirections action = DeliveryFragmentDirections.actionDeliveryFragmentToPaymentFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    private boolean checkValidAddress() {
        if (City.getText().toString().trim().length() == 0) {
            City.setError("Bad City Name");
            return false;
        }
        if (Street.getText().toString().trim().length() == 0) {
            Street.setError("Bad Street Name");
            return false;
        }
        try {
            //if length is 0 then fine if not 0 then needs to be more then 0 and convertable
            if (Double.parseDouble(HouseNumber.getText().toString().trim()) <= 0) {
                HouseNumber.setError("Bad House Number Name");
                return false;
            }
        } catch (Exception e) {
            if (HouseNumber.getText().toString().trim().length() != 0) {
                HouseNumber.setError("Bad House Number Name");
                return false;
            }
        }
        return true;
    }
}