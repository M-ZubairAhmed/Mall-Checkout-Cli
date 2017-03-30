package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class Selections {

    private HashMap brandSet;
    private HashMap categorySet;
    private ArrayList<Inventory> pricingArray;
    private ArrayList<String> displayChoiceArray = new ArrayList<>();

    /**
     * This method works calls loadCollection method, which returns populated pricing arraylist.
     * Populated pricing array list is of raw data from inventory csv. It is them parsed and
     * in this method.
     *
     * @return hashmap of index and price post max discount pair.
     */
    HashMap getSelectionSet() {
        /*
        loadCollections method is called initially to instantiate classes and collections required by this
        method.
         */
        loadCollections();

        HashMap<Integer, Integer> hashMap = new HashMap<>();//This map will store Id and final post discount price.

        for (Inventory item : pricingArray) {

            String brandName = item.getBrandName();
            String category = item.getCategory();
            int finalDiscount = getDiscountMaxFrom(brandName, category);

            int actualPrice = item.getPrice();
            int discountedPrice = calculateDiscountedPrice(actualPrice, finalDiscount);
            //This array list stores data which will be displayed on malls system from
            //where owner will select the items during checkout.
            int id = item.getId();
            hashMap.put(id, discountedPrice);

            displayChoiceArray.add(String.format("%-3d| %-15s| %-10s| %-15d| %d", id, brandName, category, finalDiscount, discountedPrice));
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
