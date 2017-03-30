/**
 * This program is in response to problem statement no.1 in Xtreme Mobile organised by Thoughtworks hyderabad
 *
 * @author M.Zubair Ahmed
 * Email: ahmedzubair216@gmail.com
 * Github profile: https://github.com/M-ZubairAhmed
 * Github repository: https://github.com/M-ZubairAhmed/Mall-Checkout-System
 * @see https://twhyderabad.github.io/xtrememobile/questions.html
 */
package com.mastermindapps;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        FinalPrice finalPrice = new FinalPrice();

        //We are returned with the final hashmap containing just the id and final price
        HashMap finalPriceMap = finalPrice.getFinalPrices();

        //This method displays choices for the user to select from.
        finalPrice.displayOriginalPrices();

        Choices choices = new Choices(finalPriceMap);
        //This method evaluates the total cost by taking user input.
        choices.enterChoices();

    }

}
