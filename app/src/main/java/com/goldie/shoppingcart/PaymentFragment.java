package com.goldie.shoppingcart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PaymentFragment extends Fragment {

    Button mLoginBtn;
    public PaymentFragment() {
        super(R.layout.fragment_payment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mLoginBtn = view.findViewById(R.id.button_login);
//
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections action = HomeFragmentDirections.actionHomeFragmentToLoginFragment();
//                Navigation.findNavController(view).navigate(action);
//            }
//        });

    }
}
