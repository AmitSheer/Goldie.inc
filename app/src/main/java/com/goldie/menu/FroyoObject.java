package com.goldie.menu;

public class FroyoObject {
    public product[] cupSize;
    public product[] flavor;

    public FroyoObject() {
        cupSize = new product[]{new smallCup(), new mediumCup(), new largeCup()};
        flavor = new product[]{new kiwiFroyo(), new peachFroyo(), new mangoFroyo(),
                new blueberryFroyo(), new strawberryFroyo(), new blackberryFroyo()};
    };


    private static class smallCup implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public smallCup() {
            productName = "Small cup";
            unitInStock = 1; //in stock
            PricePerUnit = 3;
        }
    }

    private static class mediumCup implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public mediumCup() {
            productName = "Medium cup";
            unitInStock = 1; //in stock
            PricePerUnit = 4;
        }
    }

    private static class largeCup implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public largeCup() {
            productName = "Large cup";
            unitInStock = 1; //in stock
            PricePerUnit = 6;
        }
    }

    private static class kiwiFroyo implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public kiwiFroyo() {
            productName = "Kiwi";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class peachFroyo implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public peachFroyo() {
            productName = "Peach";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class mangoFroyo implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public mangoFroyo() {
            productName = "Mango";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class blueberryFroyo implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public blueberryFroyo() {
            productName = "Blueberry";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class strawberryFroyo implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public strawberryFroyo() {
            productName = "Strawberry";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }

    private static class blackberryFroyo implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public blackberryFroyo() {
            productName = "Blackberry";
            unitInStock = 50;
            PricePerUnit = 0;
        }
    }
}
