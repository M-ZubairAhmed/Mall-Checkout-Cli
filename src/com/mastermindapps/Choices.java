package com.mastermindapps;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class Choices {

    private HashMap finalPriceMap = new HashMap<>();

    Choices(HashMap finalPriceMap) {
        this.finalPriceMap = finalPriceMap;
    }

    void enterChoices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of customers");
        int numberOfCustomers = getNumberOfCustomer();
        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.println("\n\nEnter choices of customer no. " + (i + 1)+"\nTo complete order enter \'X\'");
            int sum = getTotalPrice();
            System.out.println("Customer No."+(i+1)+" Total: Rs."+sum+"/-");
        }
        scanner.close();
    }

    private int getNumberOfCustomer(){
        Scanner scanner = new Scanner(System.in);
        int numberOfCustomers = 0;
        boolean flagNumberOfCustomers = true;
        while (flagNumberOfCustomers){
            try {
                numberOfCustomers = scanner.nextInt();
                flagNumberOfCustomers = false;
            }
            catch (InputMismatchException imE){
                flagNumberOfCustomers = true;
                System.out.println("ERROR! Number of customers has to be positive integer");
                scanner.next();
            }
        }
        return numberOfCustomers;
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
        try {
            return Integer.valueOf((finalPriceMap.get(selectedID)).toString());
        }
        catch (NullPointerException npE){
            System.out.println("ERROR! Please select valid choice");
            return 0;
        }
    }
}
