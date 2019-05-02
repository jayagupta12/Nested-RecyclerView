package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.Models.DatumCategory;
import com.example.myapplication.Models.DatumDealsImages;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DealsImageAdapter extends RecyclerView.Adapter<DealsImageAdapter.MyViewHolder> {
    Context context;
    ArrayList<DatumDealsImages> datumCategories;
    public DealsImageAdapter(Context context, ArrayList<DatumDealsImages> datumCategories) {
        this.context = context;
        this.datumCategories = datumCategories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        MyViewHolder mh = new MyViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        String baseurl = "http://futureplanner.indiansmarthub.co.in/";
        String url = datumCategories.get(i).getImage();
        String finalurl = baseurl + url;

        Picasso.with(context).load(finalurl).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return datumCategories.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        protected ImageView itemImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemImage = (ImageView) itemView.findViewById(R.id.itemImage);

        }


    }
}
