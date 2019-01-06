package com.example.jochemmortiers.numbertrivia2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nummer {

    @SerializedName("text")
    @Expose
    public String text;

    @SerializedName("number")
    @Expose
    public Integer number;

    @SerializedName("found")
    @Expose
    public Boolean found;

    @SerializedName("type")
    @Expose
    public String type;


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public boolean isFound() {
        return found;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
