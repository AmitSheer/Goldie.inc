package com.goldie.account.data;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    public static String FullName, Password,Email,Phone;
    public static Boolean IsAdmin;
    public UserData(){
        this("","","","");
    }
    public UserData(String fullName, String password, String email, String phone, boolean  isAdmin){
        FullName = fullName;
        Password=password;
        Phone= phone;
        Email=email;
        IsAdmin=isAdmin;
    }

    public UserData(String fullName, String password, String email, String phone){
        FullName = fullName;
        Password=password;
        Phone= phone;
        Email=email;
        IsAdmin= false;
    }

    public static void fill(String username, String password, String email, String phone, boolean  isAdmin){
        new UserData(username, password, email, phone, isAdmin);
    }

    public static void fill(String username, String password, String email, String phone){
        new UserData(username, password, email, phone);
    }

    public static void empty(){
        new UserData();
    }

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
