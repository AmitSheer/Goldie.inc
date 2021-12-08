package com.goldie.menu;

import static com.goldie.MainActivity.order;

import android.annotation.SuppressLint;
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

import com.goldie.R;
import com.goldie.shoppingcart.Product;

public class FroyoMenuFragment extends Fragment implements View.OnClickListener {

    Button apply;
    ImageButton small, medium, large, kiwi, peach, mango, blueberry, strawberry, blackberry;
    ImageButton selectedFlave, selectedSize;
    boolean something_checked = false;
    FroyoObject frozen = new FroyoObject();


    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        small = view.findViewById(R.id.small);
        small.setOnClickListener(this);
        medium = view.findViewById(R.id.medium);
        medium.setOnClickListener(this);
        large = view.findViewById(R.id.large);
        large.setOnClickListener(this);
        kiwi = view.findViewById(R.id.kiviImage);
        kiwi.setOnClickListener(this);
        peach = view.findViewById(R.id.peachImage);
        peach.setOnClickListener(this);
        mango = view.findViewById(R.id.magoImage);
        mango.setOnClickListener(this);
        blueberry = view.findViewById(R.id.blueberryImage);
        blueberry.setOnClickListener(this);
        strawberry = view.findViewById(R.id.strawberryImage);
        strawberry.setOnClickListener(this);
        blackberry = view.findViewById(R.id.blackberryImage);
        blackberry.setOnClickListener(this);
        apply = view.findViewById(R.id.applyInFroyo);

        apply.setOnClickListener(v -> {
            if ((large.isSelected() || medium.isSelected() || small.isSelected()) && something_checked) {
                frozen.product_id="Froyo_"+frozen.product_id;
                order.put(frozen.getProduct_id(), frozen);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = FroyoMenuFragmentDirections.actionFroyoMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);

            } else if (!something_checked) {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_SHORT).show();
            } else if (!large.isSelected() && !medium.isSelected() && !small.isSelected()) {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup size!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kiviImage:
            case R.id.magoImage:
            case R.id.peachImage:
            case R.id.blueberryImage:
            case R.id.strawberryImage:
            case R.id.blackberryImage:
                v.setSelected(!v.isSelected());
                if (selectedFlave != null) {
                    selectedFlave.setSelected(false);
                    frozen.flavor = "";
                    something_checked = false;
                }
                selectedFlave = v.findViewById(v.getId());
                if (v.isSelected()) {
                    frozen.flavor = (String) v.getTag();
                    something_checked = true;
                }
                break;
            case R.id.small:
            case R.id.medium:
            case R.id.large:
                v.setSelected(!v.isSelected());
                if (selectedSize != null) {
                    selectedSize.setSelected(false);
                    frozen.cupSize = "";
                }
                selectedSize = v.findViewById(v.getId());
                if (v.isSelected()) {
                    frozen.cupSize = (String) v.getTag();
                }
                break;
        }
    }
}