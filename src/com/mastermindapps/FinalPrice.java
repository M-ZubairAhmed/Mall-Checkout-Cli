package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class FinalPrice {

    private HashMap brandSet;
    private HashMap categorySet;
    private ArrayList<Inventory> pricingArray;

    /**
     * This method works calls loadCollection method, which returns populated pricing arraylist.
     * Populated pricing array list is of raw data from inventory csv. It is them parsed and
     * in this method.
     *
     * @return hashmap of index and price post max discount pair.
     */
    HashMap getFinalPrices() {
        loadCollections(); //loads classes and methods required by this class.

        HashMap<Integer, Integer> hashMap = new HashMap<>();//This map will store Id and final post discount price of items.
        for (Inventory item : pricingArray) {
            String brandName = item.getBrandName();
            String category = item.getCategory();
            int finalDiscount = getDiscountMaxFrom(brandName, category);

            int actualPrice = item.getPrice();
            int discountedPrice = calculateDiscountedPrice(actualPrice, finalDiscount);

            int id = item.getId();
            hashMap.put(id, discountedPrice);
        }

        return hashMap;
    }

    private void loadCollections() {
        CSVReader csvReader = new CSVReader();
        ArrayList<String[]> pricingFile = csvReader.readFromDisk("C:\\Users\\zub\\Documents\\GitHub\\Mall-Checkout-System\\src\\com\\mastermindapps\\CSVs\\storePricingSheet.csv");
        ArrayList<String[]> brandFile = csvReader.readFromDisk("C:\\Users\\zub\\Documents\\GitHub\\Mall-Checkout-System\\src\\com\\mastermindapps\\CSVs\\brandsSheet.csv");

        BrandsData brandsData = new BrandsData();
        brandSet = brandsData.getBrandsSet(brandFile);

        CategoriesData categoryData = new CategoriesData();
        categorySet = categoryData.getCategorySet();

        InventoryData pricing = new InventoryData();
        pricingArray = pricing.getInventoryArray(pricingFile);
    }

    private int getDiscountMaxFrom(String brand, String category) {
        int brandDiscount = Integer.valueOf(brandSet.get(brand).toString());
        int categoryDiscount = Integer.valueOf(categorySet.get(category).toString());
        if (brandDiscount > categoryDiscount) {
            return brandDiscount;
        } else {
            return categoryDiscount;
        }
    }

    private int calculateDiscountedPrice(int price, int discount) {
        return ((100 - discount) * price) / 100;
    }

}
