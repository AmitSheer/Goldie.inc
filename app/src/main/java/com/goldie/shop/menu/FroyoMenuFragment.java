package com.goldie.shop.menu;

import static com.goldie.shop.ShopActivity.order;

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
import com.goldie.shop.shoppingcart.Product;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FroyoMenuFragment extends Fragment implements View.OnClickListener {
    HashMap<String, Long> currentStock = new HashMap<>();
    FirebaseFirestore db;
    DocumentReference docRef;
    Button apply;
    ImageButton small, medium, large, kiwi, peach, mango, blueberry, strawberry, blackberry;
    ImageButton selectedFlave, selectedSize;
    boolean something_checked = false;
    FroyoObject frozen = new FroyoObject();


    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @SuppressLint("NonConstantResourceId")
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
        db = FirebaseFirestore.getInstance();
        docRef = db.collection("stock").document("frozen yogurt");
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
                    if ((large.isSelected() || medium.isSelected() || small.isSelected()) && something_checked) {
                        switch (selectedSize.getId()) {
                            case R.id.large: {
                                frozen.setPrice(6);
                                break;
                            }
                            case R.id.medium: {
                                frozen.setPrice(4);
                                break;
                            }
                            case R.id.small: {
                                frozen.setPrice(3);
                                break;
                            }
                        }
                        frozen.product_id = "Froyo_" + frozen.product_id;
                        order.put(frozen.getProduct_id(), frozen);
                        Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                        updateDB(doc);
                        NavDirections action = FroyoMenuFragmentDirections.actionFroyoMenuFragmentToMenuFragment();
                        Navigation.findNavController(view).navigate(action);

                    } else if (!something_checked) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_SHORT).show();
                    } else if (!large.isSelected() && !medium.isSelected() && !small.isSelected()) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup size!", Toast.LENGTH_SHORT).show();
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
            if (!inDB.equals(current)){
                docRef.update(product,current);
            }
        }
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
                //check if selection is in stock
                if (currentStock.get(v.getTag())!=0) {
                    v.setSelected(!v.isSelected());
                    if (selectedFlave != null) {
                        selectedFlave.setSelected(false);
                        frozen.flavor = "";
                        // unselect old one
                        long current = currentStock.get((String) selectedFlave.getTag());
                        current++;
                        currentStock.put((String) selectedFlave.getTag(), current);
                        something_checked = false;
                    }
                    selectedFlave = v.findViewById(v.getId());
                    if (v.isSelected()) {
                        // select new one
                        long current = currentStock.get((String) selectedFlave.getTag());
                        current--;
                        currentStock.put((String) v.getTag(), current);
                        frozen.flavor = (String) v.getTag();
                        something_checked = true;
                    } else {
                        selectedFlave = null;
                    }
                    break;
                }
                else {
                    Toast.makeText(v.getContext(), "The product is out of stock, please pick something else", Toast.LENGTH_SHORT).show();
                }
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
                else{
                    selectedSize=null;
                }
                break;
        }
    }
}