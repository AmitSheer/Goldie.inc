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

public class CrepeMenuFragment extends Fragment {
    Button apply;
    ImageButton black,white,strawberry, banana, berry, gummy, oreo, cream, sprinklers, chocolate_top, white_choco_top;

    public CrepeMenuFragment() {
        super(R.layout.fragment_crepe_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        black = view.findViewById(R.id.black);
        white = view.findViewById(R.id.white);
        strawberry = view.findViewById(R.id.str_top);
        banana = view.findViewById(R.id.banana_top);
        berry = view.findViewById(R.id.berry_top);
        gummy = view.findViewById(R.id.gummy_top);
        oreo = view.findViewById(R.id.oreo_top);
        cream = view.findViewById(R.id.cream_top);
        sprinklers = view.findViewById(R.id.sprinklers_top);
        chocolate_top = view.findViewById(R.id.chocolate_top);
        white_choco_top = view.findViewById(R.id.white_choco_top);
        apply = view.findViewById(R.id.applyInCrepe);



        black.setOnClickListener(view1 -> {
            if (!black.isSelected() && !white.isSelected()) {
                black.setSelected(true);
            }

            else if (!black.isSelected() && white.isSelected()) {
                white.setSelected(false);
                black.setSelected(true);
            }

            else {
                black.setSelected(false);
            }
        });

        white.setOnClickListener(view1 -> {
            if (!white.isSelected() && !black.isSelected()) {
                white.setSelected(true);
            }

            else if (!white.isSelected() && black.isSelected()) {
                black.setSelected(false);
                white.setSelected(true);
            }

            else {
                white.setSelected(false);
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

        banana.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    banana.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    banana.setSelected(false);
                }
            }
        });

        berry.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    berry.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    berry.setSelected(false);
                }
            }
        });

        gummy.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    gummy.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    gummy.setSelected(false);
                }
            }
        });

        oreo.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    oreo.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    oreo.setSelected(false);
                }
            }
        });

        cream.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    cream.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    cream.setSelected(false);
                }
            }
        });

        sprinklers.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    sprinklers.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    sprinklers.setSelected(false);
                }
            }
        });

        chocolate_top.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    chocolate_top.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    chocolate_top.setSelected(false);
                }
            }
        });

        white_choco_top.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    white_choco_top.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    white_choco_top.setSelected(false);
                }
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!black.isSelected() && !white.isSelected()) {
                    // don't allow
                }
            }
        });
    }

//    public void openMenuPage(){
//        Intent intent = new Intent(this, MenuFragment.class);
//        startActivity(intent);
//    }
}
