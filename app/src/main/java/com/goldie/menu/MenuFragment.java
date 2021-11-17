package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;


public class MenuFragment extends Fragment {

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton ice_btn = view.findViewById(R.id.icecream);
////        ice_btn.setOnClickListener(v -> openIceCreamPage());
        ImageButton waffle_btn = view.findViewById(R.id.waffle);
////        waffle_btn.setOnClickListener(v -> openWafflePage());
        ImageButton crepe_btn = view.findViewById(R.id.crepes);
////        crepe_btn.setOnClickListener(v -> openCrepePage());
        ImageButton froyo_btn = view.findViewById(R.id.froyo);
//        froyo_btn.setOnClickListener(v -> openFroyoPage());
        ice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToIceCreamMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
        waffle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToWaffleMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
        crepe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToCrepeMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
        froyo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = MenuFragmentDirections.actionMenuFragmentToFroyoMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
//    public void openIceCreamPage(){
//        Intent intent = new Intent(this, IceCreamMenuFragment.class);
//        startActivity(intent);
//    }
//
//    public void openWafflePage(){
//        Intent intent = new Intent(this, waffle_menu.class);
//        startActivity(intent);
//    }
//    public void openCrepePage(){
//        Intent intent = new Intent(this, crepe_menu.class);
//        startActivity(intent);
//    }
//
//    public void openFroyoPage(){
//        Intent intent = new Intent(this, FroyoMenuFragment.class);
//        startActivity(intent);
//    }

    }