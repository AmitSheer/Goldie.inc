package com.goldie.menu;

import com.goldie.shoppingcart.Product;

import java.io.Serializable;
import java.util.List;

public class IceCreamObject implements Serializable {
    public List<Product> flavorArray;
    public Product serveIn;

    public IceCreamObject(Product serveIn, List<Product> flavorArray) {
        this.serveIn=serveIn;
        this.flavorArray= flavorArray;
    }

    public IceCreamObject(IceCreamObject other){
        this.serveIn= other.serveIn;
        this.flavorArray=other.flavorArray;
    }

}
