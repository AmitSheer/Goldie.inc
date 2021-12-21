package com.goldie.shop.shoppingcart;

import static com.goldie.shop.ShopActivity.order;

import com.goldie.account.data.UserData;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class manages order as an finished order that is ready to be sent\pulled from Firebase DB.
 * The class members are: userID String (Firebase UID of the user purchasing the current com.goldie.shop.menu.Order),
 * TotalOrder cost and Array-List of productOrder Class holding the Item, amount and price
 * for each and every item on the current order.
 * This class can(Methods): create an finished order, set User UID, add (or fill) products to the current order,
 * get the quantity of each item on request and set the total order price.
 */
public class Order {
    String userUID;
    String  order_id;
    String address;
    boolean is_delivery;
    private static long counter;
    HashMap<String,Product> products;

    public boolean isIs_delivery() {
        return is_delivery;
    }

    /**
     * Built for Firebase imports (required) , does nothing.
     */
    public Order() {
        order_id=""+counter;
        counter++;
        is_delivery=false;
        address="";
        this.products = new HashMap<>();
        //this.totalPrice = 0;
        this.userUID = UserData.Uid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIs_delivery(boolean is_delivery) {
        this.is_delivery = is_delivery;
    }

    public void setProducts(HashMap<String, Product> products) {
        this.products = products;
    }

    public String getOrder_id() {
        return order_id;
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public String getAddress() {
        return address;
    }

    public void put(String key, Product value){
        products.put(key,value);
    }
    public void remove(String key){
        products.remove(key);
    }
    public Collection<Product> values(){
        return products.values();
    }
    public void clear(){
        products.clear();
    }
//    /**
//     * Constructor for com.goldie.shop.menu.Order Class
//     * @param userUID Name of the user making the order.
//     */
//    public Order() {
//        this.userUID = userUID;
//        //is_delivered=false;
//        this.products = new
//        this.totalPrice = 0;
//    }

//    /**
//     * A copy constructor, input is an existing com.goldie.shop.menu.Order class Node,
//     * a copy if com.goldie.shop.menu.Order class is created.
//     * @param order Input the com.goldie.shop.menu.Order node to create.
//     */
//    public Order(Order order) {
//        this.userUID = order.userUID;
//        this.totalPrice = order.totalPrice;
//        this.itemQuantity = order.itemQuantity;
//    }

    /**
     * Returns the user UID from firebase DB.
     * @return Name of a product in String data type.
     */
    public String getUserUID() {
        return this.userUID;
    }

    /**
     * Sets the user UID from firebase DB.
     */
    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    /**
     * Use to get the Total com.goldie.shop.menu.Order Price.
     * @return Returns the Total com.goldie.shop.menu.Order Price.
     */
    public Double getTotalPrice() {
        double total_price=0;
        for (Product product: products.values()) {
            total_price+=product.getPrice();
        }
        return total_price;
    }
//
//    /**
//     * Sets the price of the com.goldie.shop.menu.Order,
//     * so that the total price is updated.
//     */
//    public void setTotalPrice(double price) {
//        double sumOfPrice = 0;
//        for (int i = 0; i < itemQuantity.size(); i++) {
//            sumOfPrice += itemQuantity.get(i).getPrice();
//        }
//        this.totalPrice = sumOfPrice;
//    }

//    /**
//     * @return Returns Array-List consisted of productOrder class members.
//     */
//    public ArrayList<Product> getItemQuantity() {
//        return itemQuantity;
//    }

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
}