package com.goldie.shop.menu;

import com.goldie.shop.shoppingcart.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CrepeObject extends Product implements Serializable {
    //public List<Product> chocolateType;
    public String chocolateType;
    public List<String> toppings;

    public CrepeObject(String chocolateType, List<String> toppings) {
        this.chocolateType=chocolateType;
        this.toppings=toppings;
    }

    public CrepeObject(){
        super("Crepe",0,5,1);
        chocolateType="";
        toppings=new ArrayList<>();
    }
    // Copy Constructor
    public CrepeObject(CrepeObject value) {
        this.chocolateType = value.chocolateType;
        this.toppings = value.toppings;
    }


}
