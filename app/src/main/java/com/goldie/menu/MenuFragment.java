package com.goldie.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;
import com.google.firestore.v1.StructuredQuery;


public class MenuFragment extends Fragment {

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton ice_btn = view.findViewById(R.id.icecream);
        ImageButton waffle_btn = view.findViewById(R.id.waffle);
        ImageButton crepe_btn = view.findViewById(R.id.crepes);
        ImageButton froyo_btn = view.findViewById(R.id.froyo);
        ice_btn.setOnClickListener(v -> {
            NavDirections action = MenuFragmentDirections.actionMenuFragmentToIceCreamMenuFragment();
            Navigation.findNavController(view).navigate(action);
        });
        waffle_btn.setOnClickListener(v -> {
            NavDirections action = MenuFragmentDirections.actionMenuFragmentToWaffleMenuFragment();
            Navigation.findNavController(view).navigate(action);
        });
        crepe_btn.setOnClickListener(v -> {
            NavDirections action = MenuFragmentDirections.actionMenuFragmentToCrepeMenuFragment();
            Navigation.findNavController(view).navigate(action);
        });
        froyo_btn.setOnClickListener(v -> {
            NavDirections action = MenuFragmentDirections.actionMenuFragmentToFroyoMenuFragment();
            Navigation.findNavController(view).navigate(action);
        });
    }

    }