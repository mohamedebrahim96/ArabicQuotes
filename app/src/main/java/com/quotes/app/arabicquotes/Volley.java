package com.quotes.app.arabicquotes;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.quotes.app.arabicquotes.Adapter.PostsAdapter;
import com.quotes.app.arabicquotes.Model.Data;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Home on 2017-07-25.
 */

public  class Volley {
    Gson gson = new Gson();
    String url = "https://mohamedebrahim.000webhostapp.com/tweets_json.php?count=400&screen_name=Quotest_";
    String url2 = "https://mohamedebrahim.000webhostapp.com/tweets_json.php?count=400&screen_name=Reemmedhhat1";

    RecyclerView recyclerView2;
    Context context;
    List<Data> posts = null;
    List<Data> reemList =null  ;
    public RequestQueue queue;
    public void volley (Context context2,RecyclerView recyclerView) {
        this.recyclerView2 =  recyclerView;
        this.context =  context2;
        queue = com.android.volley.toolbox.Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ///////////////////////////////////////////////////////////
                StringRequest request2 = new StringRequest(Request.Method.GET, url2, new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response22) {
                        reemList = Arrays.asList((gson.fromJson(response22, Data[].class)));
                        for (Data post : reemList) {
                            Log.i("reemList", post.text + ": " + post.idStr);

                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                ////////////////////////////////////////////////////////////

                posts = Arrays.asList((gson.fromJson(response, Data[].class)));


                Log.i("PostActivity", posts.size() + " posts loaded.");
                for (Data post : posts) {
                    Log.i("PostActivity", post.text + ": " + post.idStr);

                }

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        PostsAdapter mAdapter = new PostsAdapter(reemList,posts,context);
                        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView2.setItemAnimator(new DefaultItemAnimator());
                        recyclerView2.setAdapter(mAdapter);
                    }
                }, 3000);

                queue.add(request2);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error Connection", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }
}
