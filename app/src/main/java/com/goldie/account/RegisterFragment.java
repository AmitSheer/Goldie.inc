package com.goldie.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.goldie.R;
import com.goldie.account.data.UserData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class RegisterFragment extends Fragment {
    private static final String TAG = "DocSnippets";

    Button mRegisterBtn;
    EditText mFullName, mPassword, mPhone,mEmail;
    public RegisterFragment() {
        super(R.layout.fragment_register);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRegisterBtn = view.findViewById(R.id.register_confirm);
        mFullName = view.findViewById(R.id.fullName);
        mPassword =view.findViewById(R.id.password);
        mPhone =view.findViewById(R.id.phone);
        mEmail =view.findViewById(R.id.email);

        //listens to register button event
        mRegisterBtn.setOnClickListener(v -> {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String phone = mPhone.getText().toString().trim();
            String full_name = mFullName.getText().toString().trim();

            if (TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required");
                return;
            }
            if (TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required");
                return;
            }
            if (TextUtils.isEmpty(full_name)){
                mFullName.setError("Full Name is Required");
                return;
            }
            if (TextUtils.isEmpty(phone)){
                mPhone.setError("Phone is Required");
                return;
            }

            FirebaseAdapter.Register(email,password,full_name,phone).addOnCompleteListener(task->{
                if(task.isSuccessful()){
                    Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();
                    LoginViewNav.ChangeViewByUserType(getActivity());
                }else{
                    Toast.makeText(getContext(), "Error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}
