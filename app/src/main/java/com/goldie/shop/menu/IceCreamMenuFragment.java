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

public class IceCreamMenuFragment extends Fragment implements View.OnClickListener {
    HashMap<String, Long> currentStock = new HashMap<>();
    FirebaseFirestore db;
    DocumentReference docRef;
    RadioButton one_s, two_s, three_s, one_c, two_c, three_c, one_v, two_v, three_v, one_p, two_p, three_p;
    RadioGroup strawberry, chocolate, vanilla, pistachio, serve_in;
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
                    }
                }
                strawberry.setOnCheckedChangeListener((group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.one_s:
                            if (currentStock.get("strawberry")==0){
                                Toast.makeText(view.getContext(), "Not enough scoops please choose another flavor", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                strawberryNum = 1;
                                long current = currentStock.get("strawberry");
                                current--;
                                currentStock.put("strawberry", current);
                            }
                            break;
                        case R.id.two_s:
                            if (currentStock.get("strawberry")<2){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                strawberryNum = 2;
                                long current = currentStock.get("strawberry");
                                current=current-2;
                                currentStock.put("strawberry", current);
                            }
                            break;
                        case R.id.three_s:
                            if (currentStock.get("strawberry")<3){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                strawberryNum = 3;
                                long current = currentStock.get("strawberry");
                                current=current-3;
                                currentStock.put("strawberry", current);
                            }
                            break;
                    }
                });

                chocolate.setOnCheckedChangeListener((group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.one_c:
                            if (currentStock.get("chocolate")==0){
                                Toast.makeText(view.getContext(), "Not enough scoops please choose another flavor", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                chocolateNum = 1;
                                long current = currentStock.get("chocolate");
                                current--;
                                currentStock.put("chocolate", current);
                            }
                            break;
                        case R.id.two_c:
                            if (currentStock.get("chocolate")<2){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                chocolateNum = 2;
                                long current = currentStock.get("chocolate");
                                current=current-2;
                                currentStock.put("chocolate", current);
                            }
                            break;
                        case R.id.three_c:
                            if (currentStock.get("chocolate")<3){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                chocolateNum = 3;
                                long current = currentStock.get("chocolate");
                                current=current-3;
                                currentStock.put("chocolate", current);
                            }
                            break;
                    }
                });

                vanilla.setOnCheckedChangeListener((group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.one_v:
                            if (currentStock.get("vanilla")==0){
                                Toast.makeText(view.getContext(), "Not enough scoops please choose another flavor", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                vanillaNum = 1;
                                long current = currentStock.get("vanilla");
                                current--;
                                currentStock.put("vanilla", current);
                            }
                            break;
                        case R.id.two_v:
                            if (currentStock.get("vanilla")<2){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                vanillaNum = 2;
                                long current = currentStock.get("vanilla");
                                current=current-2;
                                currentStock.put("vanilla", current);
                            }
                            break;
                        case R.id.three_v:
                            if (currentStock.get("vanilla")<3){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                vanillaNum = 3;
                                long current = currentStock.get("vanilla");
                                current=current-3;
                                currentStock.put("vanilla", current);
                            }
                            break;
                    }
                });

                pistachio.setOnCheckedChangeListener((group, checkedId) -> {
                    switch (checkedId) {
                        case R.id.one_p:
                            if (currentStock.get("pistachio")==0){
                                Toast.makeText(view.getContext(), "Not enough scoops please choose another flavor", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                pistachioNum = 1;
                                long current = currentStock.get("pistachio");
                                current--;
                                currentStock.put("pistachio", current);
                            }
                            break;
                        case R.id.two_p:
                            if (currentStock.get("pistachio")<2){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                pistachioNum = 2;
                                long current = currentStock.get("pistachio");
                                current=current-2;
                                currentStock.put("pistachio", current);
                            }
                            break;
                        case R.id.three_p:
                            if (currentStock.get("pistachio")<3){
                                Toast.makeText(view.getContext(), "Not enough scoops please decrease you choice", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                pistachioNum = 3;
                                long current = currentStock.get("pistachio");
                                current=current-3;
                                currentStock.put("pistachio", current);
                            }
                            break;
                    }
                });
                apply.setOnClickListener(v -> {
                    int total = chocolateNum + vanillaNum + strawberryNum + pistachioNum;
                    if ((total > 0 && total <= 3) && (cup.isSelected() || cone.isSelected())) {
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
                    } else if (total > 3) {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 scoops!", Toast.LENGTH_SHORT).show();
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
            assert inDB != null;
            if (!inDB.equals(current)) {
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
    }
}
