package com.goldie.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {
    Button mConfirmBtn,mRegisterBtn;
    EditText mUsername, mPassword;
    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mConfirmBtn = view.findViewById(R.id.button_confirm);
        mUsername = view.findViewById(R.id.edit_text_username);
        mPassword = view.findViewById(R.id.edit_text_password);
        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(mUsername.getText().toString(),mPassword.getText().toString());
                Navigation.findNavController(view).navigate(action);
            }
        });
//        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
//                Navigation.findNavController(view).navigate(action);
//            }
//        });
    }
}
