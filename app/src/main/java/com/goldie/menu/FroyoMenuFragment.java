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

public class FroyoMenuFragment extends Fragment {

    ImageButton small, medium, large, kiwi, peach, mango, blueberry, strawberry, blackberry;

    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        small = view.findViewById(R.id.small);
        medium = view.findViewById(R.id.medium);
        large = view.findViewById(R.id.large);
        kiwi = view.findViewById(R.id.kiviImage);
        peach = view.findViewById(R.id.peachImage);
        mango = view.findViewById(R.id.magoImage);
        blueberry = view.findViewById(R.id.blueberryImage);
        strawberry = view.findViewById(R.id.strawberryImage);
        blackberry = view.findViewById(R.id.blackberryImage);

        small.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    small.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    small.setSelected(false);
                }
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    medium.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    medium.setSelected(false);
                }
            }
        });

        large.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    large.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    large.setSelected(false);
                }
            }
        });

        kiwi.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    kiwi.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    kiwi.setSelected(false);
                }
            }
        });

        peach.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    peach.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    peach.setSelected(false);
                }
            }
        });

        mango.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    mango.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    mango.setSelected(false);
                }
            }
        });

        blueberry.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    blueberry.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    blueberry.setSelected(false);
                }
            }
        });

        strawberry.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    strawberry.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    strawberry.setSelected(false);
                }
            }
        });

        blackberry.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    blackberry.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    blackberry.setSelected(false);
                }
            }
        });
    }
}