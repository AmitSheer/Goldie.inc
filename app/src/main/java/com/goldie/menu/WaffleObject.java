package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class WaffleObject implements Serializable {
    public List<Product> wafflesTypes;

    public WaffleObject() {
        wafflesTypes = Arrays.asList(new Product("Classic Waffle", 0, 8, 50),
                new Product("Coffee Waffle", 0, 9, 50),
                new Product("Butter Waffle", 0, 10, 50),
                new Product("Chocolate Waffle", 0, 10, 50));
    }
}
