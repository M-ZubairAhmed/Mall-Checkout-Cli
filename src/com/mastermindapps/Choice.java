package com.mastermindapps;

import java.util.ArrayList;

public class Choice {

    void displayChoices(ArrayList choiceArray) {
        String id = "Id";
        String brand = "Brand";
        String category = "Category";
        String discount = "Discount % ";
        String price = "Price";
        System.out.println("**************************************************************");
        System.out.println(String.format("%-3s| %-15s| %-10s| %-15s| %s", id, brand, category, discount, price));
        System.out.println("**************************************************************");
        for (String line : choiceArray) {
            System.out.println(line);
        }
    }
}
