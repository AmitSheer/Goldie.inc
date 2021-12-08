package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class FroyoObject extends Product implements Serializable {
    public String cupSize;
    public String flavor;

//    public FroyoObject(Product cupSize, Product flavor) {
//        this.cupSize=cupSize;
//        this.flavor=flavor;
//    }
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
