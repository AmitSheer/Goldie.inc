package com.goldie.menu;

import com.goldie.shoppingcart.product;

public class CrepeObject {
    public product[] chocolateType;
    public product[] toppings;

    public CrepeObject() {
        chocolateType = new product[]{new product("Dark chocolate", 0, 0, 1), /*1=in stock*/
                new product("White chocolate", 0, 0, 1) /*1=in stock*/};
        toppings = new product[]{new product("Strawberry", 0, 1, 1), /*1=in stock*/
                new product("Banana", 0, 1, 1), /*1=in stock*/
                new product("Blueberry", 0, 1, 1), /*1=in stock*/
                new product("Gummy Bears", 0, 2, 1), /*1=in stock*/
                new product("Oreo", 0, 2, 1), /*1=in stock*/
                new product("Whipped Cream", 0, 0, 1), /*1=in stock*/
                new product("Sprinklers", 0, 0, 1), /*1=in stock*/
                new product("Dark Chocolate Topping", 0, 1, 1), /*1=in stock*/
                new product("White Chocolate Topping", 0, 1, 1) /*1=in stock*/};
    }

}
