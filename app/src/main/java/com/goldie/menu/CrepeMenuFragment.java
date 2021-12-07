package com.goldie.menu;

import static com.goldie.MainActivity.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.MainActivity;
import com.goldie.R;
import com.goldie.shoppingcart.Product;
import com.goldie.account.data.UserData;
import com.goldie.shoppingcart.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrepeMenuFragment extends Fragment implements View.OnClickListener {
    Button apply;
    RadioButton black, white;
    ImageButton strawberry, banana, berry, gummy, oreo, cream, sprinklers, chocolate_top, white_choco_top;
    RadioGroup crepe_filling;
    CrepeObject crepeObject;

    public CrepeMenuFragment() {
        super(R.layout.fragment_crepe_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        black = view.findViewById(R.id.filling_black);
        white = view.findViewById(R.id.filling_white);
        crepeObject = new CrepeObject();
        strawberry = view.findViewById(R.id.str_top);
        strawberry.setOnClickListener(this);
        banana = view.findViewById(R.id.banana_top);
        banana.setOnClickListener(this);
        berry = view.findViewById(R.id.berry_top);
        berry.setOnClickListener(this);
        gummy = view.findViewById(R.id.gummy_top);
        gummy.setOnClickListener(this);
        oreo = view.findViewById(R.id.oreo_top);
        oreo.setOnClickListener(this);
        cream = view.findViewById(R.id.cream_top);
        cream.setOnClickListener(this);
        sprinklers = view.findViewById(R.id.sprinklers_top);
        sprinklers.setOnClickListener(this);
        chocolate_top = view.findViewById(R.id.chocolate_top);
        chocolate_top.setOnClickListener(this);
        white_choco_top = view.findViewById(R.id.white_choco_top);
        white_choco_top.setOnClickListener(this);
        apply = view.findViewById(R.id.applyInCrepe);
        crepe_filling = view.findViewById(R.id.group_filling);
        crepe_filling.setOnCheckedChangeListener((group, checkedId) -> crepeObject.chocolateType = (black.getId() == group.getCheckedRadioButtonId()) ? "black" : "white");
        apply.setOnClickListener(view111 -> {
            if (!crepeObject.chocolateType.equals("")) {
                crepeObject.setAmount(crepeObject.getAmount() + 1);
                order.put(Product.product_id, crepeObject);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = CrepeMenuFragmentDirections.actionCrepeMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            } else {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick type of chocolate!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        v.setSelected(!v.isSelected());
        if (crepeObject.toppings.size() == 3) {
            v.setSelected(false);
            Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 topping!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (v.isSelected()) {
            crepeObject.toppings.add((String) v.getTag());
        } else {
            crepeObject.toppings.remove((String) v.getTag());
        }
    }
}
