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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class SellerAdviceFragment extends Fragment {
    HashMap<Integer, String> discountedProducts = new HashMap<>();
    ArrayList<Integer> discountedPrices = new ArrayList<>();
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
        int randomPrice = random.nextInt(discountedPrices.size())+1;

        TextView itemName = view.findViewById(R.id.nameOfDiscountedItem);
        itemName.setText("This week's winner:\n" + discountedProducts.get(randomDrawable));

        ImageView myImageView = view.findViewById(R.id.imageOfItem);
        myImageView.setImageResource(randomDrawable);

        TextView discountedPrice = view.findViewById(R.id.priceOfDiscountedItem);
        discountedPrice.setText("Only " + randomPrice + "$ !");
        // Need to put in order (maybe) the product from the picture - problems with data not matching
       // order.put();

//        addToShoppingCartButton = view.findViewById(R.id.addToShoppingCartButton);
//        addToShoppingCartButton.setOnClickListener(v -> {
//            // ask tal about .pass to shopping cart page instead of payment page
//                    NavDirections action = ShoppingCartFragmentDirections.actionShoppingCartFragmentToPaymentFragment2();
//                    Navigation.findNavController(view).navigate(action);
//                }
//        );
    }

    private void addItemToArrayList() {
        discountedProducts.put(R.drawable.classic, "Classic Waffle");
        discountedProducts.put(R.drawable.coffee, "Coffee Waffle");
        discountedProducts.put(R.drawable.butter, "Butter Waffle");
        discountedProducts.put(R.drawable.coholate, "Chocolate Waffle");
        discountedProducts.put(R.drawable.froyo_kivi, "Kiwi Froyo");
        discountedProducts.put(R.drawable.froyo_mango, "Mango Froyo");
        discountedProducts.put(R.drawable.froyo_peach_btn, "Peach Froyo");
        discountedProducts.put(R.drawable.froyo_blueberry, "Blueberry Froyo");
        discountedProducts.put(R.drawable.froyo_strawberry, "Strawberry Froyo");
        discountedProducts.put(R.drawable.froryo_blackberry, "Blackberry Froyo");
        drawableItemNumber.addAll(discountedProducts.keySet());
        discountedPrices.add(1);
        discountedPrices.add(2);
    }
}
