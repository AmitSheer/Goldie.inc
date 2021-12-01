package com.goldie.menu;

public class CrepeObject {
    private boolean[] chocolateType; //chocolateType[0]=dark chocolate,  chocolateType[1]=white chocolate
    private boolean[] topping;
    //topping[0]= strawberry
    //topping[1]= banana
    //topping[2]= blueberry
    //topping[3]= gummybears
    //topping[4]= oreo
    //topping[5]= whippedcream
    //topping[6]= sprinklers
    //topping[7]= dark chocolate
    //topping[8]= white chocolate

    public CrepeObject(){
        chocolateType= new boolean[2];
        topping= new boolean[9];
    }

    public boolean[] getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(boolean[] chocolateType) {
        this.chocolateType = chocolateType;
    }

    public boolean[] getTopping() {
        return topping;
    }

    public void setTopping(boolean[] topping) {
        this.topping = topping;
    }
}
