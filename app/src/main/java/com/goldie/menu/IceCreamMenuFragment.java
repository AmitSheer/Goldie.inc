package com.goldie.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.goldie.R;

public class IceCreamMenuFragment extends Fragment{

    IceCreamObject iceCreamObject;
    RadioButton one_s, two_s, three_s, one_c, two_c, three_c, one_v, two_v, three_v, one_p, two_p, three_p;
    ImageButton cup, cone;
    RadioGroup strawberry, chocolate, vanilla, pistachio;
    Button apply;

    public IceCreamMenuFragment() {
        super(R.layout.fragment_iceream_menu);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iceCreamObject = new IceCreamObject();
        cup = view.findViewById(R.id.cup);
        cone = view.findViewById(R.id.cone);

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

        apply = view.findViewById(R.id.applyInIceCream);

        cup.setOnClickListener(view1 -> {
            if (!cup.isSelected() && !cone.isSelected()) {
                iceCreamObject.setCup(true);
                cup.setSelected(true);
            } else if (!cup.isSelected() && cone.isSelected()) {
                iceCreamObject.setCup(true);
                iceCreamObject.setCone(false);
                cone.setSelected(false);
                cup.setSelected(true);
            } else {
                iceCreamObject.setCup(false);
                cup.setSelected(false);
            }
        });

        cone.setOnClickListener(view1 -> {
            if (!cone.isSelected() && !cup.isSelected()) {
                iceCreamObject.setCone(true);
                cone.setSelected(true);
            } else if (!cone.isSelected() && cup.isSelected()) {
                iceCreamObject.setCone(true);
                iceCreamObject.setCup(false);
                cup.setSelected(false);
                cone.setSelected(true);
            } else {
                iceCreamObject.setCone(false);
                cone.setSelected(false);
            }
        });

        strawberry.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_s:
                    iceCreamObject.setStrawberry(1);
                    break;
                case R.id.two_s:
                    iceCreamObject.setStrawberry(2);
                    break;
                case R.id.three_s:
                    iceCreamObject.setStrawberry(3);
            }
        });

        chocolate.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_c:
                    iceCreamObject.setChocolate(1);
                    break;
                case R.id.two_c:
                    iceCreamObject.setChocolate(2);
                    break;
                case R.id.three_c:
                    iceCreamObject.setChocolate(3);
            }
        });

        vanilla.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_v:
                    iceCreamObject.setVanilla(1);
                    break;
                case R.id.two_v:
                    iceCreamObject.setVanilla(2);
                    break;
                case R.id.three_v:
                    iceCreamObject.setVanilla(3);
            }
        });

        pistachio.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_p:
                    iceCreamObject.setPistachio(1);
                    break;
                case R.id.two_p:
                    iceCreamObject.setPistachio(2);
                    break;
                case R.id.three_p:
                    iceCreamObject.setPistachio(3);
            }
        });

        apply.setOnClickListener(v -> {

        });
    }


}
