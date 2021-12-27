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

    private Button  payBtn;
    RadioButton delivery;
    RadioButton takeout;
    RadioGroup group;

    EditText City;
    EditText Street;
    EditText HouseNumber;


    public DeliveryFragment() {
        super(R.layout.fragment_delivery);
        // Required empty public constructor
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

        if (order.is_delivery){
            group.check(delivery.getId());
        }

        group.setOnCheckedChangeListener((group, checkedId) -> {
            boolean isChecked = takeout.isChecked();
            if (isChecked) {
                delivery_layout.setVisibility(View.VISIBLE);
            } else {
                delivery_layout.setVisibility(View.INVISIBLE);
            }
        });

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delivery.isChecked()&&checkValidAddress()) {
                    order.setIs_delivery(true);
                    NavDirections action = DeliveryFragmentDirections.actionDeliveryFragmentToPaymentFragment();
                    Navigation.findNavController(view).navigate(action);
                }else if(takeout.isChecked()){
                    order.setIs_delivery(false);
                    NavDirections action = DeliveryFragmentDirections.actionDeliveryFragmentToPaymentFragment();
                    Navigation.findNavController(view).navigate(action);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Invalid Address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkValidAddress(){
        return Street.getText().toString().trim().length()!=0&&City.getText().toString().trim().length()!=0&&Double.parseDouble(HouseNumber.getText().toString().trim())>0;
    }
}