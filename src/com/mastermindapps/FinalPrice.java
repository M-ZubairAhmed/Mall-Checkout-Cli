package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class FinalPrice {

    private HashMap brandSet;
    private HashMap categorySet;
    private ArrayList<Inventory> pricingArray;

    /**
     * This method does all the heavy operations and filters the result. Initially it calls loadCollections which
     * instantiate various class and call respective method on them. It then gets the final max discount from the
     * passed it category and brand. Calculated price after discount is stores in hashmap along with corresponding
     * id.
     *
     * @return hashmap of index and price post max discount pair.
     */
    HashMap getFinalPrices() {
        loadCollections(); //loads classes and methods required by this class.

        HashMap<Integer, Integer> finalPriceMap = new HashMap<>();
        for (Inventory item : pricingArray) {
            String brandName = item.getBrandName();
            String category = item.getCategory();
            int finalDiscount = getDiscountMaxFrom(brandName, category);
            int actualPrice = item.getPrice();
            int discountedPrice = calculateDiscountedPrice(actualPrice, finalDiscount);
            int id = item.getId();
            finalPriceMap.put(id, discountedPrice);
        }
        return finalPriceMap;
    }

    /**
     * This method instantiates CSVReader, BrandData, CategoryData and InventoryData class. Calls suitable methods
     * to fetch arraylist of pricing, hashmap of categories, hashmap of brands. These will be used in getFinalPrices.
     */
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

    /**
     * Method to find out maximum discount of brand and category.
     *
     * @param brand    brand name
     * @param category category
     * @return max of brand and category
     */
    private int getDiscountMaxFrom(String brand, String category) {
        int brandDiscount = Integer.valueOf(brandSet.get(brand).toString());
        int categoryDiscount = Integer.valueOf(categorySet.get(category).toString());
        if (brandDiscount > categoryDiscount) {
            return brandDiscount;
        } else {
            return categoryDiscount;
        }
    }

    /**
     * Calculates price adjusted with discount
     *
     * @param price    actual price
     * @param discount discount
     * @return price after discount
     */
    private int calculateDiscountedPrice(int price, int discount) {
        return ((100 - discount) * price) / 100;
    }

    /**
     * This method displays on the screen, UI for the user to select the choices from.
     */
    void displayOriginalPrices() {
        String id = "Id";
        String brand = "Brand";
        String category = "Category";
        String price = "Price";
        final String DISPLAY_FORMAT = "%-3d| %-15s| %-10s| %d";
        System.out.println("**************************************************************");
        System.out.println(String.format("%-3s| %-15s| %-10s| %s", id, brand, category, price));
        System.out.println("**************************************************************");
        for (Inventory item : pricingArray) {
            System.out.println(String.format(DISPLAY_FORMAT, item.getId(), item.getBrandName(), item.getCategory(), item.getPrice()));
        }
    }

}
