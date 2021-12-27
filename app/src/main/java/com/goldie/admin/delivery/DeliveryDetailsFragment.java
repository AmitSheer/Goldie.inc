package com.goldie.admin.delivery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.goldie.R;
import com.goldie.shop.shoppingcart.Order;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class DeliveryDetailsFragment extends Fragment {
    private DeliveryDetailsController controller;
    private SignaturePad signaturePad;
    private TextView orderId,  userName, address, userPhoneNumber;
    private Button clearBtn,confirmDeliveryBtn;

    public DeliveryDetailsFragment() {
        super(R.layout.fragment_delivery_details);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        controller = new DeliveryDetailsController(this);
        super.onViewCreated(view, savedInstanceState);
        signaturePad = (SignaturePad) view.findViewById(R.id.signaturePad);
        clearBtn = (Button)view.findViewById(R.id.clearButton);
        confirmDeliveryBtn = view.findViewById(R.id.confirmDelivery);
        orderId = (TextView)view.findViewById(R.id.orderId);
        userName=(TextView)view.findViewById(R.id.userName);
        address = (TextView)view.findViewById(R.id.address);
        userPhoneNumber = (TextView)view.findViewById(R.id.userPhoneNumber);
        clearBtn.setEnabled(false);
        confirmDeliveryBtn.setEnabled(false);
        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
                clearBtn.setEnabled(true);
                confirmDeliveryBtn.setEnabled(true);
                //Event triggered when the pad is touched
            }

            @Override
            public void onSigned() {
                //Event triggered when the pad is signed
            }

            @Override
            public void onClear() {
                clearBtn.setEnabled(false);
                confirmDeliveryBtn.setEnabled(false);
            }
        });

        confirmDeliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.saveReceipt(signaturePad.getSignatureSvg());
                NavDirections action = DeliveryDetailsFragmentDirections.actionDeliveryDetailsFragmentToDeliveryMenuFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signaturePad.clear();
            }
        });
        if (getArguments() != null) {
            controller.loadDeliveryData(getArguments().getString("order_id"));
        }

    }

    public void updateData(Order order){
        address.setText(order.getAddress());
        userName.setText(order.getUserName());
        userPhoneNumber.setText(order.getPhoneNumber());
        orderId.setText(order.getOrder_id());
    }

}
