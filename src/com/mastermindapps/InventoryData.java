package com.mastermindapps;

import java.util.ArrayList;

class InventoryData {

    //    arraylist to store inventory data in global scope
    private ArrayList<Inventory> arrayList = new ArrayList<>();

    /**
     * Parses string[] arraylist of inventory to arraylist of inventory data type.
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

    /**
     * TODO add ability to add inventory in program and save file in csv.
     *
     * @param id       id of item
     * @param brand    brand name
     * @param category category item falls in
     * @param price    price of item
     * @return boolean value if item is added into arraylist or not.
     */

    boolean addPricing(int id, String brand, String category, int price) {
        boolean added;
        try {
            arrayList.add(new Inventory(id, brand, category, price));
            added = true;
        } catch (NullPointerException npE) {
            added = false;
            System.out.println("ERROR! New entry cannot be added.");
        }
        return added;
    }
}
