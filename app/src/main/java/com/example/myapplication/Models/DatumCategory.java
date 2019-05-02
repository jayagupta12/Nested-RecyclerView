package com.example.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCategory {

    @SerializedName("Sr")
    @Expose
    private String sr;
    @SerializedName("Catt")
    @Expose
    private String catt;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Time")
    @Expose
    private String time;

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getCatt() {
        return catt;
    }

    public void setCatt(String catt) {
        this.catt = catt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
