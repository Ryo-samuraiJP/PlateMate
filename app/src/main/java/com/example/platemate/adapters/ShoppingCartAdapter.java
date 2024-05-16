package com.example.platemate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platemate.R;
import com.example.platemate.models.MenuModel;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {
    ArrayList<MenuModel> shoppingCartList;
    Context context;

    public ShoppingCartAdapter(Context context, ArrayList<MenuModel> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the item layout and return the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.added_shopping_item, parent, false);
        return new ViewHolder(view);
    }

    // Bind the data to the ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuModel menuModel = shoppingCartList.get(position);
        holder.menuName.setText(menuModel.getMenuName());
        holder.menuTime.setText(menuModel.getMenuTime());
        holder.menuPrice.setText(menuModel.getMenuPrice());
        holder.menuImage.setImageResource(menuModel.getMenuImage());
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    // Define the ViewHolder class for the RecyclerView items
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Declare variables
        TextView menuName, menuTime, menuPrice;
        ImageView menuImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the views by finding them by their id
            menuName = itemView.findViewById(R.id.menu_name);
            menuTime = itemView.findViewById(R.id.time);
            menuPrice = itemView.findViewById(R.id.menu_price);
            menuImage = itemView.findViewById(R.id.menu_img);
        }
    }
}
