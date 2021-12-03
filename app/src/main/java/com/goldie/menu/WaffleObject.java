package com.goldie.menu;

import com.goldie.shoppingcart.Product;

public class WaffleObject {
    public Product[] waffles;

    public WaffleObject() {
        waffles = new Product[]{new Product("Classic Waffle", 0, 8, 50),
                new Product("Coffee Waffle", 0, 9, 50),
                new Product("Butter Waffle", 0, 10, 50),
                new Product("Chocolate Waffle", 0, 10, 50)};
    }
}
