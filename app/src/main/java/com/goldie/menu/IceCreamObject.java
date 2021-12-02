package com.goldie.menu;

public class IceCreamObject {
    public product[] serveIn;
    public product[] flavor;

    public IceCreamObject() {
        serveIn = new product[]{new iceCreamCup(), new iceCreamCone()};
        flavor = new product[]{new vanilla(), new chocolate(), new strawberry(), new chocolate()};
    };

    private static class iceCreamCup implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public iceCreamCup() {
            productName = "cup";
            unitInStock = 1; //in stock
            PricePerUnit = 0;
        }
    }

    private static class iceCreamCone implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public iceCreamCone() {
            productName = "cone";
            unitInStock = 1; //in stock
            PricePerUnit = 0;
        }
    }

    private static class vanilla implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;
        int numOfScoops;

        public vanilla() {
            productName = "vanilla";
            unitInStock = 50;
            PricePerUnit = 1;
            numOfScoops = 0;
        }
    }

    private static class chocolate implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;
        int numOfScoops;

        public chocolate() {
            productName = "chocolate";
            unitInStock = 50;
            PricePerUnit = 1;
            numOfScoops = 0;
        }
    }


    private static class pistachio implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;
        int numOfScoops;

        public pistachio() {
            productName = "pistachio";
            unitInStock = 50;
            PricePerUnit = 1;
            numOfScoops = 0;
        }
    }

    private static class strawberry implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;
        int numOfScoops;

        public strawberry() {
            productName = "strawberry";
            unitInStock = 50;
            PricePerUnit = 1;
            numOfScoops = 0;
        }
    }
}
