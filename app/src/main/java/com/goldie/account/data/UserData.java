package com.goldie.account.data;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    public static String FullName, Password,Email,Phone, Uid;
    public static boolean IsAdmin;
    public UserData(){
        this("","","","","");
    }
    public UserData(String fullName, String password, String email, String phone, String uid, boolean  isAdmin){
        FullName = fullName;
        Password=password;
        Phone= phone;
        Email=email;
        Uid = uid;
        IsAdmin=isAdmin;
    }

    public UserData(String fullName, String password, String email, String phone, String uid){
        FullName = fullName;
        Password=password;
        Phone= phone;
        Email=email;
        Uid = uid;
        IsAdmin= false;
    }

    public static void fill(String username, String password, String email, String phone,String uid, boolean  isAdmin){
        new UserData(username, password, email, phone, uid, isAdmin);
    }

    public static void fill(String username, String password, String email, String phone,String uid){
        new UserData(username, password, email, phone, uid);
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
        map.put("uid",Uid);
        return map;
    }

    public static void GetUserData(){

    }
}
