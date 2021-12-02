package com.goldie.menu;

import com.goldie.shoppingcart.product;

public class IceCreamObject {
    public product[] serveIn;
    public product[] flavor;

    public IceCreamObject() {
        serveIn = new product[]{new product("Ice cream cup", 0, 0, 1), /*1=in stock*/
                new product("Ice cream cone", 0, 0, 1)}; /*1=in stock*/
        flavor = new product[]{new product("Vanilla ice cream", 0, 1, 50),
                new product("Chocolate ice cream", 0, 1, 50),
                new product("Pistachio ice cream", 0, 1, 50),
                new product("Strawberry ice cream", 0, 1, 50)};
    }
}
