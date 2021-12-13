package com.goldie.shop.menu;

import com.goldie.shop.shoppingcart.Product;

import java.io.Serializable;


public class FroyoObject extends Product implements Serializable {
    public String cupSize;
    public String flavor;

    public FroyoObject(){
        super("Froyo", 1, 0, 1);
        cupSize="";
        flavor="";

    }
    // Copy Constructor
    public FroyoObject(FroyoObject other) {
        this.cupSize = other.cupSize;
        this.flavor = other.flavor;
    }



}
