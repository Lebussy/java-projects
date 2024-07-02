package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyExchangerFactory {
    private static final Gson gson = new Gson();

    // Returns a currency exchanger object using Gson
    public static CurrencyExchanger getExchanger(){
        return gson.fromJson(getJson(), CurrencyExchanger.class);
    }

    // For retrieving json as a string using httpUrlConnection
    private static String getJson(){
        try{
            // Url object with the api url
            String apiUrl = "https://api.fxratesapi.com/latest";
            URL url = new URL(apiUrl);
            // For creating a new URl connection and setting the request to get
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // For checking the response-code
            if (con.getResponseCode() == 200){
                // For reading the response from input stream
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuilder response = new StringBuilder();

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                throw new Exception("bad url response");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
