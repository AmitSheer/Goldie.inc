package com.goldie.nav.ui.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    TextView mEmail, mPassword;
    Button mLoginBtn;
    private LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mEmail = binding.loginEmail;
        mPassword = binding.loginPassword;
        mLoginBtn = binding.loginBtn;
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if user exists and if exist then login and send view to menu
                //else pop a toast to user with error and mark bad part
            }
        });
//        final TextView textView = binding.textSlideshow;
//        loginViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        super.onCreate(savedInstanceState);
//
//        mEmail = view.findViewById(R.id.log_email);
//        mPassword = view.findViewById(R.id.log_password);
//        mLoginBtn = view.findViewById(R.id.loginBtn);
//
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //check if user exists and if exist then login and send view to menu
//                //else pop a toast to user with error and mark bad part
//            }
//        });
//
//    }


}