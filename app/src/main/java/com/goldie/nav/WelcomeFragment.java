package com.goldie.nav;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {
    Button mOkBtn;
    public WelcomeFragment() {
        super(R.layout.fragment_welcome);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView username = view.findViewById(R.id.text_view_username);
        TextView password = view.findViewById(R.id.text_view_password);
        String Username = WelcomeFragmentArgs.fromBundle(getArguments()).getUsername();
        String Password = WelcomeFragmentArgs.fromBundle(getArguments()).getPassword();
        username.setText(Username);
        password.setText(Password);
        mOkBtn = view.findViewById(R.id.button_ok);
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}
