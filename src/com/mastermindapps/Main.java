package com.mastermindapps;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FinalPrice finalPrice = new FinalPrice();
        HashMap inventorySet = finalPrice.getFinalPrices();
        finalPrice.displayFinalPriceChoices();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of customers");
        int custNum = scanner.nextInt();

        for (int i = 0; i < custNum; i++) {
            System.out.println("Enter choices of customer no. " + (i + 1));
            int sum = getChoices(inventorySet);
            System.out.println(sum);
        }
        scanner.close();
    }

    private static int getChoices(HashMap selectionSet) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            sum = sum + Integer.valueOf((selectionSet.get(a)).toString());
        }
        return sum;
    }
}
