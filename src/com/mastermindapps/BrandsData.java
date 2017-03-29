package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class BrandsData {

    //Hashmap declared for global scope.
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
     * ToDO make this for later
     *
     * @param brandName
     * @param discount
     * @return
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
