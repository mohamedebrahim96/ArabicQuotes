package com.quotes.app.arabicquotes;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.quotes.app.arabicquotes.Adapter.PostsAdapter;
import com.quotes.app.arabicquotes.Model.Data;
import com.quotes.app.arabicquotes.Model.Quote;
import com.quotes.app.arabicquotes.Retofit.ApiClient;
import com.quotes.app.arabicquotes.Retofit.ApiInterface;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeLayout;
    RecyclerView recyclerView;
    //String url = "https://mohamedebrahim.000webhostapp.com/tweets_json.php?count=200&screen_name=Quotest_";
    Volley v = new Volley();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);





        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        swipeLayout.setRefreshing(false);
                        //Volley v = new Volley(MainActivity.this);
                        //posts = v.volley();
                        //makeAdapter();
                        v.volley(MainActivity.this,recyclerView);
                    }
                }, 5000);
            }
        });
        swipeLayout.setColorSchemeColors(Color.parseColor("#2bcbc4"));
        v.volley(MainActivity.this,recyclerView);
    }


}