package org.example;

import java.util.HashMap;

public class CurrencyExchanger {
    // Stores the exchange rates in relation to USD
    private HashMap<String, Float> rates;
    private String base;

    public double exchange(String from, String to, double amount) throws Exception {

        // For checking that both currencies are in the keys list
        if (!(rates.containsKey(from) && rates.containsKey(to))){
            throw new Exception("One or more currencies not found, please ensure you are using the three character format eg USD or GBP");
        }

        // Stores the to and from exchange rates in relation to the base currency (USD)
        Float fromRate = rates.get(from);
        Float toRate = rates.get(to);

        // For calculating the amount to return
        double exchanged = (amount / fromRate) * toRate;
        return roundDownToTwoDps(exchanged);
    }

    private static double roundDownToTwoDps (double amount){
        return Math.floor(amount * 100) / 100;
    }

}
