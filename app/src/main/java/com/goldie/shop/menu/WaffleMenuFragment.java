package com.goldie.shop.menu;

import static com.goldie.shop.ShopActivity.order;

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
import com.goldie.shop.shoppingcart.Product;

public class WaffleMenuFragment extends Fragment implements View.OnClickListener { //change to pick just one

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
//        classic.setOnClickListener(view13 -> {
//            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
//                    &&!butter.isSelected()){
//                classic.setSelected(true);
//            }
//            else if(!classic.isSelected()&& coffee.isSelected()){
//                classic.setSelected(true);
//                coffee.setSelected(false);
//            }
//            else if(!classic.isSelected()&& butter.isSelected()){
//                classic.setSelected(true);
//                butter.setSelected(false);
//            }
//            else if(!classic.isSelected()&& chocolate.isSelected()){
//                classic.setSelected(true);
//                chocolate.setSelected(false);
//            }
//            else {
//                classic.setSelected(false);
//            }
//        });
//
//        coffee.setOnClickListener(view13 -> {
//            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
//                    &&!butter.isSelected()){
//                coffee.setSelected(true);
//            }
//            else if(!coffee.isSelected()&& classic.isSelected()){
//                coffee.setSelected(true);
//                classic.setSelected(false);
//            }
//            else if(!coffee.isSelected()&& butter.isSelected()){
//                coffee.setSelected(true);
//                butter.setSelected(false);
//            }
//            else if(!coffee.isSelected()&& chocolate.isSelected()){
//                coffee.setSelected(true);
//                chocolate.setSelected(false);
//            }
//            else {
//                coffee.setSelected(false);
//            }
//        });
//
//        butter.setOnClickListener(view13 -> {
//            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
//                    &&!butter.isSelected()){
//                butter.setSelected(true);
//            }
//            else if(!butter.isSelected()&& classic.isSelected()){
//                butter.setSelected(true);
//                classic.setSelected(false);
//            }
//            else if(!butter.isSelected()&& coffee.isSelected()){
//                butter.setSelected(true);
//                coffee.setSelected(false);
//            }
//            else if(!butter.isSelected()&& chocolate.isSelected()){
//                butter.setSelected(true);
//                chocolate.setSelected(false);
//            }
//            else {
//                butter.setSelected(false);
//            }
//        });
//
//        chocolate.setOnClickListener(view13 -> {
//            if (!classic.isSelected()&&!chocolate.isSelected()&&!coffee.isSelected()
//                    &&!butter.isSelected()){
//                chocolate.setSelected(true);
//            }
//            else if(!chocolate.isSelected()&& classic.isSelected()){
//                chocolate.setSelected(true);
//                classic.setSelected(false);
//            }
//            else if(!chocolate.isSelected()&& coffee.isSelected()){
//                chocolate.setSelected(true);
//                coffee.setSelected(false);
//            }
//            else if(!chocolate.isSelected()&& butter.isSelected()){
//                chocolate.setSelected(true);
//                butter.setSelected(false);
//            }
//            else {
//                chocolate.setSelected(false);
//            }
//        });

        apply.setOnClickListener(v -> {
            if (!waffle.waffleType.equals("")) {
                //WaffleObject waffleObject = new WaffleObject(waffleType );
//                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").
//                        child(UserData.Uid).child("Waffle").push();
//                refNewOrder.setValue(waffleObject);
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