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
    CrepeObject crepeObject;
    Button apply;
    ImageButton black,white,strawberry, banana, berry, gummy, oreo, cream, sprinklers, chocolate_top, white_choco_top;

    public CrepeMenuFragment() {
        super(R.layout.fragment_crepe_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crepeObject= new CrepeObject();
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
                crepeObject.setDarkChocolate(true);
            }

            else if (!black.isSelected() && white.isSelected()) {
                white.setSelected(false);
                crepeObject.setWhiteChocolate(false);
                black.setSelected(true);
                crepeObject.setDarkChocolate(true);
            }

            else {
                black.setSelected(false);
                crepeObject.setDarkChocolate(false);
            }
        });

        white.setOnClickListener(view1 -> {
            if (!white.isSelected() && !black.isSelected()) {
                white.setSelected(true);
                crepeObject.setWhiteChocolate(true);
            }

            else if (!white.isSelected() && black.isSelected()) {
                black.setSelected(false);
                crepeObject.setDarkChocolate(false);
                white.setSelected(true);
                crepeObject.setWhiteChocolate(true);
            }

            else {
                white.setSelected(false);
                crepeObject.setWhiteChocolate(false);
            }
        });

        strawberry.setOnClickListener(view13 -> {
            if (!strawberry.isSelected()) {
                strawberry.setSelected(true);
                crepeObject.setStrawberry(true);
            }
            else {
                strawberry.setSelected(false);
                crepeObject.setStrawberry(false);
            }
        });

        banana.setOnClickListener(view12 -> {
            if (!banana.isSelected()) {
                banana.setSelected(true);
                crepeObject.setBanana(true);
            }
            else {
                banana.setSelected(false);
                crepeObject.setBanana(false);
            }
        });

        berry.setOnClickListener(view14 -> {
            if (!berry.isSelected()) {
                berry.setSelected(true);
                crepeObject.setBlueberry(true);
            }
            else {
                berry.setSelected(false);
                crepeObject.setBlueberry(false);
            }
        });

        gummy.setOnClickListener(view15 -> {
            if (!gummy.isSelected()) {
                gummy.setSelected(true);
                crepeObject.setGummybears(true);
            }
            else {
                gummy.setSelected(false);
                crepeObject.setGummybears(false);
            }
        });

        oreo.setOnClickListener(view16 -> {
            if (!oreo.isSelected()) {
                oreo.setSelected(true);
                crepeObject.setOreo(true);
            }
            else {
                oreo.setSelected(false);
                crepeObject.setOreo(false);
            }
        });

        cream.setOnClickListener(view17 -> {
            if (!cream.isSelected()) {
                cream.setSelected(true);
                crepeObject.setCream(true);
            }
            else {
                cream.setSelected(false);
                crepeObject.setCream(false);
            }
        });

        sprinklers.setOnClickListener(view18 -> {
            if (!sprinklers.isSelected()) {
                sprinklers.setSelected(true);
                crepeObject.setSprinklers(true);
            }
            else {
                sprinklers.setSelected(false);
                crepeObject.setSprinklers(false);
            }
        });

        chocolate_top.setOnClickListener(view19 -> {
            if (!chocolate_top.isSelected()) {
                chocolate_top.setSelected(true);
                crepeObject.setDarkChocolateTop(true);
            }
            else {
                chocolate_top.setSelected(false);
                crepeObject.setDarkChocolateTop(false);
            }
        });

        white_choco_top.setOnClickListener(view110 -> {
            if (!white_choco_top.isSelected()) {
                white_choco_top.setSelected(true);
                crepeObject.setWhiteChocolateTop(true);
            }
            else {
                white_choco_top.setSelected(false);
                crepeObject.setWhiteChocolateTop(false);
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
