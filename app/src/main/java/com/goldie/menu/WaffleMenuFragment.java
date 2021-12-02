package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.goldie.R;

public class WaffleMenuFragment extends Fragment {

    WaffleObject waffleObject;
    ImageButton classic,coffee,butter,chocolate;
    Button apply;

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
                    waffleObject.waffles[0].setAmount(1);
                    checkActionOpen = true;
                    classic.setSelected(true);
                }
                else {
                    waffleObject.waffles[0].setAmount(0);
                    checkActionOpen = false;
                    classic.setSelected(false);
                }
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles[1].setAmount(1);
                    checkActionOpen = true;
                    coffee.setSelected(true);
                }
                else {
                    waffleObject.waffles[1].setAmount(0);
                    checkActionOpen = false;
                    coffee.setSelected(false);
                }
            }
        });

        butter.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles[2].setAmount(1);
                    checkActionOpen = true;
                    butter.setSelected(true);
                }
                else {
                    waffleObject.waffles[2].setAmount(0);
                    checkActionOpen = false;
                    butter.setSelected(false);
                }
            }
        });

        chocolate.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    waffleObject.waffles[3].setAmount(1);
                    checkActionOpen = true;
                    chocolate.setSelected(true);
                }
                else {
                    waffleObject.waffles[3].setAmount(0);
                    checkActionOpen = false;
                    chocolate.setSelected(false);
                }
            }
        });

        apply.setOnClickListener(v -> {

        });

    }
}