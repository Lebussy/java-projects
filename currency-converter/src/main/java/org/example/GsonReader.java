package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GsonReader {
    private String apiUrl;
    private Gson gson;

    // For initialising a new GsonReader
    public GsonReader(String url){
        this.apiUrl = url;
        this.gson = new Gson();
    }

    public ExchangeRates getExchangeRates(){
        return gson.fromJson(getJson(), ExchangeRates.class);
    }

    // For retrieving json as a string using httpUrlConnection
    private String getJson(){
        try{
            // Url object with the api url
            URL url = new URL(apiUrl);
            // For creating a new URl connection and setting the request to get
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // For checking the response-code
            if (con.getResponseCode() == 200){
                System.out.println("200 ok!");
                // For reading the response from input stream
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuilder response = new StringBuilder();

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }


}
