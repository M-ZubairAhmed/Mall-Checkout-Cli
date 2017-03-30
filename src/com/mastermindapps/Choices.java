package com.mastermindapps;

import java.util.HashMap;
import java.util.Scanner;

class Choices {

    private HashMap finalPriceMap = new HashMap<>();

    Choices(HashMap finalPriceMap) {
        this.finalPriceMap = finalPriceMap;
    }

    void enterChoices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of customers");
        int custNum = scanner.nextInt();
        for (int i = 0; i < custNum; i++) {
            System.out.println("\n\nEnter choices of customer no. " + (i + 1)+"\nTo complete order enter \'X\'");
            int sum = getTotalPrice();
            System.out.println("Customer No."+(i+1)+" Total: Rs."+sum+"/-");
        }
        scanner.close();
    }

    private int getTotalPrice() {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = 0;
        while (scanner.hasNextInt()) {
            int selectedID = scanner.nextInt();
            totalPrice = totalPrice + getPriceFromID(selectedID);
        }
        return totalPrice;
    }

    private int getPriceFromID(int selectedID) {
        return Integer.valueOf((finalPriceMap.get(selectedID)).toString());
    }
}
