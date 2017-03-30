/**
 * 
 */
package com.mastermindapps;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        FinalPrice finalPrice = new FinalPrice();

        HashMap finalPriceMap = finalPrice.getFinalPrices();

        finalPrice.displayOriginalPrices();

        Choices choices = new Choices(finalPriceMap);
        choices.enterChoices();

    }

}
