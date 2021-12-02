package com.goldie.menu;

public class WaffleObject {

    private static class classicWaffle implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public classicWaffle() {
            productName = "classic";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class butterWaffle implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public butterWaffle() {
            productName = "butterWaffle";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class coffeeWaffle implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public coffeeWaffle() {
            productName = "coffeeWaffle";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }
}
