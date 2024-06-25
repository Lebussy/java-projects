package org.example;

import com.google.gson.Gson;

public class GsonReader {
    private String apiUrl;
    private Gson gson;

    // For initialising a new GsonReader
    public GsonReader(String url, Gson gson){
        this.apiUrl = url;
        this.gson = gson;
    }


}
