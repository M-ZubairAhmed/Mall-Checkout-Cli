package com.mastermindapps;

class Inventory {
    private int id;
    private String brandName;
    private String category;
    private int price;

    /**
     * Constructor for Inventory class.
     *
     * @param id        int value for the row number of the inventory list.
     * @param brandName string value of the brand name.
     * @param category  string value of the category.
     * @param price     integer value of the original pre discount price of the item.
     */
    Inventory(int id, String brandName, String category, int price) {
        this.id = id;
        this.brandName = brandName;
        this.category = category;
        this.price = price;
    }

    /**
     * Getter method for retrieveing id value.
     *
     * @return integer value of id of current item.
     */
    int getId() {
        return id;
    }

    /**
     * Getter method for retreiving brand's name.
     *
     * @return string value of brand of current item.
     */
    String getBrandName() {
        return brandName;
    }

    /**
     * Getter method for retrieving category's name.
     *
     * @return string value of category of current item.
     */
    String getCategory() {
        return category;
    }

    /**
     * Getter method for retrieving pre discount price.
     *
     * @return integer value of original price.
     */
    int getPrice() {
        return price;
    }
}
