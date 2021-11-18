package com.goldie.account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.account.data.UserData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class AccountFragment extends Fragment {
    Button mLogoutBtn;
    public AccountFragment() {
        super(R.layout.fragment_account);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLogoutBtn = view.findViewById(R.id.button_logout);

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAdapter.fAuth.signOut();
                Toast.makeText(getContext(), "User Logged out", Toast.LENGTH_SHORT).show();
                UserData.empty();
                NavDirections action = AccountFragmentDirections.actionAccountFragmentToLoginFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}
