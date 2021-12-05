package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class WaffleObject implements Serializable {
    public Product waffleType ;
    public WaffleObject(Product waffle) {
        this.waffleType =waffle;
//        wafflesTypes = Arrays.asList(new Product("Classic Waffle", 0, 8, 50),
    }

    // Copy Constructor
    public WaffleObject(WaffleObject other) {
        this.waffleType  = other.waffleType ;
    }
}
