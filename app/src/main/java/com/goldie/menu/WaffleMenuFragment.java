package com.goldie.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WaffleMenuFragment extends Fragment { //change to pick just one

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


        classic.setOnClickListener(view13 -> {
            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
                    &&!butter.isSelected()){
                classic.setSelected(true);
                waffleObject.wafflesTypes.get(0).setAmount(1);
                something_checked=true;
            }
            else if(!classic.isSelected()&& coffee.isSelected()){
                classic.setSelected(true);
                waffleObject.wafflesTypes.get(0).setAmount(1);
                coffee.setSelected(false);
                waffleObject.wafflesTypes.get(1).setAmount(0);
            }
            else if(!classic.isSelected()&& butter.isSelected()){
                classic.setSelected(true);
                waffleObject.wafflesTypes.get(0).setAmount(1);
                butter.setSelected(false);
                waffleObject.wafflesTypes.get(2).setAmount(0);
            }
            else if(!classic.isSelected()&& chocolate.isSelected()){
                classic.setSelected(true);
                waffleObject.wafflesTypes.get(0).setAmount(1);
                chocolate.setSelected(false);
                waffleObject.wafflesTypes.get(3).setAmount(0);
            }
            else {
                classic.setSelected(false);
                waffleObject.wafflesTypes.get(0).setAmount(0);
                something_checked=false;
            }
        });

        coffee.setOnClickListener(view13 -> {
            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
                    &&!butter.isSelected()){
                coffee.setSelected(true);
                waffleObject.wafflesTypes.get(1).setAmount(1);
                something_checked=true;
            }
            else if(!coffee.isSelected()&& classic.isSelected()){
                coffee.setSelected(true);
                waffleObject.wafflesTypes.get(1).setAmount(1);
                classic.setSelected(false);
                waffleObject.wafflesTypes.get(0).setAmount(0);
            }
            else if(!coffee.isSelected()&& butter.isSelected()){
                coffee.setSelected(true);
                waffleObject.wafflesTypes.get(1).setAmount(1);
                butter.setSelected(false);
                waffleObject.wafflesTypes.get(2).setAmount(0);
            }
            else if(!coffee.isSelected()&& chocolate.isSelected()){
                coffee.setSelected(true);
                waffleObject.wafflesTypes.get(1).setAmount(1);
                chocolate.setSelected(false);
                waffleObject.wafflesTypes.get(3).setAmount(0);
            }
            else {
                coffee.setSelected(false);
                waffleObject.wafflesTypes.get(1).setAmount(0);
                something_checked=false;
            }
        });

        butter.setOnClickListener(view13 -> {
            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
                    &&!butter.isSelected()){
                butter.setSelected(true);
                waffleObject.wafflesTypes.get(2).setAmount(1);
                something_checked=true;
            }
            else if(!butter.isSelected()&& classic.isSelected()){
                butter.setSelected(true);
                waffleObject.wafflesTypes.get(2).setAmount(1);
                classic.setSelected(false);
                waffleObject.wafflesTypes.get(0).setAmount(0);
            }
            else if(!butter.isSelected()&& coffee.isSelected()){
                butter.setSelected(true);
                waffleObject.wafflesTypes.get(2).setAmount(1);
                coffee.setSelected(false);
                waffleObject.wafflesTypes.get(1).setAmount(0);
            }
            else if(!butter.isSelected()&& chocolate.isSelected()){
                butter.setSelected(true);
                waffleObject.wafflesTypes.get(2).setAmount(1);
                chocolate.setSelected(false);
                waffleObject.wafflesTypes.get(3).setAmount(0);
            }
            else {
                butter.setSelected(false);
                waffleObject.wafflesTypes.get(2).setAmount(0);
                something_checked=false;
            }
        });

        chocolate.setOnClickListener(view13 -> {
            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
                    &&!butter.isSelected()){
                chocolate.setSelected(true);
                waffleObject.wafflesTypes.get(3).setAmount(1);
                something_checked=true;
            }
            else if(!chocolate.isSelected()&& classic.isSelected()){
                chocolate.setSelected(true);
                waffleObject.wafflesTypes.get(3).setAmount(1);
                classic.setSelected(false);
                waffleObject.wafflesTypes.get(0).setAmount(0);
            }
            else if(!chocolate.isSelected()&& coffee.isSelected()){
                chocolate.setSelected(true);
                waffleObject.wafflesTypes.get(3).setAmount(1);
                coffee.setSelected(false);
                waffleObject.wafflesTypes.get(1).setAmount(0);
            }
            else if(!chocolate.isSelected()&& butter.isSelected()){
                chocolate.setSelected(true);
                waffleObject.wafflesTypes.get(3).setAmount(1);
                butter.setSelected(false);
                waffleObject.wafflesTypes.get(2).setAmount(0);
            }
            else {
                chocolate.setSelected(false);
                waffleObject.wafflesTypes.get(3).setAmount(0);
                something_checked=false;
            }
        });
        apply.setOnClickListener(v -> {
            if (something_checked) {
                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").
                        child("User1").child("Waffle").push();
                refNewOrder.setValue(waffleObject);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = WaffleMenuFragmentDirections.actionWaffleMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
            else{
                Toast.makeText(requireActivity().getApplicationContext(), "Please choose product!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}