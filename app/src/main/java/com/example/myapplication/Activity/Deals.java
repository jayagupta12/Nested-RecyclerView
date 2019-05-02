package com.example.myapplication.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.DealsAdapter;
import com.example.myapplication.Models.Category;
import com.example.myapplication.Models.DatumCategory;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Deals extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        mRecyclerView = findViewById(R.id.my_recycler_view);

        callCategoryApi();
    }

    private void callCategoryApi() {
        String categoryurl="http://futureplanner.indiansmarthub.co.in/api/category.php?token=SHIK9306488&typee=deals";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.POST, categoryurl, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(String response) {
                Log.e("tag_", response);

                Gson gson = new Gson();
                Category category = gson.fromJson(response.toString(), Category.class);

                if (category.getStatus().equals("1")){
                    ArrayList<DatumCategory> datumCategories = new ArrayList<>();
                    for (int i =0; i<category.getData().size(); i++){

                        datumCategories.add(category.getData().get(i));
                    }


                    callAdapter(datumCategories);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("tag_e", String.valueOf(error));
            }
        });


        requestQueue.add(request);



    }



    private void callAdapter(ArrayList<DatumCategory> datumCategories) {
        DealsAdapter dealsAdapter = new DealsAdapter(Deals.this, datumCategories);
        mRecyclerView.setAdapter(dealsAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(Deals.this));

    }




}
