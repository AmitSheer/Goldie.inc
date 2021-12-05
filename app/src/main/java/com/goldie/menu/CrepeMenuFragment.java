package com.goldie.menu;

import android.content.Intent;
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
import com.goldie.account.data.UserData;
import com.goldie.shoppingcart.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CrepeMenuFragment extends Fragment {
    Button apply;
    ImageButton black,white,strawberry, banana, berry, gummy, oreo, cream, sprinklers, chocolate_top, white_choco_top;
    int numOfTopping=0;

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

        strawberry.setOnClickListener(view13 -> {
            if (!strawberry.isSelected()) {
                strawberry.setSelected(true);
                numOfTopping++;
            }
            else {
                strawberry.setSelected(false);
                numOfTopping--;
            }
        });

        banana.setOnClickListener(view12 -> {
            if (!banana.isSelected()) {
                banana.setSelected(true);
                numOfTopping++;
            }
            else {
                banana.setSelected(false);
                numOfTopping--;
            }
        });

        berry.setOnClickListener(view14 -> {
            if (!berry.isSelected()) {
                berry.setSelected(true);
                numOfTopping++;
            }
            else {
                berry.setSelected(false);
                numOfTopping--;
            }
        });

        gummy.setOnClickListener(view15 -> {
            if (!gummy.isSelected()) {
                gummy.setSelected(true);
                numOfTopping++;
            }
            else {
                gummy.setSelected(false);
                numOfTopping--;
            }
        });

        oreo.setOnClickListener(view16 -> {
            if (!oreo.isSelected()) {
                oreo.setSelected(true);
                numOfTopping++;
            }
            else {
                oreo.setSelected(false);
                numOfTopping--;
            }
        });

        cream.setOnClickListener(view17 -> {
            if (!cream.isSelected()) {
                cream.setSelected(true);
                numOfTopping++;
            }
            else {
                cream.setSelected(false);
                numOfTopping--;
            }
        });

        sprinklers.setOnClickListener(view18 -> {
            if (!sprinklers.isSelected()) {
                sprinklers.setSelected(true);
                numOfTopping++;
            }
            else {
                sprinklers.setSelected(false);
                numOfTopping--;
            }
        });

        chocolate_top.setOnClickListener(view19 -> {
            if (!chocolate_top.isSelected()) {
                chocolate_top.setSelected(true);
                numOfTopping++;
            }
            else {
                chocolate_top.setSelected(false);
                numOfTopping--;
            }
        });

        white_choco_top.setOnClickListener(view110 -> {
            if (!white_choco_top.isSelected()) {
                white_choco_top.setSelected(true);
                numOfTopping++;
            }
            else {
                white_choco_top.setSelected(false);
                numOfTopping--;
            }
        });

        apply.setOnClickListener(view111 -> {
            if (black.isSelected() || white.isSelected()&&numOfTopping<=3) {
                Product chocolateType;
                ArrayList<Product> topping = new ArrayList<>();
                if (black.isSelected()){
                    chocolateType = new Product("Dark chocolate", 1, 0, 1);
                }
                else {
                    chocolateType = new Product("White chocolate", 1, 0, 1);
                }
                int i = 0;
                if (strawberry.isSelected()) {
                    topping.add(i, new Product("Strawberry", 1, 1, 1));
                    i++;
                }
                if (banana.isSelected()) {
                    topping.add(i, new Product("Banana", 1, 1, 1));
                    i++;
                }
                if (berry.isSelected()) {
                    topping.add(i, new Product("Blueberry", 1, 1, 1));
                    i++;
                }
                if (gummy.isSelected()) {
                    topping.add(i, new Product("Gummy Bears", 1, 2, 1));
                }
                if (oreo.isSelected()) {
                    topping.add(i, new Product("Oreo", 1, 2, 1));
                    i++;
                }
                if (cream.isSelected()) {
                    topping.add(i, new Product("Whipped Cream", 1, 0, 1));
                    i++;
                }
                if (sprinklers.isSelected()) {
                    topping.add(i, new Product("Sprinklers", 1, 0, 1));
                    i++;
                }
                if (chocolate_top.isSelected()) {
                    topping.add(i, new Product("Dark Chocolate Topping", 1, 1, 1));
                }
                if (white_choco_top.isSelected()) {
                    topping.add(i, new Product("White Chocolate Topping", 1, 1, 1));
                }
                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").
                        child(UserData.Uid).child("Crepe").push();
                CrepeObject crepeObject = new CrepeObject(chocolateType,topping);
                refNewOrder.setValue(crepeObject);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = CrepeMenuFragmentDirections.actionCrepeMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            }
            else if (numOfTopping>3){
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 toppings!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick type of chocolate!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
