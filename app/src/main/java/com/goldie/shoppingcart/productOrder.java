package com.goldie.shoppingcart;

    /**
     * This class Contains information on a single item inside an Order of a costumer, it contains the Item name, the amount of units purchased of this product, and price per unit.
     * The class members are: Item as item name, amount - amount of purchased units for this item, and the price for one unit.
     * This class can: Create a product, get a product price, set a product price, set a product amount, get an item name, and get the product amount.
     */
    public class productOrder {
        /**
         * Represents the name of the item
         */
        String itemName;
        /**
         * Describes how many units are ordered within the same item.
         */
        int amount;
        /**
         * Describes the price for each unit.
         */
        double price = 0;

        /**
         * Built for Firebase imports (required) , does nothing.
         */
        public productOrder(){}

        /**
         * Constructor specifically for Order class, this constructor creates a new productOrder
         * in case there is no such productOrder in the Order Arraylist Member of Order.
         */
        public productOrder(String itemName, int amount, double price) {
            this.itemName = itemName;
            this.amount = amount;
            this.price=price;
        }

        /**
         * Copy constructor for a given Order
         * @params product - an existing productOrder node
         */
        public productOrder(productOrder product) {
            this.itemName = product.getItemName();
            this.amount = product.getAmount();
            this.price = product.getPrice();
        }

        /**
         * Returns the name of a given product.
         * @return Name of a product in String data type.
         */
        public String getItemName() {
            return itemName;
        }

        /**
         * Sets the Item name.
         */
        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        /**
         * Returns the amount of a given product.
         * @return amount of a product in Integer data type.
         */
        public int getAmount() {
            return amount;
        }

        /**
         * Sets the amount of a given product.
         */
        public void setAmount(int amount) {
            this.amount = amount;
        }

        /**
         * Returns the price of a given product
         * @return the price of a given product.
         */
        public double getPrice() {
            return price;
        }

        /**
         * Sets the amount of a given product.
         */
        public void setPrice(double price) {
            this.price = price;
        }
    }