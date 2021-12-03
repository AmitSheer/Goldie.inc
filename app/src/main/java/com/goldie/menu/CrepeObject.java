package com.goldie.menu;

import com.goldie.shoppingcart.Product;

public class CrepeObject {
    public Product[] chocolateType;
    public Product[] toppings;

    public CrepeObject() {
        chocolateType = new Product[]{new Product("Dark chocolate", 0, 0, 1), /*1=in stock*/
                new Product("White chocolate", 0, 0, 1) /*1=in stock*/};
        toppings = new Product[]{new Product("Strawberry", 0, 1, 1), /*1=in stock*/
                new Product("Banana", 0, 1, 1), /*1=in stock*/
                new Product("Blueberry", 0, 1, 1), /*1=in stock*/
                new Product("Gummy Bears", 0, 2, 1), /*1=in stock*/
                new Product("Oreo", 0, 2, 1), /*1=in stock*/
                new Product("Whipped Cream", 0, 0, 1), /*1=in stock*/
                new Product("Sprinklers", 0, 0, 1), /*1=in stock*/
                new Product("Dark Chocolate Topping", 0, 1, 1), /*1=in stock*/
                new Product("White Chocolate Topping", 0, 1, 1) /*1=in stock*/};
    }
}
