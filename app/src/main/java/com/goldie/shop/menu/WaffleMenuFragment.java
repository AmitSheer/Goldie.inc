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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class WaffleMenuFragment extends Fragment implements View.OnClickListener {
    HashMap<String, Long> currentStock = new HashMap<>();
    FirebaseFirestore db;
    DocumentReference docRef;
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
        db = FirebaseFirestore.getInstance();
        docRef = db.collection("stock").document("waffle");
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot doc = task.getResult();
                assert doc != null;
                if (doc.exists()) {
                    Map<String, Object> map = doc.getData();
                    if (map != null) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            currentStock.put(entry.getKey(), (Long) entry.getValue());
                        }
                    }
                }
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
                        waffle.product_id = "Waffle_" + waffle.product_id;
                        order.put(waffle.getProduct_id(), waffle);
                        Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                        updateDB(doc);
                        NavDirections action = WaffleMenuFragmentDirections.actionWaffleMenuFragmentToMenuFragment();
                        Navigation.findNavController(view).navigate(action);
                    } else {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please choose product!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void updateDB(DocumentSnapshot doc) {
        for (Map.Entry<String, Long> entry : currentStock.entrySet()) {
            String product = entry.getKey();
            Long inDB = (Long) doc.get(product);
            Long current = currentStock.get(product);
            assert inDB != null;
            if (!inDB.equals(current)) {
                docRef.update(product, current);
            }
        }
    }


    @Override
    public void onClick(View v) {
        //check if selection is in stock
        if (currentStock.get(v.getTag()) != 0) {
            v.setSelected(!v.isSelected());
            if (selected != null) {
                selected.setSelected(false);
                waffle.waffleType = "";
                // unselect old one
                long current = currentStock.get((String) selected.getTag());
                current++;
                currentStock.put((String) selected.getTag(), current);
            }
            selected = v.findViewById(v.getId());
            if (v.isSelected()) {
                // select new one
                long current = currentStock.get((String) selected.getTag());
                current--;
                currentStock.put((String) v.getTag(), current);
            } else {
                selected = null;
            }

            waffle.waffleType = (String) v.getTag();

        } else {
            Toast.makeText(v.getContext(), "The product is out of stock, please pick something else", Toast.LENGTH_SHORT).show();
        }
    }
}