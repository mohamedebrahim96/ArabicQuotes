package com.quotes.app.arabicquotes.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Home on 2017-07-16.
 */

public class Quote {

    private List<Data> data ;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }



}
