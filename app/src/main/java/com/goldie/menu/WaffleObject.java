package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class WaffleObject extends Product implements Serializable {
    public String waffleType ;
    public WaffleObject(){
        super("Waffle",1, 0, 1);
        waffleType="";
    }
    // Copy Constructor
    public WaffleObject(WaffleObject other) {
        this.waffleType  = other.waffleType ;
    }
}
