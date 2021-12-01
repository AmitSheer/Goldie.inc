package com.goldie.menu;

public class IceCreamObject {
    private int[] flavor; //flavor[0]=chocolate, flavor[1]=vanilla, flavor[2]= strawberry, flavor[3]=chocolate
    private boolean cup, cone;

    public IceCreamObject(){
        flavor=new int[4];
    }

    public int[] getFlavor() {
        return flavor;
    }

    public void setFlavor(int[] flavor) {
        this.flavor = flavor;
    }

    public boolean isCup() {
        return cup;
    }

    public void setCup(boolean cup) {
        this.cup = cup;
    }

    public boolean isCone() {
        return cone;
    }

    public void setCone(boolean cone) {
        this.cone = cone;
    }
}
