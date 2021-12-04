package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CrepeObject implements Serializable {
    public List<Product> chocolateType;
    public List<Product> toppings;

    public CrepeObject() {
        chocolateType = Arrays.asList(new Product("Dark chocolate", 0, 0, 1), /*1=in stock*/
                new Product("White chocolate", 0, 0, 1) /*1=in stock*/);
        toppings = Arrays.asList(new Product("Strawberry", 0, 1, 1), /*1=in stock*/
                new Product("Banana", 0, 1, 1), /*1=in stock*/
                new Product("Blueberry", 0, 1, 1), /*1=in stock*/
                new Product("Gummy Bears", 0, 2, 1), /*1=in stock*/
                new Product("Oreo", 0, 2, 1), /*1=in stock*/
                new Product("Whipped Cream", 0, 0, 1), /*1=in stock*/
                new Product("Sprinklers", 0, 0, 1), /*1=in stock*/
                new Product("Dark Chocolate Topping", 0, 1, 1), /*1=in stock*/
                new Product("White Chocolate Topping", 0, 1, 1) /*1=in stock*/);
    }

    // Copy Constructor
    public CrepeObject(CrepeObject value) {
        this.chocolateType = value.chocolateType;
        this.toppings = value.toppings;
    }

    public String getClassName() {
        return "Crepe";
    }
}
