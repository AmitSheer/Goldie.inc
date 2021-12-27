package com.goldie.shop.shoppingcart;


import androidx.annotation.NonNull;

import com.goldie.account.data.UserData;
import com.goldie.shop.menu.CrepeObject;
import com.goldie.shop.menu.FroyoObject;
import com.goldie.shop.menu.IceCreamObject;
import com.goldie.shop.menu.WaffleObject;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;

/**
 * This class manages order as an finished order that is ready to be sent\pulled from Firebase DB.
 * The class members are: userID String (Firebase UID of the user purchasing the current com.goldie.shop.menu.Order),
 * TotalOrder cost and Array-List of productOrder Class holding the Item, amount and price
 * for each and every item on the current order.
 * This class can(Methods): create an finished order, set User UID, add (or fill) products to the current order,
 * get the quantity of each item on request and set the total order price.
 */
public class Order extends Observable {
    String userUID;

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    private String order_id;
    private String address;
    private String phoneNumber;
    private String userName;
    private boolean is_delivery;
    HashMap<String, Product> products;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isIs_delivery() {
        return is_delivery;
    }

    /**
     * Built for Firebase imports (required) , does nothing.
     */
    public Order() {
//        order_id = "" + counter;
//        counter++;
        Random rand=new Random();
        order_id= ""+rand.nextInt();
        is_delivery = false;
        address = "";
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

    public void put(String key, Product value) {
        products.put(key, value);
    }

    public void remove(String key) {
        products.remove(key);
    }

    public Collection<Product> values() {
        return products.values();
    }

    public void clear() {
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
     *
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
     *
     * @return Returns the Total com.goldie.shop.menu.Order Price.
     */
    public Double getTotalPrice() {
        double total_price = 0;
        for (Product product : products.values()) {
            total_price += product.getPrice();
        }
        return total_price;
    }

    public static Order parse_order(DataSnapshot dataSnapshot) {
        Order order = new Order();
        Iterable<DataSnapshot> content = dataSnapshot.getChildren();
        for (DataSnapshot child : content) {
            switch (child.getKey()) {
                case "Address": {
                    order.setAddress((String) child.getValue());
                    break;
                }
                case "User_ID": {
                    order.setUserUID((String) child.getValue());
                    break;
                }
                case "Delivery": {
                    order.setIs_delivery((Boolean) child.getValue());
                    break;
                }
                case "Products": {
                    parse_products(child, order);
                    break;
                    //order.setProducts((HashMap<String,Product>)child.getValue());
                }
                case "UserName": {
                    order.setUserName((String) child.getValue());
                    break;
                }
                case "PhoneNumber": {
                    order.setPhoneNumber((String) child.getValue());
                    break;
                }


            }
            //order_list.add(child.getKey());
        }
        return order;
    }

    public static Order parse_order(Task<DataSnapshot> task) {
        Order order = new Order();
        Iterable<DataSnapshot> content = task.getResult().getChildren();
        for (DataSnapshot child : content) {
            switch (child.getKey()) {
                case "address": {
                    order.setAddress((String) child.getValue());
                    break;
                }
                case "userUID": {
                    order.setUserUID((String) child.getValue());
                    break;
                }
                case "is_delivery": {
                    order.setIs_delivery((Boolean) child.getValue());
                    break;
                }
                case "products": {
                    parse_products(child, order);
                    break;
                    //order.setProducts((HashMap<String,Product>)child.getValue());
                }
                case "userName": {
                    order.setUserName((String) child.getValue());
                    break;
                }
                case "phoneNumber": {
                    order.setPhoneNumber((String) child.getValue());
                    break;
                }
                case "order_id": {
                    order.setOrder_id((String) child.getValue());
                    break;
                }


            }
            //order_list.add(child.getKey());
        }
        return order;
    }

    public static void parse_products(@NonNull DataSnapshot child, Order order) {
        //Product product_spec=new Product();
        for (DataSnapshot product : child.getChildren()) {
            String key = product.getKey().substring(0, product.getKey().length() - 2);

            switch (key) {
                case "Ice Cream": {
                    IceCreamObject ice_cream = new IceCreamObject();
                    ice_cream.serveIn = (String) product.child("serveIn").getValue();
                    for (DataSnapshot flavor : product.child("flavorArray").getChildren()) {
                        ice_cream.flavorArray.add((String) flavor.getValue());
                    }
                    order.put(product.getKey(), ice_cream);
                    break;
                }
                case "Crepe": {
                    CrepeObject crepe = new CrepeObject();
                    crepe.chocolateType = (String) product.child("chocolateType").getValue();
                    for (DataSnapshot flavor : product.child("toppings").getChildren()) {
                        crepe.toppings.add((String) flavor.getValue());
                    }
                    order.put(product.getKey(), crepe);
                    break;
                }
                case "Waffle": {
                    WaffleObject waffle = new WaffleObject();
                    waffle.waffleType = (String) product.child("waffleType").getValue();
                    order.put(product.getKey(), waffle);
                    break;
                }
                case "Froyo": {
                    FroyoObject froyo = new FroyoObject();
                    froyo.cupSize = (String) product.child("cupSize").getValue();
                    froyo.flavor = (String) product.child("flavor").getValue();
                    order.put(product.getKey(), froyo);
                    break;
                }
            }
            //order.put(product.getKey(),product_spec);
        }
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