package com.mastermindapps;

import java.util.ArrayList;

class InventoryData {

    //    arraylist to store inventory data in global scope
    private ArrayList<Inventory> arrayList = new ArrayList<>();

    /**
     * Parses string[] arraylist of inventory to arraylist of inventory type.
     *
     * @param file String[] arraylist from CSVReader
     * @return arraylist of Inventory datatype
     */
    ArrayList<Inventory> getInventoryArray(ArrayList<String[]> file) {
        for (String[] element : file) {
            int id = Integer.valueOf(element[0]);
            String brand = element[1];
            String category = element[2];
            int price = Integer.valueOf(element[3]);
            arrayList.add(new Inventory(id, brand, category, price));
        }
        return arrayList;
    }

    void displayInventory(){
        String id = "Id";
        String brand = "Brand";
        String category = "Category";
//        String discount = "Discount % ";
        String price = "Price";
        final String DISPLAY_FORMAT = "%-3d| %-15s| %-10s| %d";
        System.out.println("**************************************************************");
        System.out.println(String.format("%-3s| %-15s| %-10s| %s", id, brand, category, price));
        System.out.println("**************************************************************");
        for (Inventory item : arrayList){
            System.out.println(String.format(DISPLAY_FORMAT,item.getId(),item.getBrandName(),item.getCategory(),item.getPrice()));
        }
    }

    /**
     * TODO patch this in main
     * @param id
     * @param brand
     * @param category
     * @param price
     * @return
     */

    boolean addPricing(int id, String brand, String category, int price) {
        boolean added;
        try {
            arrayList.add(new Inventory(id, brand, category, price));
            added = true;
        } catch (NullPointerException npE) {
            added = false;
        }
        return added;
    }
}
