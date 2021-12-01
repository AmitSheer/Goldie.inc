package com.goldie.menu;

public class FroyoObject {
    private boolean[] cupSize; //cupSize[0]=small, cupSize[1]=meduim, cupSize[2]=large
    private boolean[] flavor; //flavor[0]=kiwi, flavor[1]=peach, flavor[2]=mango,
    // flavor[3]=blueberry,flavor[4]=strawberry, flavor[5]=blackberry
    public FroyoObject(){
        cupSize= new boolean[3];
        flavor= new boolean[6];
    }

    public boolean[] getCupSize() {
        return cupSize;
    }

    public void setCupSize(boolean[] cupSize) {
        this.cupSize = cupSize;
    }

    public boolean[] getFlavor() {
        return flavor;
    }

    public void setFlavor(boolean[] flavor) {
        this.flavor = flavor;
    }
}
