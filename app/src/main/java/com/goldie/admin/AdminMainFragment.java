package com.goldie.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.goldie.R;
import com.goldie.login.LoginFragmentDirections;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class AdminMainFragment extends Fragment {
    private Button mOrdersBtn;
    public AdminMainFragment() {
        super(R.layout.fragment_admin_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mOrdersBtn = view.findViewById(R.id.button_placed_orders);
        mOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = AdminMainFragmentDirections.actionAdminMainFragmentToOrdersManagementFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}
