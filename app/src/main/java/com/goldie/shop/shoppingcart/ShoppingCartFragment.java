package com.goldie.shop.shoppingcart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import static com.goldie.shop.ShopActivity.order;

import com.goldie.R;
import com.goldie.shop.shoppingcart.data.MainAdaptar;
import com.goldie.shop.menu.CrepeObject;
import com.goldie.shop.menu.FroyoObject;
import com.goldie.shop.menu.IceCreamObject;
import com.goldie.shop.menu.WaffleObject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is representing the entire order that the user have made.
 * Using expandable list view to show the entire order of the product and its children's (toppings, addons, sizes, etc).
 */
public class ShoppingCartFragment extends Fragment {
    Button payment;
    ExpandableListView exp_list;
    // List of all products
    ArrayList<Product> listProduct =new ArrayList<>();
    // Map of the product id and an arraylist of all children's
    HashMap<String,ArrayList<String>> mapAddOn =new HashMap<>();
    MainAdaptar adaptar;

    public ShoppingCartFragment() {
        super(R.layout.fragment_shopping_cart);
    }

    // Navigate to shopping cart fragment
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        payment = view.findViewById(R.id.payment);
        payment.setOnClickListener(v -> {
                    NavDirections action = ShoppingCartFragmentDirections.actionShoppingCartFragmentToDeliveryFragment();
                    Navigation.findNavController(view).navigate(action);
                }
        );
        exp_list=view.findViewById(R.id.exp_list_view_shopping);
        // list of all children's
        ArrayList<String> addons=new ArrayList<>();
        // Loop over order map on all products and add to the list the products and to the map all the children's
        for (Product product:order.values()) {
            if (!listProduct.contains(product)) {
                listProduct.add(product);
            }
            if(product instanceof IceCreamObject) {
                addons.add("Served In: "+((IceCreamObject) product).serveIn);
                addons.addAll(((IceCreamObject) product).flavorArray);
            }
            if(product instanceof FroyoObject) {
                addons.add("Cup Size: "+((FroyoObject) product).cupSize);
                addons.add("Flavor: "+((FroyoObject) product).flavor);
            }
            if(product instanceof CrepeObject) {
                addons.add("Filling: "+((CrepeObject) product).chocolateType);
                addons.addAll(((CrepeObject) product).toppings);
            }
            if(product instanceof WaffleObject) {
                addons.add("Type: "+((WaffleObject) product).waffleType);
            }
            mapAddOn.put(product.getProduct_id(), (ArrayList<String>) addons.clone());
            addons.clear();
        }
        // Use the constructor of main adapter with the new product lists and the map with all the children's
        adaptar = new MainAdaptar(this.getContext(), listProduct, mapAddOn);
        exp_list.setAdapter(adaptar);
        // Used to refresh the adapter
        adaptar.notifyDataSetChanged();
    }
}