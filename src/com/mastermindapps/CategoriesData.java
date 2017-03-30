package com.mastermindapps;

import java.util.ArrayList;
import java.util.HashMap;

class CategoriesData {

    private ArrayList<Categories> arrayList = new ArrayList<>();

    /**
     * Takes ArrayList of Categories type and parses them to put in a hashmap
     *
     * @return Hashmap with category as key and max discount as value.
     */
    HashMap getCategorySet() {
        addStoredCategories();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Categories category : arrayList) {
            hashMap.put(category.getCategoryName(), maxCategoryDiscount(category.getCategoryName()));
        }
        return hashMap;
    }

    /**
     * Manually input of category data in arraylist.
     */
    private void addStoredCategories() {
        arrayList.add(new Categories("MEN\'S WEAR", null, 0));
        arrayList.add(new Categories("SHIRTS", "MEN\'S WEAR", 0));
        arrayList.add(new Categories("TROUSERS", "MEN\'S WEAR", 0));
        arrayList.add(new Categories("CASUALS", "TROUSERS", 30));
        arrayList.add(new Categories("JEANS", "TROUSERS", 20));
        arrayList.add(new Categories("WOMEN\'S WEAR", null, 50));
        arrayList.add(new Categories("DRESSES", "WOMEN\'S WEAR", 0));
        arrayList.add(new Categories("FOOTWEAR", "WOMEN\'S WEAR", 0));
    }

    /**
     * Key is checked in the arraylist to retrieve corresponding discount value. Search follows going through
     * category and category all the way reaching to root of categories.
     *
     * @param searchCategory key which is searched for in arraylist of categories
     * @return max discount value in the category hierarchy.
     */
    private int maxCategoryDiscount(String searchCategory) {
        int maxDiscount = 0;
        int i = 0;
        while (searchCategory != null) {
            String categoryName = arrayList.get(i).getCategoryName();
            if (searchCategory.equalsIgnoreCase(categoryName)) {
                searchCategory = arrayList.get(i).getCategoryParent(); //search key is now the parent of found key.
                if (maxDiscount < arrayList.get(i).getDiscount()) { //check for discount max in the hierarchy of category
                    maxDiscount = arrayList.get(i).getDiscount();
                }
                i = 0;
            } else {
                if (i++ >= arrayList.size()) {
                    i = 0;
                }
            }
        }
        return maxDiscount;
    }

    /**
     * TODO ability to add categories in program
     *
     * @param categoryName   name of category
     * @param categoryParent name of parent category
     * @param discount       discount on the category
     * @return boolean value if entry is added or not.
     */
    boolean addNewCategory(String categoryName, String categoryParent, int discount) {
        boolean added;
        try {
            arrayList.add(new Categories(categoryName, categoryParent, discount));
            added = true;
        } catch (Exception e) {
            added = false;
        }
        return added;
    }
}
