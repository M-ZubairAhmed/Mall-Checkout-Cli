package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class BrandsData {

    private HashMap<String, Integer> hashMap = new HashMap<>();

    /**
     * Parses the brand file array created from CSVReader Class method. Since Brands file array
     * contain two elements in each index of string array. The first corresponds to brands name
     * and second to brand's discount. Both values are inserted into hashmap collection.
     *
     * @param fileArray read file from CSVReader for brands data
     * @return hashmap with key as brand's name and value as its discount
     */
    HashMap getBrandsSet(ArrayList<String[]> fileArray) {
        for (String[] element : fileArray) {
            String brandName = element[0];
            int discount = Integer.valueOf(element[1]);
            hashMap.put(brandName, discount);
        }
        return hashMap;
    }

    /**
     * ToDO Ability to add brands and save them in brands csv file.
     *
     * @param brandName brand name
     * @param discount  discount on the brand
     * @return boolean value if entry is added or not.
     */
    boolean addBrand(String brandName, int discount) {
        boolean added;
        try {
            hashMap.put(brandName, discount);
            added = true;
        } catch (Exception E) {
            added = false;
        }
        return added;
    }
}
