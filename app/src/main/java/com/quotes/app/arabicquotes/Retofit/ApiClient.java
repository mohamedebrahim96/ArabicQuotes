package com.quotes.app.arabicquotes.Retofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Home on 2017-07-16.
 */

public class ApiClient {
    public static final String url = "https://mohamedebrahim.000webhostapp.com/tweets_json.php?count=4&screen_name=Quotest_";
    public static final String BASE_URL = "https://mohamedebrahim.000webhostapp.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
