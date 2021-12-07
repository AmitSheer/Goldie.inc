//package com.goldie.shoppingcart;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * This class manages order as an finished order that is ready to be sent\pulled from Firebase DB.
// * The class members are: userID String (Firebase UID of the user purchasing the current com.goldie.menu.Order),
// * TotalOrder cost and Array-List of productOrder Class holding the Item, amount and price
// * for each and every item on the current order.
// * This class can(Methods): create an finished order, set User UID, add (or fill) products to the current order,
// * get the quantity of each item on request and set the total order price.
// */
//public class Order {
//    String userUID;
//    double totalPrice;
//    HashMap<Integer,Product> itemQuantity;
//
//    /**
//     * Built for Firebase imports (required) , does nothing.
//     */
//    public Order() {
//    }
//
//    /**
//     * Constructor for com.goldie.menu.Order Class
//     * @param userUID Name of the user making the order.
//     */
//    public Order(String userUID) {
//        this.userUID = userUID;
//        this.itemQuantity = new Hashmap<>();
//        this.totalPrice = 0;
//    }
//
//    /**
//     * A copy constructor, input is an existing com.goldie.menu.Order class Node,
//     * a copy if com.goldie.menu.Order class is created.
//     * @param order Input the com.goldie.menu.Order node to create.
//     */
//    public Order(Order order) {
//        this.userUID = order.userUID;
//        this.totalPrice = order.totalPrice;
//        this.itemQuantity = order.itemQuantity;
//    }
//
//    /**
//     * Returns the user UID from firebase DB.
//     * @return Name of a product in String data type.
//     */
//    public String getUserUID() {
//        return this.userUID;
//    }
//
//    /**
//     * Sets the user UID from firebase DB.
//     */
//    public void setUserUID(String userUID) {
//        this.userUID = userUID;
//    }
//
//    /**
//     * Use to get the Total com.goldie.menu.Order Price.
//     * @return Returns the Total com.goldie.menu.Order Price.
//     */
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    /**
//     * Sets the price of the com.goldie.menu.Order,
//     * so that the total price is updated.
//     */
//    public void setTotalPrice(double price) {
//        double sumOfPrice = 0;
//        for (int i = 0; i < itemQuantity.size(); i++) {
//            sumOfPrice += itemQuantity.get(i).getPrice();
//        }
//        this.totalPrice = sumOfPrice;
//    }
//
//    /**
//     * @return Returns Array-List consisted of productOrder class members.
//     */
//    public ArrayList<Product> getItemQuantity() {
//        return itemQuantity;
//    }
//
//    /**
//     * Returns the item Quantity by iterating on the inner Array-List of this class.
//     * @param productName Name of the product.
//     * @return Quantity of the given product.
//     */
//    public int getItemQuantity(String productName) {
//        for (int i = 0; i < itemQuantity.size(); i++) {
//            if (itemQuantity.get(i).itemName.equals(productName)) {
//                return itemQuantity.get(i).getAmount();
//            }
//
//        }
//        return 0;
//    }
//
//    /**
//     * Fills the Array-List With a productOrder class, if the product is non-existent a new node
//     * will be created for the product, Otherwise the function adds to the amount, price and unitsInStock to an existing product.
//     * @param productName Name of the product.
//     * @param price The price of the product
//     * @param unitsInStock The units In stock of the product.
//     */
//    public void FillProductInArrayList(String productName, double price, int unitsInStock) {
//        boolean isFound = false;
//        int index = -1;
//        for (int i = 0; i < itemQuantity.size(); i++) {
//            if (itemQuantity.get(i).itemName.equals(productName)) {
//                itemQuantity.get(i).setAmount(itemQuantity.get(i).getAmount() + 1);
//                itemQuantity.get(i).setPrice(itemQuantity.get(i).getPrice() + price);
//                itemQuantity.get(i).setUnitsInStock((itemQuantity.get(i).getUnitsInStock()) - 1);
//                isFound = true;
//                index = i;
//            }
//        }
//        if (!isFound) {
//            Product product = new Product(productName, 1, price, unitsInStock);
//            itemQuantity.add(product);
//        }
//    }
//}