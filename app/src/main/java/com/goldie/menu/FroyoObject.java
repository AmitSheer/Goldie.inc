package com.goldie.menu;

import com.goldie.shoppingcart.product;


public class FroyoObject {
    public product[] cupSize;
    public product[] flavor;

    public FroyoObject() {
        cupSize = new product[]{new product("Small froyo cup", 0, 3, 1), /*1=in stock*/
                new product("Medium froyo cup", 0, 4, 1), /*1=in stock*/
                new product("Large froyo cup", 0, 6, 1) /*1=in stock*/};
        flavor = new product[]{new product("Kiwi froyo", 0, 0, 50),
                new product("Peach froyo", 0, 0, 50),
                new product("Mango froyo", 0, 0, 50),
                new product("Blueberry froyo", 0, 0, 50),
                new product("Strawberry froyo", 0, 0, 50),
                new product("Blackberry froyo", 0, 0, 50)};
    }

    ;

}
