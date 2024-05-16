package com.example.platemate.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platemate.activities.MenuDetails;
import com.example.platemate.R;
import com.example.platemate.models.HomeVerticalModel;

import java.util.ArrayList;

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ViewHolder> {
    // Initialize variables
    Activity activity;
    ArrayList<HomeVerticalModel> list;

    // Constructor for HomeVerticalAdapter to initialize class variables
    public HomeVerticalAdapter(Activity activity, ArrayList<HomeVerticalModel> list) {
        this.activity = activity;
        this.list = list;
    }

    // create a new ViewHolder by inflating the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout and return a new ViewHolder instance
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false));
    }

    // Bind data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vertical_img.setImageResource(list.get(position).getImage());
        holder.restaurant_name.setText(list.get(position).getRestaurant_name());
        holder.rate.setText(list.get(position).getRate());
        holder.ratingbar.setRating(Float.parseFloat(list.get(position).getRatingbar()));
        holder.business_hour.setText(list.get(position).getBusiness_hour());
        holder.price.setText(list.get(position).getPrice());

        // set onClickListener to open a new activity with details of the selected vertical card view
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, MenuDetails.class);
            intent.putExtra("restaurant_name", list.get(position).getRestaurant_name());
            intent.putExtra("restaurant_image", list.get(position).getImage());
            activity.startActivity(intent);
        });
    }

    // Return the total number of items in the list
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Define the ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Declare variables for the views
        ImageView vertical_img;
        TextView restaurant_name, rate, business_hour, price;
        RatingBar ratingbar;

        // Constructor for the ViewHolder that takes in a View parameter
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the views by finding them by their id
            vertical_img = itemView.findViewById(R.id.vertical_img);
            restaurant_name = itemView.findViewById(R.id.restaurant_name);
            rate = itemView.findViewById(R.id.rate);
            ratingbar = itemView.findViewById(R.id.ratingbar);
            business_hour = itemView.findViewById(R.id.business_hour);
            price = itemView.findViewById(R.id.price);
        }
    }
}
