package com.example.platemate.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platemate.R;
import com.example.platemate.activities.ShoppingCart;
import com.example.platemate.models.MenuModel;

import java.util.ArrayList;

public class MenuDetailsAdapter extends RecyclerView.Adapter<MenuDetailsAdapter.ViewHolder> {
    // Initialize variables
    Activity activity;
    ArrayList<MenuModel> menuList;
    ArrayList<MenuModel> shoppingCartList;

    // Constructor for MenuDetailsAdapter to set the activity, menu list and initialize the shoppingCartList
    public MenuDetailsAdapter(Activity activity, ArrayList<MenuModel> menuList) {
        this.activity = activity;
        this.menuList = menuList;
        this.shoppingCartList = new ArrayList<>();
    }

    // create the view holder for the adapter
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the menu_list layout and return a new ViewHolder with this layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list, parent, false);
        return new ViewHolder(view);
    }

    // Bind the menu data to the view holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the menu model at the current position in the menuList
        MenuModel menuModel = menuList.get(position);

        // Set the menu name, time, price and image to the view holder
        holder.menuName.setText(menuModel.getMenuName());
        holder.menuTime.setText(menuModel.getMenuTime());
        holder.menuPrice.setText(menuModel.getMenuPrice());
        holder.menuImage.setImageResource(menuModel.getMenuImage());

        /* Set onClickListener to add the menu item to the shopping cart list,
        /* show a success toast message, and start the ShoppingCart activity */
        holder.btnAddToCart.setOnClickListener(view -> {
            shoppingCartList.add(menuModel);
            Toast.makeText(view.getContext(), "Item is added to your shopping cart", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity, ShoppingCart.class);
            intent.putExtra("shoppingCartList", new ArrayList<>(shoppingCartList));
            activity.startActivity(intent);
        });
    }

    // Return the size of the menuList
    @Override
    public int getItemCount() {
        return menuList.size();
    }

    // Create the view holder class for the adapter
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Declare variables
        TextView menuName, menuTime, menuPrice;
        ImageView menuImage;
        Button btnAddToCart;

        // Initialize the view holder with the menu name, time, price, image and add to cart button
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the views by finding them by their id
            menuName = itemView.findViewById(R.id.menu_name);
            menuTime = itemView.findViewById(R.id.time);
            menuPrice = itemView.findViewById(R.id.menu_price);
            menuImage = itemView.findViewById(R.id.menu_img);
            btnAddToCart = itemView.findViewById(R.id.btn_addToCart);
        }
    }
}