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

public class IceCreamMenuFragment extends Fragment implements View.OnClickListener {


    RadioButton one_s, two_s, three_s, one_c, two_c, three_c, one_v, two_v, three_v, one_p, two_p, three_p;
    RadioGroup strawberry, chocolate, vanilla, pistachio,serve_in;
    Button apply;
    ImageButton selected;
    int chocolateNum = 0, strawberryNum = 0, pistachioNum = 0, vanillaNum = 0;
    ImageButton cup, cone;
    IceCreamObject iceCream;

    public IceCreamMenuFragment() {
        super(R.layout.fragment_iceream_menu);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cup = view.findViewById(R.id.cup);
        cup.setOnClickListener(this);
        cone = view.findViewById(R.id.cone);
        cone.setOnClickListener(this);

        strawberry = view.findViewById(R.id.sGroup);
        one_s = view.findViewById(R.id.one_s);
        two_s = view.findViewById(R.id.two_s);
        three_s = view.findViewById(R.id.three_s);

        chocolate = view.findViewById(R.id.cGroup);
        one_c = view.findViewById(R.id.one_c);
        two_c = view.findViewById(R.id.two_c);
        three_c = view.findViewById(R.id.three_c);

        vanilla = view.findViewById(R.id.vGroup);
        one_v = view.findViewById(R.id.one_v);
        two_v = view.findViewById(R.id.two_v);
        three_v = view.findViewById(R.id.three_v);

        pistachio = view.findViewById(R.id.pGroup);
        one_p = view.findViewById(R.id.one_p);
        two_p = view.findViewById(R.id.two_p);
        three_p = view.findViewById(R.id.three_p);
        iceCream=new IceCreamObject();
        apply = view.findViewById(R.id.applyInIceCream);
        strawberry.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_s:
                    strawberryNum = 1;
                    break;
                case R.id.two_s:
                    strawberryNum = 2;
                    break;
                case R.id.three_s:
                    strawberryNum = 3;
                    break;
            }
        });

        chocolate.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_c:
                    chocolateNum = 1;
                    break;
                case R.id.two_c:
                    chocolateNum = 2;
                    break;
                case R.id.three_c:
                    chocolateNum = 3;
                    break;
            }
        });

        vanilla.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_v:
                    vanillaNum = 1;
                    break;
                case R.id.two_v:
                    vanillaNum = 2;
                    break;
                case R.id.three_v:
                    vanillaNum = 3;
                    break;
            }
        });

        pistachio.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_p:
                    pistachioNum = 1;
                    break;
                case R.id.two_p:
                    pistachioNum = 2;
                    break;
                case R.id.three_p:
                    pistachioNum = 3;
                    break;
            }
        });
        apply.setOnClickListener(v -> {
            int total = chocolateNum + vanillaNum + strawberryNum + pistachioNum;
            if ((total > 0 && total <= 3)&&(cup.isSelected()||cone.isSelected())) {
                iceCream.product_id="Ice Cream_"+iceCream.product_id;
                for (int i = 0; i < chocolateNum; i++) iceCream.flavorArray.add("Chocolate");
                for (int i = 0; i < strawberryNum; i++) iceCream.flavorArray.add("Strawberry");
                for (int i = 0; i < vanillaNum; i++) iceCream.flavorArray.add("Vanilla");
                for (int i = 0; i < pistachioNum; i++) iceCream.flavorArray.add("Pistachio");
                iceCream.setPrice(total);
                order.put(iceCream.getProduct_id(),iceCream);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = IceCreamMenuFragmentDirections.actionIceCreamMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);
            } else if (total == 0) {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_SHORT).show();
            } else if (total > 3) {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 scoops!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup or cone!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        v.setSelected(!v.isSelected());
        if (selected != null) {
            selected.setSelected(false);
            iceCream.serveIn = "";
        }
        selected = v.findViewById(v.getId());
        if (v.isSelected()) {
            iceCream.serveIn = (String) v.getTag();
        }
    }
}
