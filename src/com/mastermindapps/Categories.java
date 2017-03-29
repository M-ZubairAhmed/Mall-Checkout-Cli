package com.mastermindapps;

class Categories {
    private String categoryName;
    private String categoryParent;
    private int discount;

    /**
     * Constructor for category class.
     *
     * @param categoryName   name of the current category
     * @param categoryParent name of current category's direct parent.
     * @param discount       discount associated with current category irrespective of parent.
     */
    Categories(String categoryName, String categoryParent, int discount) {
        this.categoryName = categoryName;
        this.categoryParent = categoryParent;
        this.discount = discount;
    }

    /**
     * Getter method for current category name
     *
     * @return string name of category
     */
    String getCategoryName() {
        return categoryName;
    }

    /**
     * Getter method for initalized category's parent
     *
     * @return string name of category parent
     */
    String getCategoryParent() {
        return categoryParent;
    }

    /**
     * Getter method for initiazed category's discount
     *
     * @return integer value of category's discount
     */
    int getDiscount() {
        return discount;
    }

}
