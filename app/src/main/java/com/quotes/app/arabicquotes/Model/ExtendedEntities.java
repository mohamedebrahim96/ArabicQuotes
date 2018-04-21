package com.quotes.app.arabicquotes.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Home on 2017-07-24.
 */

public class ExtendedEntities {
    @SerializedName("media")
    public List<Medium__> media ;

    public List<Medium__> getMedia() {
        return media;
    }

    public void setMedia(List<Medium__> media) {
        this.media = media;
    }
}
