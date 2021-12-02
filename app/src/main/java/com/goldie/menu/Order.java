package com.goldie.menu;

import com.goldie.menu.CrepeObject;
import com.goldie.menu.FroyoObject;
import com.goldie.menu.IceCreamObject;
import com.goldie.menu.WaffleObject;

public class Order {
    private IceCreamObject iceCream;
    private WaffleObject waffle;
    private CrepeObject crepe;
    private FroyoObject froyo;

    Order(){
        iceCream= new IceCreamObject();
        waffle= new WaffleObject();
        crepe= new CrepeObject();
        froyo= new FroyoObject();
    }

    public IceCreamObject getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCreamObject iceCream) {
        this.iceCream = iceCream;
    }

    public WaffleObject getWaffle() {
        return waffle;
    }

    public void setWaffle(WaffleObject waffle) {
        this.waffle = waffle;
    }

    public CrepeObject getCrepe() {
        return crepe;
    }

    public void setCrepe(CrepeObject crepe) {
        this.crepe = crepe;
    }

    public FroyoObject getFroyo() {
        return froyo;
    }

    public void setFroyo(FroyoObject froyo) {
        this.froyo = froyo;
    }
}
