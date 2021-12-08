package com.goldie.shop.menu;

import static com.goldie.shop.ShopActivity.order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;
import com.goldie.shop.shoppingcart.Product;

public class FroyoMenuFragment extends Fragment {

    Button apply;
    RadioGroup size, flavor_1, flavor_2;
    RadioButton small, medium, large, kiwi, peach, mango, blueberry, strawberry, blackberry;
    FroyoObject frozen;
    int flag=0;
    RadioButton selected;
    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frozen = new FroyoObject();
        small = view.findViewById(R.id.small_cup);
        medium = view.findViewById(R.id.medium_cup);
        large = view.findViewById(R.id.large_cup);
        kiwi = view.findViewById(R.id.kiwi);
        peach = view.findViewById(R.id.peach);
        mango = view.findViewById(R.id.mango);
        blueberry = view.findViewById(R.id.blueberry);
        strawberry = view.findViewById(R.id.strawberry);
        blackberry = view.findViewById(R.id.blackberry);
        apply = view.findViewById(R.id.applyInFroyo);
        flavor_2 = view.findViewById(R.id.flavor_2);
        flavor_1 = view.findViewById(R.id.flavor_1);
        size = view.findViewById(R.id.size);
        size.setOnCheckedChangeListener(((group, checkedId) -> {
            switch (group.getCheckedRadioButtonId()) {
                case R.id.small_cup: {
                    frozen.cupSize = "small";
                    frozen.setPrice(3);
                    large.setSelected(false);
                    medium.setSelected(false);
                    small.setSelected(true);
                    break;
                }
                case R.id.medium_cup: {
                    frozen.cupSize = "medium";
                    frozen.setPrice(4);

                    large.setSelected(false);
                    small.setSelected(false);
                    medium.setSelected(true);
                    break;
                }
                case R.id.large_cup: {
                    frozen.cupSize = "large";
                    frozen.setPrice(5);
                    small.setSelected(false);
                    medium.setSelected(false);
                    large.setSelected(true);
                    break;
                }
            }
        }));
        flavor_1.setOnCheckedChangeListener((group, checkedId) -> {
                    if(selected!=null)
                        selected.setSelected(false);
                    switch (group.getCheckedRadioButtonId()) {
                        case R.id.kiwi: {
                            frozen.flavor = "kiwi";
                            kiwi.setSelected(true);
                            selected=kiwi;
                            break;
                        }
                        case R.id.peach: {
                            frozen.flavor = "peach";
                            peach.setSelected(true);
                            selected=peach;
                            break;
                        }
                        case R.id.mango: {
                            frozen.flavor = "mango";
                            mango.setSelected(true);
                            selected=mango;
                            break;
                        }
                    }
                   // flag=1;
                   // flavor_1.setSelected(true);
                }
        );

        flavor_2.setOnCheckedChangeListener((group, checkedId) -> {
                    if (selected!=null)
                        selected.setSelected(false);
                    switch (group.getCheckedRadioButtonId()) {
                        case R.id.blueberry: {
                            frozen.flavor = "blueberry";
                            blueberry.setSelected(true);
                            selected=blueberry;
                            break;
                        }
                        case R.id.strawberry: {
                            frozen.flavor = "strawberry";
                            strawberry.setSelected(true);
                            selected=strawberry;
                            break;
                        }
                        case R.id.blackberry: {
                            frozen.flavor = "blackberry";
                            blackberry.setSelected(true);
                            selected=blackberry;
                            break;
                        }
                    }
                    flag=2;
                }
        );

        apply.setOnClickListener(v -> {
            if (!frozen.flavor.equals("") && !frozen.cupSize.equals("")) {
                order.put(Product.product_id, frozen);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = FroyoMenuFragmentDirections.actionFroyoMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            } else {
                if (frozen.flavor.equals("")) {
                    Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup size!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}