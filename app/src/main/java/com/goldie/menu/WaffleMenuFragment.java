package com.goldie.menu;

import static com.goldie.MainActivity.order;

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

public class WaffleMenuFragment extends Fragment implements View.OnClickListener {

    ImageButton classic, coffee, butter, chocolate;
    Button apply;
    ImageButton selected;
    WaffleObject waffle;

    public WaffleMenuFragment() {
        super(R.layout.fragment_waffle_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        classic = view.findViewById(R.id.waffleBtn);
        classic.setOnClickListener(this);
        coffee = view.findViewById(R.id.coffeeBtn);
        coffee.setOnClickListener(this);
        butter = view.findViewById(R.id.ButterBtn);
        butter.setOnClickListener(this);
        chocolate = view.findViewById(R.id.ChocolateBtn);
        chocolate.setOnClickListener(this);
        apply = view.findViewById(R.id.applyInWaffle);

        waffle = new WaffleObject();

        apply.setOnClickListener(v -> {
            if (!waffle.waffleType.equals("")) {
                if (waffle.waffleType.equals("classic")) {
                    waffle.setPrice(8);
                } else {
                    if (waffle.waffleType.equals("coffee"))
                        waffle.setPrice(9);
                    else {
                        waffle.setPrice(10);
                    }
                }
                order.put(Product.product_id, waffle);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = WaffleMenuFragmentDirections.actionWaffleMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            } else {
                Toast.makeText(requireActivity().getApplicationContext(), "Please choose product!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        v.setSelected(!v.isSelected());
        if (selected != null) {
            selected.setSelected(false);
            waffle.waffleType = "";
        }
        selected = v.findViewById(v.getId());
        if (v.isSelected()) {
            waffle.waffleType = (String) v.getTag();
        }
    }
}