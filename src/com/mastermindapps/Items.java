package com.mastermindapps;

class Items {
    private int id;
    private String brandName;
    private String category;
    private int price;

    Items(int id, String brandName, String category, int price) {
        this.id = id;
        this.brandName = brandName;
        this.category = category;
        this.price = price;
    }

    int getId() {
        return id;
    }

    String getBrandName() {
        return brandName;
    }

    String getCategory() {
        return category;
    }

    int getPrice() {
        return price;
    }
}
