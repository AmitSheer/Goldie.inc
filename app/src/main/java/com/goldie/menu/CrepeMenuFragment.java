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
                crepeObject.chocolateType[0].setAmount(1);
            }

            else if (!black.isSelected() && white.isSelected()) {
                white.setSelected(false);
                crepeObject.chocolateType[1].setAmount(0);
                black.setSelected(true);
                crepeObject.chocolateType[0].setAmount(1);
            }

            else {
                black.setSelected(false);
                crepeObject.chocolateType[0].setAmount(0);
            }
        });

        white.setOnClickListener(view1 -> {
            if (!white.isSelected() && !black.isSelected()) {
                white.setSelected(true);
                crepeObject.chocolateType[1].setAmount(1);
            }

            else if (!white.isSelected() && black.isSelected()) {
                black.setSelected(false);
                crepeObject.chocolateType[0].setAmount(0);
                white.setSelected(true);
                crepeObject.chocolateType[1].setAmount(1);
            }

            else {
                white.setSelected(false);
                crepeObject.chocolateType[1].setAmount(0);
            }
        });

        strawberry.setOnClickListener(view13 -> {
            if (!strawberry.isSelected()) {
                strawberry.setSelected(true);
                crepeObject.toppings[0].setAmount(1);
            }
            else {
                strawberry.setSelected(false);
                crepeObject.toppings[0].setAmount(0);
            }
        });

        banana.setOnClickListener(view12 -> {
            if (!banana.isSelected()) {
                banana.setSelected(true);
                crepeObject.toppings[1].setAmount(1);
            }
            else {
                banana.setSelected(false);
                crepeObject.toppings[1].setAmount(0);
            }
        });

        berry.setOnClickListener(view14 -> {
            if (!berry.isSelected()) {
                berry.setSelected(true);
                crepeObject.toppings[2].setAmount(1);
            }
            else {
                berry.setSelected(false);
                crepeObject.toppings[2].setAmount(0);
            }
        });

        gummy.setOnClickListener(view15 -> {
            if (!gummy.isSelected()) {
                gummy.setSelected(true);
                crepeObject.toppings[3].setAmount(1);
            }
            else {
                gummy.setSelected(false);
                crepeObject.toppings[3].setAmount(0);
            }
        });

        oreo.setOnClickListener(view16 -> {
            if (!oreo.isSelected()) {
                oreo.setSelected(true);
                crepeObject.toppings[4].setAmount(1);
            }
            else {
                oreo.setSelected(false);
                crepeObject.toppings[4].setAmount(0);
            }
        });

        cream.setOnClickListener(view17 -> {
            if (!cream.isSelected()) {
                cream.setSelected(true);
                crepeObject.toppings[5].setAmount(1);
            }
            else {
                cream.setSelected(false);
                crepeObject.toppings[5].setAmount(0);
            }
        });

        sprinklers.setOnClickListener(view18 -> {
            if (!sprinklers.isSelected()) {
                sprinklers.setSelected(true);
                crepeObject.toppings[6].setAmount(1);
            }
            else {
                sprinklers.setSelected(false);
                crepeObject.toppings[6].setAmount(0);
            }
        });

        chocolate_top.setOnClickListener(view19 -> {
            if (!chocolate_top.isSelected()) {
                chocolate_top.setSelected(true);
                crepeObject.toppings[7].setAmount(1);
            }
            else {
                chocolate_top.setSelected(false);
                crepeObject.toppings[7].setAmount(0);
            }
        });

        white_choco_top.setOnClickListener(view110 -> {
            if (!white_choco_top.isSelected()) {
                white_choco_top.setSelected(true);
                crepeObject.toppings[8].setAmount(1);
            }
            else {
                white_choco_top.setSelected(false);
                crepeObject.toppings[8].setAmount(0);
            }
        });

        apply.setOnClickListener(view111 -> {
            if (black.isSelected() || white.isSelected()) {
                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").push();
                refNewOrder.setValue(crepeObject);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_LONG).show();
                NavDirections action = CrepeMenuFragmentDirections.actionCrepeMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
            else{
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick type of chocolate!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
