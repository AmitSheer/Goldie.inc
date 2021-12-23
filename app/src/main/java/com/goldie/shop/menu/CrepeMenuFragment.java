package com.goldie.shop.menu;

import static com.goldie.shop.ShopActivity.order;

import android.annotation.SuppressLint;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CrepeMenuFragment extends Fragment implements View.OnClickListener {
    HashMap<String,Long> currentStock = new HashMap<>();
    FirebaseFirestore db;
    DocumentReference docRef;
    Button apply;
    ImageButton black, white, strawberry, banana, berry, gummy, oreo, cream, sprinklers, chocolate_top, white_choco_top, selectedChoco;
    CrepeObject crepeObject;

    public CrepeMenuFragment() {
        super(R.layout.fragment_crepe_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        black = view.findViewById(R.id.black);
        black.setOnClickListener(this);
        white = view.findViewById(R.id.white);
        white.setOnClickListener(this);
        crepeObject = new CrepeObject();
        strawberry = view.findViewById(R.id.str_top);
        strawberry.setOnClickListener(this);
        banana = view.findViewById(R.id.banana_top);
        banana.setOnClickListener(this);
        berry = view.findViewById(R.id.berry_top);
        berry.setOnClickListener(this);
        gummy = view.findViewById(R.id.gummy_top);
        gummy.setOnClickListener(this);
        oreo = view.findViewById(R.id.oreo_top);
        oreo.setOnClickListener(this);
        cream = view.findViewById(R.id.cream_top);
        cream.setOnClickListener(this);
        sprinklers = view.findViewById(R.id.sprinklers_top);
        sprinklers.setOnClickListener(this);
        chocolate_top = view.findViewById(R.id.chocolate_top);
        chocolate_top.setOnClickListener(this);
        white_choco_top = view.findViewById(R.id.white_choco_top);
        white_choco_top.setOnClickListener(this);
        apply = view.findViewById(R.id.applyInCrepe);
        db = FirebaseFirestore.getInstance();
        docRef = db.collection("stock").document("crepe");
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot doc = task.getResult();
                assert doc != null;
                if (doc.exists()) {
                    Map<String, Object> map = doc.getData();
                    if (map != null) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            currentStock.put(entry.getKey(),(Long) entry.getValue());
                        }
                    }
                }
                apply.setOnClickListener(view111 -> {
                    if (black.isSelected() || white.isSelected()) {
                        crepeObject.product_id = "Crepe_" + crepeObject.product_id;
                        crepeObject.setAmount(crepeObject.getAmount() + 1);
                        order.put(crepeObject.getProduct_id(), crepeObject);
                        Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                        updateDB(doc);
                        NavDirections action = CrepeMenuFragmentDirections.actionCrepeMenuFragmentToMenuFragment();
                        Navigation.findNavController(view).navigate(action);
                    } else {
                        Toast.makeText(requireActivity().getApplicationContext(), "Please pick type of chocolate!", Toast.LENGTH_SHORT).show();
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
            case R.id.str_top:
            case R.id.banana_top:
            case R.id.berry_top:
            case R.id.gummy_top:
            case R.id.oreo_top:
            case R.id.cream_top:
            case R.id.sprinklers_top:
            case R.id.chocolate_top:
            case R.id.white_choco_top:
                //check if selection is in stock
                if (currentStock.get(v.getTag())!=0) {
                    v.setSelected(!v.isSelected());
                    if (crepeObject.toppings.size() == 3) {
                        v.setSelected(false);
                        // already selected- remove selection (3 topping picked)
                        if (crepeObject.toppings.contains(v.getTag())) {
                            long current=currentStock.get(v.getTag());
                            current++;
                            currentStock.put((String) v.getTag(),current);
                            crepeObject.toppings.remove((String) v.getTag());
                        } else {
                            Toast.makeText(requireActivity().getApplicationContext(), "Please pick up to 3 topping!", Toast.LENGTH_SHORT).show();
                        }
                    } else if (v.isSelected()) {
                        // saves selection
                        long current=currentStock.get(v.getTag());
                        current--;
                        currentStock.put((String) v.getTag(),current);
                        crepeObject.toppings.add((String) v.getTag());
                    } else {
                        // already selected- remove selection (less than 3 topping picked)
                        long current=currentStock.get(v.getTag());
                        current++;
                        currentStock.put((String) v.getTag(),current);
                        crepeObject.toppings.remove((String) v.getTag());
                    }
                }
                else {
                    Toast.makeText(v.getContext(), "The product is out of stock, please pick something else", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.black:
            case R.id.white:
                //check if selection is in stock
                if (currentStock.get(v.getTag())!=0) {
                    v.setSelected(!v.isSelected());
                    if (selectedChoco != null) {
                        selectedChoco.setSelected(false);
                        crepeObject.chocolateType = "";
                        // unselect old one
                        long current=currentStock.get((String) selectedChoco.getTag());
                        current++;
                        currentStock.put((String) selectedChoco.getTag(),current);
                        crepeObject.toppings.add((String) v.getTag());
                    }
                    selectedChoco = v.findViewById(v.getId());
                    if (v.isSelected()) {
                        // select new one
                        long current=currentStock.get((String) selectedChoco.getTag());
                        current--;
                        currentStock.put((String) v.getTag(),current);
                        crepeObject.toppings.add((String) v.getTag());
                        crepeObject.chocolateType = (String) v.getTag();
                    }
                    else {
                        selectedChoco=null;
                    }
                    break;
                }
                else{
                    Toast.makeText(v.getContext(), "The product is out of stock, please pick something else", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
