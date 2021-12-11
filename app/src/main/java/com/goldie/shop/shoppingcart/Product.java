package com.goldie.shop.shoppingcart;

import java.util.ArrayList;

/**
 * This class Contains information on a single item inside an com.goldie.shop.menu.Order of a costumer, it contains the Item name, the amount of units purchased of this product, and price per unit.
 * The class members are: Item as item name, amount - amount of purchased units for this item, and the price for one unit.
 * This class can: Create a product, get a product price, set a product price, set a product amount, get an item name, and get the product amount.
 */
public class Product {
    /**
     * Represents the name of the item
     */
    String itemName;
    /**
     * Describes how many units are ordered within the same item.
     */
    int amount;
    public  String product_id;
    ArrayList<String> addons;
    private static long counter;

    /**
     * Describes the price for each unit.
     */
    double price = 0;

    /**
     * Describes how many units available in the stock.
     */
    int unitsInStock;

    /**
     * Built for Firebase imports (required) , does nothing.
     */
    public Product(){}


    /**
     * Constructor specifically for com.goldie.shop.menu.Order class, this constructor creates a new productOrder
     * in case there is no such productOrder in the com.goldie.shop.menu.Order Arraylist Member of com.goldie.shop.menu.Order.
     */
    public Product(String itemName, int amount, double price, int unitsInStock) {
        product_id=""+counter;
        counter++;
        this.itemName = itemName;
        this.amount = amount;
        this.price=price;
        this.unitsInStock=unitsInStock;
    }

    /**
     * Copy constructor for a given com.goldie.shop.menu.Order
     * @params product - an existing productOrder node
     */
    public Product(Product product) {
        this.itemName = product.getItemName();
        this.amount = product.getAmount();
        this.price = product.getPrice();
        this.unitsInStock= product.getUnitsInStock();
    }

    /**
     * Returns the name of a given product.
     * @return Name of a product in String data type.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the Item name.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public  String getProduct_id() {
        return product_id;
    }
    /**
     * Returns the amount of a given product.
     * @return amount of a product in Integer data type.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of a given product.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the price of a given product
     * @return the price of a given product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the amount of a given product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the number of units available in stock.
     * @return Number of units in int data type.
     */
    public int getUnitsInStock() {
        return unitsInStock;
    }

    /**
     * Sets the number of units in stock.
     */
    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String printProduct() {
        return this.itemName + this.amount + this.price;
    }
}