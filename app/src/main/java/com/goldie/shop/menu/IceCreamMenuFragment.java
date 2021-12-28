package com.goldie.shop.menu;

import static com.goldie.shop.ShopActivity.order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
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

public class IceCreamMenuFragment extends Fragment implements View.OnClickListener {
    HashMap<String, Long> currentStock = new HashMap<>();
    FirebaseFirestore db;
    DocumentReference docRef;
    NumberPicker strawberry, chocolate, pistachio, vanilla;
    Button apply;
    ImageButton selected;
    int chocolateNum = 0, strawberryNum = 0, pistachioNum = 0, vanillaNum = 0;
    ImageButton cup, cone;
    IceCreamObject iceCream;
    long cStock, sStock, pStock, vStock;

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
        strawberry = view.findViewById(R.id.strawNumPick);
        strawberry.setValue(0);
        strawberry.setMaxValue(3);
        strawberry.setMinValue(0);

        chocolate = view.findViewById(R.id.chocoNumPick);
        chocolate.setValue(0);
        chocolate.setMaxValue(3);
        chocolate.setMinValue(0);

        vanilla = view.findViewById(R.id.vanillaNumPick);
        vanilla.setValue(0);
        vanilla.setMaxValue(3);
        vanilla.setMinValue(0);

        pistachio = view.findViewById(R.id.pistachioNumPick);
        pistachio.setValue(0);
        pistachio.setMaxValue(3);
        pistachio.setMinValue(0);

        iceCream = new IceCreamObject();
        apply = view.findViewById(R.id.applyInIceCream);
        db = FirebaseFirestore.getInstance();
        docRef = db.collection("stock").document("ice cream");
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
                        cStock=currentStock.get("chocolate");
                        sStock=currentStock.get("strawberry");
                        vStock=currentStock.get("vanilla");
                        pStock=currentStock.get("pistachio");
                    }
                }
                strawberry.setOnValueChangedListener((picker, oldVal, newVal) -> {
                    if (newVal + chocolateNum + vanillaNum + pistachioNum > 3) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 scoops!", Toast.LENGTH_SHORT).show();
                    }
                    else if (sStock < newVal) {
                        Toast.makeText(view.getContext(), "out of stock, please pick pick less scoops or chose a different flavor", Toast.LENGTH_SHORT).show();
                    } else {
                        strawberryNum = newVal;
                        long current=sStock-newVal;
                        currentStock.put("strawberry", current);
                    }
                });

                vanilla.setOnValueChangedListener((picker, oldVal, newVal) -> {
                    if (newVal + chocolateNum + strawberryNum + pistachioNum > 3) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 scoops!", Toast.LENGTH_SHORT).show();
                    }
                    else if (vStock < newVal) {
                        Toast.makeText(view.getContext(), "out of stock, please pick pick less scoops or chose a different flavor", Toast.LENGTH_SHORT).show();
                    } else {
                        vanillaNum = newVal;
                        long current=vStock-newVal;
                        currentStock.put("vanilla", current);
                    }
                });
                chocolate.setOnValueChangedListener((picker, oldVal, newVal) -> {
                    if (newVal + vanillaNum + strawberryNum + pistachioNum > 3) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 scoops!", Toast.LENGTH_SHORT).show();
                    }
                    else if (cStock < newVal) {
                        Toast.makeText(view.getContext(), "out of stock, please pick pick less scoops or chose a different flavor", Toast.LENGTH_SHORT).show();
                    } else {
                        chocolateNum = newVal;
                        long current=cStock-newVal;
                        currentStock.put("chocolate", current);
                    }
                });

                pistachio.setOnValueChangedListener((picker, oldVal, newVal) -> {
                    if (newVal + vanillaNum + strawberryNum + chocolateNum > 3) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 scoops!", Toast.LENGTH_SHORT).show();
                    }
                    else if (pStock < newVal) {
                        Toast.makeText(view.getContext(), "out of stock, please pick pick less scoops or chose a different flavor", Toast.LENGTH_SHORT).show();
                    } else {
                        pistachioNum = newVal;
                        long current=pStock-newVal;
                        System.out.println(current);
                    }
                });

                apply.setOnClickListener(v -> {
                    int total = chocolateNum + vanillaNum + strawberryNum + pistachioNum;
                    if (total > 0 && (cup.isSelected() || cone.isSelected())) {
                        iceCream.product_id = "Ice Cream_" + iceCream.product_id;
                        for (int i = 0; i < chocolateNum; i++)
                            iceCream.flavorArray.add("Chocolate");
                        for (int i = 0; i < strawberryNum; i++)
                            iceCream.flavorArray.add("Strawberry");
                        for (int i = 0; i < vanillaNum; i++) iceCream.flavorArray.add("Vanilla");
                        for (int i = 0; i < pistachioNum; i++)
                            iceCream.flavorArray.add("Pistachio");
                        iceCream.setPrice(total);
                        order.put(iceCream.getProduct_id(), iceCream);
                        Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                        updateDB(doc);
                        NavDirections action = IceCreamMenuFragmentDirections.actionIceCreamMenuFragmentToMenuFragment();
                        Navigation.findNavController(view).navigate(action);
                    } else if (total == 0) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup or cone!", Toast.LENGTH_SHORT).show();

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
            if (inDB != null && !inDB.equals(current)) {
                docRef.update(product, current);
            }
        }
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
        else {
            selected=null;
        }
    }
}
