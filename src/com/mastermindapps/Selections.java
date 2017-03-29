package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class Selections {

    private HashMap brandSet;
    private HashMap categorySet;
    private ArrayList<Inventory> pricingArray;
    private ArrayList<String> displayChoiceArray = new ArrayList<>();

    HashMap getSelectionSet() {

        loadCollections();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Inventory item : pricingArray) {
            int id = item.getId();
            String brand = item.getBrandName();
            String category = item.getCategory();
            int discount = maxDiscount(brand, category);
            int price = item.getPrice();
            int finalPrice = discountedPrice(price, discount);
            displayChoiceArray.add(String.format("%-3d| %-15s| %-10s| %-15d| %d", id, brand, category, discount, finalPrice));
            hashMap.put(id, finalPrice);
        }
        return hashMap;
    }

    private void loadCollections() {
        CSVReader csvReader = new CSVReader();
        ArrayList<String[]> pricingFile = csvReader.readFromDisk("src\\com\\mastermindapps\\storePricingSheet.csv");
        ArrayList<String[]> brandFile = csvReader.readFromDisk("src\\com\\mastermindapps\\brandsSheet.csv");

        BrandsData brandsData = new BrandsData();
        brandSet = brandsData.getBrandsSet(brandFile);

        CategoriesData categoryData = new CategoriesData();
        categorySet = categoryData.getCategorySet();

        InventoryData pricing = new InventoryData();
        pricingArray = pricing.getInventoryArray(pricingFile);
    }

    private int maxDiscount(String brand, String category) {
        int brandDiscount = Integer.valueOf(brandSet.get(brand).toString());
        int categoryDiscount = Integer.valueOf(categorySet.get(category).toString());
        if (brandDiscount > categoryDiscount) {
            return brandDiscount;
        } else {
            return categoryDiscount;
        }
    }

    private int discountedPrice(int price, int discount) {
        return ((100 - discount) * price) / 100;
    }

    void showChoices() {
        String id = "Id";
        String brand = "Brand";
        String category = "Category";
        String discount = "Discount % ";
        String price = "Price";
        System.out.println("**************************************************************");
        System.out.println(String.format("%-3s| %-15s| %-10s| %-15s| %s", id, brand, category, discount, price));
        System.out.println("**************************************************************");
        for (String line : displayChoiceArray) {
            System.out.println(line);
        }
    }
}
