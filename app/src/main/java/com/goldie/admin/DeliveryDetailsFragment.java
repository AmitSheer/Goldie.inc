package com.goldie.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.goldie.R;

public class DeliveryDetailsFragment extends Fragment {
    private SignaturePad signaturePad;
    private TextView orderId,  userName, address, userPhoneNumber;
    private Button confirmDeliveryBtn,clearBtn;
    public DeliveryDetailsFragment() {
        super(R.layout.fragment_delivery_details);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signaturePad = (SignaturePad) view.findViewById(R.id.signaturePad);
        clearBtn = (Button)view.findViewById(R.id.clearButton);
        confirmDeliveryBtn = view.findViewById(R.id.confirmDelivery);
        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {

            @Override
            public void onStartSigning() {
                //Event triggered when the pad is touched
            }

            @Override
            public void onSigned() {
                //Event triggered when the pad is signed
            }

            @Override
            public void onClear() {
                clearBtn.setEnabled(false);
            }
        });

        confirmDeliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 12/22/2021 delete from firebase the relevant document, and save signature and something else and send receipt in email
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
    }
}
