package com.mastermindapps;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

class Choices {

    private HashMap finalPriceMap = new HashMap<>();

    /**
     * Constructor for Choices class, used primarily to initialize and get instance of finalPriceMap in this class.
     *
     * @param finalPriceMap final map which contains in key value pairs; id and post discounted price.
     */
    Choices(HashMap finalPriceMap) {
        this.finalPriceMap = finalPriceMap;
    }

    /**
     * Parent method that calls all other methods in this class.
     */
    void enterChoices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of customers");
        int numberOfCustomers = getNumberOfCustomer();
        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.println("\n\nEnter choices of customer no. " + (i + 1) + "\nTo complete order enter \'X\'");
            int sum = getTotalPrice();
            System.out.println("Customer No." + (i + 1) + " Total: Rs." + sum + "/-");
        }
        scanner.close();
    }

    /**
     * Method for scanning getting number of customers.
     *
     * @return number of customers
     * @throws InputMismatchException when character other than integers are entered
     */
    private int getNumberOfCustomer() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCustomers = 0;
        boolean flagNumberOfCustomers = true;
        while (flagNumberOfCustomers) {
            try {
                numberOfCustomers = scanner.nextInt();
                flagNumberOfCustomers = false;
            } catch (InputMismatchException imE) {
                flagNumberOfCustomers = true;
                System.out.println("ERROR! Number of customers has to be positive integer");
                scanner.next();
            }
        }
        return numberOfCustomers;
    }

    /**
     * Sums up the entered choice dynamically.
     *
     * @return total sum in integer.
     */
    private int getTotalPrice() {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = 0;
        while (scanner.hasNextInt()) {
            int selectedID = scanner.nextInt();
            totalPrice = totalPrice + getPriceFromID(selectedID);
        }
        return totalPrice;
    }

    /**
     * Matches the entered id in the finalPriceMap and retrieves associated price.
     *
     * @param selectedID id to which price is required.
     * @return associated price.
     * @throws NullPointerException when id not present in the finalPriceMap is entered.
     */
    private int getPriceFromID(int selectedID) throws NullPointerException {
        try {
            return Integer.valueOf((finalPriceMap.get(selectedID)).toString());
        } catch (NullPointerException npE) {
            int selectionRange = finalPriceMap.size();
            System.out.println("ERROR! Please select valid choice from 1 to " + selectionRange);
            return 0;
        }
    }
}
