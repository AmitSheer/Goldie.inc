package com.goldie.shop.shoppingcart;

import static com.goldie.shop.ShopActivity.order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;
import com.goldie.shop.menu.FroyoObject;
import com.goldie.shop.menu.WaffleObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class SellerAdviceFragment extends Fragment {
    HashMap<Integer, String> discountedProducts = new HashMap<>();
    ArrayList<Double> discountedPrices = new ArrayList<>();
    ArrayList<Integer> drawableItemNumber = new ArrayList<>();
    Button addToShoppingCartButton;

    public SellerAdviceFragment() {
        super(R.layout.fragment_seller_advice);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addItemToArrayList();
        Random random = new Random();
        int randomItem = (int) random.nextInt(discountedProducts.size());
        int randomDrawable = drawableItemNumber.get(randomItem);
        double randomPrice = random.nextInt(discountedPrices.size())+1;

        TextView itemName = view.findViewById(R.id.nameOfDiscountedItem);
        itemName.setText("This week's winner:\n" + discountedProducts.get(randomDrawable));

        ImageView myImageView = view.findViewById(R.id.imageOfItem);
        myImageView.setImageResource(randomDrawable);

        TextView discountedPrice = view.findViewById(R.id.priceOfDiscountedItem);
        discountedPrice.setText("Only " + randomPrice + "$ !");


        addToShoppingCartButton = view.findViewById(R.id.addToShoppingCartButton);
        addToShoppingCartButton.setOnClickListener(v -> {
                addToShoppingCart(randomDrawable, randomPrice);
                NavDirections action = SellerAdviceFragmentDirections.actionSellerAdviceFragmentToShoppingCartFragment();
                Navigation.findNavController(view).navigate(action);
            }
        );

    }

    private void addToShoppingCart(int randomDrawable, double randomPrice) {
        String product = discountedProducts.get(randomDrawable);
        if (product == null) {
            return;
        }
        String typeOrFlavor = product.substring(0, product.indexOf(" ")).toLowerCase();
        if (product.contains("Waffle")) {
            WaffleObject waffle = new WaffleObject();
            waffle.product_id = "Waffle_" + waffle.product_id;
            waffle.waffleType = typeOrFlavor;
            waffle.setPrice(randomPrice);
            order.put(waffle.getProduct_id(), waffle);
        }
        else if (product.contains("Froyo")) {
            FroyoObject froyo = new FroyoObject();
            froyo.product_id = "Froyo_" + froyo.product_id;
            froyo.flavor = typeOrFlavor;
            froyo.cupSize = "small";
            froyo.setPrice(randomPrice);
            order.put(froyo.getProduct_id(), froyo);
        }
    }

    private void addItemToArrayList() {
        discountedProducts.put(R.drawable.classic, "Classic Waffle");
        discountedProducts.put(R.drawable.coffee, "Coffee Waffle");
        discountedProducts.put(R.drawable.butter, "Butter Waffle");
        discountedProducts.put(R.drawable.coholate, "Chocolate Waffle");
        discountedProducts.put(R.drawable.froyo_kivi, "Kiwi Froyo");
        discountedProducts.put(R.drawable.froyo_mango, "Mango Froyo");
        discountedProducts.put(R.drawable.froyo_peach, "Peach Froyo");
        discountedProducts.put(R.drawable.froyo_blueberry, "Blueberry Froyo");
        discountedProducts.put(R.drawable.froyo_strawberry, "Strawberry Froyo");
        discountedProducts.put(R.drawable.froryo_blackberry, "Blackberry Froyo");
        drawableItemNumber.addAll(discountedProducts.keySet());
        discountedPrices.add(1.0);
        discountedPrices.add(2.0);
    }
}
