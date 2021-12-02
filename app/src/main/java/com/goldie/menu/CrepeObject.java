package com.goldie.menu;

public class CrepeObject {
    public product[] chocolateType;
    public product[] toppings;

    public CrepeObject() {
        chocolateType = new product[]{new darkChocolate(), new whiteChocolate()};
        toppings = new product[]{new strawberryCrepeTopping(), new BananaCrepeTopping(),
                new BlueberryCrepeTopping(), new GummyBearsCrepeTopping(),
                new OreoCrepeTopping(), new WhippedCreamCrepeTopping(), new SprinklersCrepeTopping(),
                new DarkChocolateTopping(), new WhiteChocolateTopping()};
    }


    private static class darkChocolate implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public darkChocolate() {
            productName = "Dark chocolate";
            unitInStock = 1; //in stock
            PricePerUnit = 0;
        }
    }

    private static class whiteChocolate implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public whiteChocolate() {
            productName = "White chocolate";
            unitInStock = 1; //in stock
            PricePerUnit = 0;
        }
    }

    private static class strawberryCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public strawberryCrepeTopping() {
            productName = "Strawberry";
            unitInStock = 1; //in stock
            PricePerUnit = 1;
        }
    }

    private static class BananaCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public BananaCrepeTopping() {
            productName = "Banana";
            unitInStock = 1; //in stock
            PricePerUnit = 1;
        }
    }

    private static class BlueberryCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public BlueberryCrepeTopping() {
            productName = "Blueberry";
            unitInStock = 1; //in stock
            PricePerUnit = 1;
        }
    }

    private static class GummyBearsCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public GummyBearsCrepeTopping() {
            productName = "Gummy Bears";
            unitInStock = 1; //in stock
            PricePerUnit = 2;
        }
    }

    private static class OreoCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public OreoCrepeTopping() {
            productName = "Oreo";
            unitInStock = 1; //in stock
            PricePerUnit = 2;
        }
    }

    private static class WhippedCreamCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public WhippedCreamCrepeTopping() {
            productName = "Whipped Cream";
            unitInStock = 1; //in stock
            PricePerUnit = 0;
        }
    }

    private static class SprinklersCrepeTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public SprinklersCrepeTopping() {
            productName = "Sprinklers";
            unitInStock = 1; //in stock
            PricePerUnit = 0;
        }
    }

    private static class DarkChocolateTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public DarkChocolateTopping() {
            productName = "Dark Chocolate Topping";
            unitInStock = 1; //in stock
            PricePerUnit = 1;
        }
    }

    private static class WhiteChocolateTopping implements product {
        String productName;
        int unitInStock;
        int PricePerUnit;

        public WhiteChocolateTopping() {
            productName = "White Chocolate Topping";
            unitInStock = 1; //in stock
            PricePerUnit = 1;
        }
    }

}
