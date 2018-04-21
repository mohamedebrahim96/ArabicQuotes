package com.quotes.app.arabicquotes.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Home on 2017-07-24.
 */

public class RetweetedStatus {

    @SerializedName("text")
    public String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @SerializedName("favorite_count")
    public String favorite_count;

    public String getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(String favorite_count) {
        this.favorite_count = favorite_count;
    }
}
