package com.goldie.shoppingcart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class ShoppingCartFragment extends Fragment {
    Button place_order;
    public ShoppingCartFragment() {
        super(R.layout.fragment_shopping_cart);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    place_order=view.findViewById(R.id.place_order);
        place_order.setOnClickListener(v -> {
                    NavDirections action = ShoppingCartFragmentDirections.actionShoppingCartFragmentToPaymentFragment2();
                    Navigation.findNavController(view).navigate(action);
                }
        );
    }

}
