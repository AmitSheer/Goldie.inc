package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class FroyoObject implements Serializable {
    public List<Product> cupSize;
    public List<Product> flavor;

    public FroyoObject() {
        cupSize = Arrays.asList(new Product("Small froyo cup", 0, 3, 1), /*1=in stock*/
                new Product("Medium froyo cup", 0, 4, 1), /*1=in stock*/
                new Product("Large froyo cup", 0, 6, 1) /*1=in stock*/);
        flavor = Arrays.asList(new Product("Kiwi froyo", 0, 0, 50),
                new Product("Peach froyo", 0, 0, 50),
                new Product("Mango froyo", 0, 0, 50),
                new Product("Blueberry froyo", 0, 0, 50),
                new Product("Strawberry froyo", 0, 0, 50),
                new Product("Blackberry froyo", 0, 0, 50));
    }

    // Copy Constructor
    public FroyoObject(FroyoObject value) {
        this.cupSize = value.cupSize;
        this.flavor = value.flavor;
    }

    public String getClassName() {
        return "Froyo";
    }


}
