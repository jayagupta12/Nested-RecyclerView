package com.example.myapplication.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Models.DatumCategory;
import com.example.myapplication.Models.DatumDealsImages;
import com.example.myapplication.Models.DealsImages;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.MyViewHolder> {
    Context context;
    ArrayList<DatumCategory> datumCategories;
    public DealsAdapter(Context context, ArrayList<DatumCategory> datumCategories) {
        this.context = context;
        this.datumCategories = datumCategories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        MyViewHolder mh = new MyViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        String title = datumCategories.get(i).getCatt();
        holder.itemTitle.setText(title);

        callDealsImageApi(holder,title);

    }

    private void callDealsImageApi(final MyViewHolder holder, final String title) {
   String imageurl="http://futureplanner.indiansmarthub.co.in/api/deals.php";


        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest request=new StringRequest(Request.Method.POST, imageurl, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(String response) {

                Log.e("tag_re", response);

                Gson gson = new Gson();
                DealsImages dealsImages = gson.fromJson(response.toString(), DealsImages.class);

                if (dealsImages.getStatus().equals("1")){
                    ArrayList<DatumDealsImages> dealsImagesArrayList = new ArrayList<>();
                    for (int i =0; i<dealsImages.getData().size(); i++){

                        dealsImagesArrayList.add(dealsImages.getData().get(i));
                    }


                    callImageAdapter(holder,dealsImagesArrayList);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("tag_e", String.valueOf(error));
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> data=new HashMap<>();

                data.put("token","SHIK9306488");
                data.put("typee","deals");
                data.put("catt",title);

                return data;
            }
        };
        requestQueue.add(request);



    }

    private void callImageAdapter(MyViewHolder holder, ArrayList<DatumDealsImages> datumCategories) {
        DealsImageAdapter dealsImageAdapter = new DealsImageAdapter(context, datumCategories);
        holder.recycler_view_list.setAdapter(dealsImageAdapter);
        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false));


    }

    @Override
    public int getItemCount() {
        return datumCategories.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) itemView.findViewById(R.id.recycler_view_list);

        }
    }
}
