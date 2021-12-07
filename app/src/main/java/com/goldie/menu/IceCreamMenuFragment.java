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

import com.goldie.MainActivity;
import com.goldie.R;
import com.goldie.account.data.UserData;
import com.goldie.shoppingcart.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IceCreamMenuFragment extends Fragment {


    RadioButton cup,cone,one_s, two_s, three_s, one_c, two_c, three_c, one_v, two_v, three_v, one_p, two_p, three_p;
    RadioGroup strawberry, chocolate, vanilla, pistachio,serve_in;
    Button apply;
    int chocolateNum = 0, strawberryNum = 0, pistachioNum = 0, vanillaNum = 0;
    IceCreamObject iceCream;

    public IceCreamMenuFragment() {
        super(R.layout.fragment_iceream_menu);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cup = view.findViewById(R.id.cup);
        cone = view.findViewById(R.id.cone);

        strawberry = view.findViewById(R.id.sGroup);
        one_s = view.findViewById(R.id.one_s);
        two_s = view.findViewById(R.id.two_s);
        three_s = view.findViewById(R.id.three_s);
        serve_in=view.findViewById(R.id.serve_in);

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
        serve_in.setOnCheckedChangeListener((group, checkedId) -> {
                    iceCream.serveIn = (cup.getId() == group.getCheckedRadioButtonId()) ? "cup" : "cone";
                }
        );

        strawberry.setOnClickListener((group) -> {
            switch (strawberry.getCheckedRadioButtonId()) {
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
            if (!iceCream.serveIn.equals("") && (total > 0 && total <= 3)) {
                for (int i = 0; i < chocolateNum; i++) iceCream.flavorArray.add("Chocolate");
                for (int i = 0; i < strawberryNum; i++) iceCream.flavorArray.add("Strawberry");
                for (int i = 0; i < vanillaNum; i++) iceCream.flavorArray.add("Vanilla");
                for (int i = 0; i < pistachioNum; i++) iceCream.flavorArray.add("Pistachio");
                iceCream.setPrice(total);
                order.put(Product.product_id,iceCream);
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
}
