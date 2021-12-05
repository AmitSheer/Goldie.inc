package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class FroyoObject implements Serializable {
    public Product cupSize;
    public Product flavor;

    public FroyoObject(Product cupSize, Product flavor) {
        this.cupSize=cupSize;
        this.flavor=flavor;
    }

    // Copy Constructor
    public FroyoObject(FroyoObject other) {
        this.cupSize = other.cupSize;
        this.flavor = other.flavor;
    }



}
