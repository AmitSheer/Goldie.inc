package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CrepeObject implements Serializable {
    public Product chocolateType;
    public List<Product> toppings;

    public CrepeObject(Product chocolateType, List<Product> toppings) {
        this.chocolateType=chocolateType;
        this.toppings=toppings;
    }

    // Copy Constructor
    public CrepeObject(CrepeObject other) {
        this.chocolateType = other.chocolateType;
        this.toppings = other.toppings;
    }
}
