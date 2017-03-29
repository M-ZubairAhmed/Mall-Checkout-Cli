package com.mastermindapps.DataTypes;

class Categories {
    private String categoryName;
    private String categoryParent;
    private int discount;

    Categories(String categoryName, String categoryParent, int discount) {
        this.categoryName = categoryName;
        this.categoryParent = categoryParent;
        this.discount = discount;
    }

    String getCategoryName() {
        return categoryName;
    }

    String getCategoryParent() {
        return categoryParent;
    }

    int getDiscount() {
        return discount;
    }

}
