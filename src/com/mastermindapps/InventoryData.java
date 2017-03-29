package com.mastermindapps;

import java.util.ArrayList;

public class InventoryData {

    private ArrayList<Inventory> arrayList = new ArrayList<>();

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
