package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WaffleMenuFragment extends Fragment {

    WaffleObject waffleObject = new WaffleObject();
    ImageButton classic,coffee,butter,chocolate;
    Button apply;
    boolean something_checked=false;

    public WaffleMenuFragment() {
        super(R.layout.fragment_waffle_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        waffleObject= new WaffleObject();
        classic = view.findViewById(R.id.waffleBtn);
        coffee = view.findViewById(R.id.coffeeBtn);
        butter = view.findViewById(R.id.ButterBtn);
        chocolate = view.findViewById(R.id.ChocolateBtn);
        apply = view.findViewById(R.id.applyInWaffle);


        classic.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles.get(0).setAmount(1);
                    checkActionOpen = true;
                    classic.setSelected(true);
                    something_checked=true;
                }
                else {
                    waffleObject.waffles.get(0).setAmount(0);
                    checkActionOpen = false;
                    something_checked=false;
                    classic.setSelected(false);
                }
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles.get(1).setAmount(1);
                    checkActionOpen = true;
                    something_checked=true;
                    coffee.setSelected(true);
                }
                else {
                    waffleObject.waffles.get(1).setAmount(0);
                    checkActionOpen = false;
                    something_checked=false;
                    coffee.setSelected(false);
                }
            }
        });

        butter.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles.get(2).setAmount(1);
                    checkActionOpen = true;
                    something_checked=true;
                    butter.setSelected(true);
                }
                else {
                    waffleObject.waffles.get(2).setAmount(0);
                    checkActionOpen = false;
                    something_checked=false;
                    butter.setSelected(false);
                }
            }
        });

        chocolate.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles.get(3).setAmount(1);
                    checkActionOpen = true;
                    something_checked=true;
                    chocolate.setSelected(true);
                }
                else {
                    waffleObject.waffles.get(3).setAmount(0);
                    checkActionOpen = false;
                    something_checked=false;
                    chocolate.setSelected(false);
                }
            }
        });

        apply.setOnClickListener(v -> {
            if (something_checked) {
                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders")
                        .child("1").child("Waffle").push();
                refNewOrder.setValue(waffleObject);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_LONG).show();
                NavDirections action = WaffleMenuFragmentDirections.actionWaffleMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
            else{
                Toast.makeText(requireActivity().getApplicationContext(), "Please choose product!", Toast.LENGTH_LONG).show();
            }
        });

    }
}