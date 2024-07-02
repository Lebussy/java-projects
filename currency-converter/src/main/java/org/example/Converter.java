package org.example;

public class Converter {
    private CurrencyExchanger exchanger;

    public Converter(){
    }

    public double convert(String currencyFrom, String currencyTo, double amount){
        refreshRates();
        try{
            return exchanger.exchange(currencyFrom, currencyTo, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void refreshRates() {
        this.exchanger = CurrencyExchangerFactory.getExchanger();
    }

}
