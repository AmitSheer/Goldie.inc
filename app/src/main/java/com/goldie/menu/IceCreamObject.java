package com.goldie.menu;

import com.goldie.shoppingcart.Product;

public class IceCreamObject {
    public Product[] serveIn;
    public Product[] flavor;

    public IceCreamObject() {
        serveIn = new Product[]{new Product("Ice cream cup", 0, 0, 1), /*1=in stock*/
                new Product("Ice cream cone", 0, 0, 1)}; /*1=in stock*/
        flavor = new Product[]{new Product("Vanilla ice cream", 0, 1, 50),
                new Product("Chocolate ice cream", 0, 1, 50),
                new Product("Pistachio ice cream", 0, 1, 50),
                new Product("Strawberry ice cream", 0, 1, 50)};
    }
}
