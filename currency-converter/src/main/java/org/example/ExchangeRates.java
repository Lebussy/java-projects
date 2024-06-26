package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ExchangeRates {
    private HashMap<String, Float> rates;
    private String base;

    public ExchangeRates(){

    }

    public String toString(){
        return rates.toString();
    }

    public float exchange(String from, String to, float amount) throws Exception {
        // For checking that both currencies are in the keys list
        if (!(rates.containsKey(from) && rates.containsKey(to))){
            throw new Exception("One or more currencies not found, please ensure you are using the three character format eg USD or GBP");
        }

        Float fromRate = rates.get(from);
        Float toRate = rates.get(to);

        // For calculating the amount to return
        Float exchanged = (amount / fromRate) * toRate;

        return exchanged;
    }

}
