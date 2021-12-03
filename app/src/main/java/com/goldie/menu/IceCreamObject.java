package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class IceCreamObject implements Serializable {
    public List<Product> serveIn;
    public List<Product> flavor;

    public IceCreamObject() {
        serveIn = Arrays.asList(new Product("Ice cream cup", 0, 0, 1), /*1=in stock*/
                new Product("Ice cream cone", 0, 0, 1)); /*1=in stock*/
        flavor = Arrays.asList(new Product("Vanilla ice cream", 0, 1, 50),
                new Product("Chocolate ice cream", 0, 1, 50),
                new Product("Pistachio ice cream", 0, 1, 50),
                new Product("Strawberry ice cream", 0, 1, 50));
    }
}
