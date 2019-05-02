package com.example.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumDealsImages {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Desc")
    @Expose
    private String desc;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("MRP")
    @Expose
    private String mRP;
    @SerializedName("Sale_price")
    @Expose
    private String salePrice;
    @SerializedName("Valid_date")
    @Expose
    private String validDate;
    @SerializedName("Current_date")
    @Expose
    private String currentDate;
    @SerializedName("Expire_time")
    @Expose
    private String expireTime;
    @SerializedName("Cat")
    @Expose
    private String cat;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMRP() {
        return mRP;
    }

    public void setMRP(String mRP) {
        this.mRP = mRP;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

}
