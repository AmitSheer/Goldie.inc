package com.goldie.menu;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class IceCreamMenuFragment extends Fragment {

    IceCreamObject iceCreamObject = new IceCreamObject();
    RadioButton one_s, two_s, three_s, one_c, two_c, three_c, one_v, two_v, three_v, one_p, two_p, three_p;
    ImageButton cup, cone;
    RadioGroup strawberry, chocolate, vanilla, pistachio;
    Button apply;
    boolean something_checked= false;


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
                iceCreamObject.serveIn.get(0).setAmount(1);
                cup.setSelected(true);
            } else if (!cup.isSelected() && cone.isSelected()) {
                iceCreamObject.serveIn.get(0).setAmount(1);
                iceCreamObject.serveIn.get(1).setAmount(0);
                cone.setSelected(false);
                cup.setSelected(true);
            } else {
                iceCreamObject.serveIn.get(0).setAmount(0);
                cup.setSelected(false);
            }
        });

        cone.setOnClickListener(view1 -> {
            if (!cone.isSelected() && !cup.isSelected()) {
                iceCreamObject.serveIn.get(1).setAmount(1);
                cone.setSelected(true);
            } else if (!cone.isSelected() && cup.isSelected()) {
                iceCreamObject.serveIn.get(1).setAmount(1);
                iceCreamObject.serveIn.get(0).setAmount(0);
                cup.setSelected(false);
                cone.setSelected(true);
            } else {
                iceCreamObject.serveIn.get(1).setAmount(0);
                cone.setSelected(false);
            }
        });

        strawberry.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_s:
                    iceCreamObject.flavor.get(3).setAmount(1);
                    something_checked=true;
                    break;
                case R.id.two_s:
                    iceCreamObject.flavor.get(3).setAmount(2);
                    something_checked=true;
                    break;
                case R.id.three_s:
                    iceCreamObject.flavor.get(3).setAmount(3);
                    something_checked=true;
            }
        });

        chocolate.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_c:
                    iceCreamObject.flavor.get(1).setAmount(1);
                    something_checked=true;
                    break;
                case R.id.two_c:
                    iceCreamObject.flavor.get(1).setAmount(2);
                    something_checked=true;
                    break;
                case R.id.three_c:
                    iceCreamObject.flavor.get(1).setAmount(3);
                    something_checked=true;
            }
        });

        vanilla.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_v:
                    iceCreamObject.flavor.get(0).setAmount(1);
                    something_checked=true;
                    break;
                case R.id.two_v:
                    iceCreamObject.flavor.get(0).setAmount(2);
                    something_checked=true;
                    break;
                case R.id.three_v:
                    iceCreamObject.flavor.get(0).setAmount(3);
                    something_checked=true;
            }
        });

        pistachio.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_p:
                    iceCreamObject.flavor.get(2).setAmount(1);
                    break;
                case R.id.two_p:
                    iceCreamObject.flavor.get(2).setAmount(2);
                    break;
                case R.id.three_p:
                    iceCreamObject.flavor.get(2).setAmount(3);
            }
        });

        apply.setOnClickListener(v -> {
            if ((cup.isSelected() || cone.isSelected())&&something_checked){
//add id before "ice cream"
                    DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").child("1").child("Ice cream").push();
                    refNewOrder.setValue(iceCreamObject);
                    Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_LONG).show();
                    NavDirections action = IceCreamMenuFragmentDirections.actionIceCreamMenuFragmentToMenuFragment();
                    Navigation.findNavController(view).navigate(action);
                }
            else if (!something_checked){
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_LONG).show();
            }
            else if (!cup.isSelected()&&!cone.isSelected()){
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup or cone!", Toast.LENGTH_LONG).show();

            }
        });
    }


}
