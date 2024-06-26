package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        GsonReader gsonReader = new GsonReader("https://api.fxratesapi.com/latest");
        ExchangeRates rate = gsonReader.getExchangeRates();

        System.out.println(rate.exchange("COP", "GBP", 10000));
    }
}