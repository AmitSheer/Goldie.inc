package com.goldie.menu;

import com.goldie.shoppingcart.Product;


public class FroyoObject {
    public Product[] cupSize;
    public Product[] flavor;

    public FroyoObject() {
        cupSize = new Product[]{new Product("Small froyo cup", 0, 3, 1), /*1=in stock*/
                new Product("Medium froyo cup", 0, 4, 1), /*1=in stock*/
                new Product("Large froyo cup", 0, 6, 1) /*1=in stock*/};
        flavor = new Product[]{new Product("Kiwi froyo", 0, 0, 50),
                new Product("Peach froyo", 0, 0, 50),
                new Product("Mango froyo", 0, 0, 50),
                new Product("Blueberry froyo", 0, 0, 50),
                new Product("Strawberry froyo", 0, 0, 50),
                new Product("Blackberry froyo", 0, 0, 50)};
    }

    ;

}
