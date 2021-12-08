package com.goldie.shop.menu;

import com.goldie.shop.shoppingcart.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IceCreamObject extends Product implements Serializable {
    public List<String> flavorArray;
    public String serveIn;

//    public IceCreamObject(Product serveIn, List<Product> flavorArray) {
//        this.serveIn=serveIn;
//        this.flavorArray= flavorArray;
//    }
    public IceCreamObject(){
        super("Ice Cream",1,0,1);
        flavorArray=new ArrayList<>();
        serveIn="";
    }
    public IceCreamObject(List<String> flavorArray, String serveIn) {
        this.flavorArray = flavorArray;
        this.serveIn = serveIn;
    }

    public IceCreamObject(IceCreamObject other){
        this.serveIn= other.serveIn;
        this.flavorArray=other.flavorArray;
    }

}
