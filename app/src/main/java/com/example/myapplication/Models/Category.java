
        package com.example.myapplication.Models;

import java.util.List;

import com.example.myapplication.Models.DatumCategory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<DatumCategory> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DatumCategory> getData() {
        return data;
    }

    public void setData(List<DatumCategory> data) {
        this.data = data;
    }

}