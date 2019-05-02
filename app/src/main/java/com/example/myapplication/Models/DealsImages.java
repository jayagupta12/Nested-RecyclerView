
        package com.example.myapplication.Models;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.List;

        public class DealsImages {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<DatumDealsImages> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DatumDealsImages> getData() {
        return data;
    }

    public void setData(List<DatumDealsImages> data) {
        this.data = data;
    }

}