package com.goldie.account.data;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    public static String FullName, Password,Email,Phone, Uid;
    public static boolean IsAdmin,IsDelivery;
    public UserData(){
        this("","","","","");
    }
    public UserData(String fullName, String password, String email, String phone, String uid, boolean  isAdmin,boolean isDelivery){
        FullName = fullName;
        Password=password;
        Phone= phone;
        Email=email;
        Uid = uid;
        IsAdmin=isAdmin;
        IsDelivery=isDelivery;
    }

    public UserData(String fullName, String password, String email, String phone, String uid){
        FullName = fullName;
        Password=password;
        Phone= phone;
        Email=email;
        Uid = uid;
        IsAdmin= false;
        IsDelivery = false;
    }

    public static void fill(String username, String password, String email, String phone,String uid, boolean  isAdmin,boolean isDelivery){
        new UserData(username, password, email, phone, uid, isAdmin,isDelivery);
    }

    public static void fill(String username, String password, String email, String phone,String uid){
        new UserData(username, password, email, phone, uid);
    }

    /**
     * cleans all user data
     */
    public static void empty(){
        new UserData();
    }

    /**
     * changes user data to Map for easy save to database
     * @return Map of user data
     */
    public static Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("fullname", FullName);
        map.put("email",Email);
        map.put("isAdmin",IsAdmin);
        map.put("phone",Phone);
        return map;
    }

    public static void GetUserData(){

    }
}
