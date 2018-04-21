package com.quotes.app.arabicquotes.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Home on 2017-07-17.
 */

public class Data {

    String Reem;



    @SerializedName("text")
    public String text;


    @SerializedName("id_str")
    public String idStr;

    @SerializedName("retweeted_status")
    public RetweetedStatus retweetedStatus;

    @SerializedName("extended_entities")
    public ExtendedEntities extendedEntities;

    @SerializedName("retweet_count")
    public String retweetCount;
    @SerializedName("favorite_count")
    public String favoriteCount;

    public String getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(String retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public ExtendedEntities getExtendedEntities() {
        return extendedEntities;
    }

    public void setExtendedEntities(ExtendedEntities extendedEntities) {
        this.extendedEntities = extendedEntities;
    }

    public RetweetedStatus getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(RetweetedStatus retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReem() {
        return Reem;
    }

    public void setReem(String reem) {
        Reem = reem;
    }
}