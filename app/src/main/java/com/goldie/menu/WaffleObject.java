package com.goldie.menu;

import com.goldie.shoppingcart.product;

public class WaffleObject {
    public product[] waffles;

    public WaffleObject() {
        waffles = new product[]{new product("Classic Waffle", 0, 8, 50),
                new product("Coffee Waffle", 0, 9, 50),
                new product("Butter Waffle", 0, 10, 50),
                new product("Chocolate Waffle", 0, 10, 50)};
    }
}
