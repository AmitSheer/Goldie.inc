package com.goldie.account;

import static com.goldie.shop.ShopActivity.order;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.account.data.UserData;
import com.goldie.shop.shoppingcart.Order;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {
    Button mConfirmBtn,mRegisterBtn;
    EditText mEmail, mPassword;
    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mConfirmBtn = view.findViewById(R.id.button_confirm);
        mRegisterBtn = view.findViewById(R.id.button_register);
        mEmail = view.findViewById(R.id.edit_text_email);
        mPassword = view.findViewById(R.id.edit_text_password);
        //sends the user data to the firebase adapter for login
        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }

                //runs after validation
                FirebaseAdapter.Login(email,password).addOnCompleteListener(task->{
                    if(task.isSuccessful()) {
                        try {
                            LoginViewNav.ChangeViewByUserType((LoginActivity) getActivity());
                            Toast.makeText(getContext(), "Signed In", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Toast.makeText(getContext(), "Error ! "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getContext(), "Error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //changes the user view to the register fragment
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}
