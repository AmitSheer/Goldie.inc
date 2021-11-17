package com.goldie.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class AdminFragment extends Fragment {
    private Button mLogin;

    public AdminFragment() {
        super(R.layout.fragment_admin_manager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLogin = view.findViewById(R.id.button_confirm);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = AdminFragmentDirections.actionAdminFragmentToAdminMainFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}
