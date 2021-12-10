package com.goldie.shop.menu;

import com.goldie.shop.shoppingcart.Product;

import java.io.Serializable;

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
