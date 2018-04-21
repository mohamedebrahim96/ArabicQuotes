package com.quotes.app.arabicquotes.Retofit;

import com.quotes.app.arabicquotes.Model.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Home on 2017-07-16.
 */

public interface ApiInterface {
    /*@GET("movie/top_rated")
    Call<Quote> getTopRatedMovies(@Query("api_key") String apiKey);*/

    /*@GET("/bins/1dcbez")
    public void getBooks(Callback<List<Quote>> response);*/

    @GET("tweets_json.php")
    Call<Quote> getquotes(@Query("count") int count, @Query("screen_name") String screen_name);


}
