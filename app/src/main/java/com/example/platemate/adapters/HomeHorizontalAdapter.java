package com.example.platemate.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platemate.R;
import com.example.platemate.models.HomeHorizontalModel;
import com.example.platemate.models.HomeVerticalModel;

import java.util.ArrayList;

public class HomeHorizontalAdapter extends RecyclerView.Adapter<HomeHorizontalAdapter.ViewHolder> {
    // initialize variables
    VerticalDetails verticalDetails;
    Activity activity;
    ArrayList<HomeHorizontalModel> list;

    // variables used to check whether the item is selected or not
    boolean horizontal_select = true;
    boolean vertical_select = true;
    int row_index = -1;

    // Constructor for HomeHorizontalAdapter to initialize class variables
    public HomeHorizontalAdapter(VerticalDetails verticalDetails, Activity activity, ArrayList<HomeHorizontalModel> list) {
        this.verticalDetails = verticalDetails;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout and return a new ViewHolder instance
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    // Bind data to the ViewHolder instance
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set image resource and name to the horizontal item view
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if(vertical_select) {
            ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.burger1, "Max Donald", "3.5", "3.5", "7:00 - 23:00", "from  $15"));
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.burger2, "Burger Queen", "4.3", "4.3", "8:00 - 19:00", "from  $20"));
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.burger3, "B&X", "3.2", "3.2", "7:00 - 22:00", "from  $15"));

            // Pass vertical items list to the fragment using interface
            verticalDetails.retriever(position, homeVerticalModels);
            vertical_select = false;
        }

        // Set onClickListener to the card view to display vertical items when clicked
        holder.cardView.setOnClickListener(view -> {
            // store the selected row index
            row_index = position;
            // update the view
            notifyDataSetChanged();
            // Display the corresponding vertical card view based on teh selected row index
            if (position == 0) {
                // if row index 0 is selected, create an ArrayList of HomeVerticalMode objects for burger category
                ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.burger1, "Max Donald", "3.5", "3.5", "7:00 - 23:00", "from  $15"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.burger2, "Burger Queen", "4.3", "4.3", "8:00 - 19:00", "from  $20"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.burger3, "B&X", "3.2", "3.2", "7:00 - 22:00", "from  $15"));

                // call the retriever method of the homeVerticalModel objects to display the burger restaurants
                verticalDetails.retriever(position, homeVerticalModels);
            }
            else if (position == 1) {
                // if row index 1 is selected, create an ArrayList of HomeVerticalMode objects for Italian category
                ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.italian1, "Pizza Cap", "3.2", "3.2", "8:00 - 22:00", "from  $15"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.italian2, "Mr.Pastalian", "4.7", "4.7", "15:00 - 21:00", "from  $30"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.italian3, "Domingo Pizza", "3.5", "3.5", "7:00 - 23:00", "from  $15"));

                // call the retriever method of the homeVerticalModel objects to display the Italian restaurants
                verticalDetails.retriever(position, homeVerticalModels);
            }
            else if (position == 2) {
                // if row index 2 is selected, create an ArrayList of HomeVerticalMode objects for Asian category
                ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.asian1, "Sushi Ohtani", "4.8", "4.8", "12:00 - 22:00", "from  $30"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.asian2, "Coming soon", "??", "0.0", "currently unavailable", "from  $??"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.asian3, "Beijing Kitchen", "4.5", "4.5", "11:00 - 22:00", "from  $25"));

                // call the retriever method of the homeVerticalModel objects to display the Asian restaurants
                verticalDetails.retriever(position, homeVerticalModels);
            }
            else if (position == 3) {
                // if row index 3 is selected, create an ArrayList of HomeVerticalMode objects for vegetarian category
                ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.vegetarian1, "Salad House", "3.5", "3.5", "10:00 - 19:00", "from  $20"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.vegetarian2, "Vege Wrap", "4.5", "4.5", "10:00 - 22:00", "from  $15"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.vegetarian3, "Vegeta", "3.8", "3.8", "12:00 - 18:00", "from  $15"));

                // call the retriever method of the homeVerticalModel objects to display the vegetarian restaurants
                verticalDetails.retriever(position, homeVerticalModels);
            }
            else if (position == 4) {
                // if row index 4 is selected, create an ArrayList of HomeVerticalMode objects for coffee category
                ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.coffee1, "Starbox Coffee", "3.8", "3.8", "6:30 - 22:30", "from  $7"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.coffee2, "Tom Houston", "2.9", "2.9", "6:30 - 22:30", "from  $5"));

                // call the retriever method of the homeVerticalModel objects to display the coffee shops
                verticalDetails.retriever(position, homeVerticalModels);
            }
            else if (position == 5) {
                // if row index 5 is selected, create an ArrayList of HomeVerticalMode objects for dessert category
                ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.desserts1, "Sweet Hub", "3.8", "3.8", "14:30 - 20:00", "from  $15"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.desserts2, "Kam Cake", "4.1", "4.1", "12:00 - 18:00", "from  $12"));
                homeVerticalModels.add(new HomeVerticalModel(R.drawable.desserts3, "Horny Honey", "3.0", "3.0", "16:00 - 21:30", "from  $10"));

                // call the retriever method of the homeVerticalModel objects to display the dessert shops
                verticalDetails.retriever(position, homeVerticalModels);
            }
        });

        // Check if horizontal_select is true, and if position is 0, select the text view and change its color
        if (horizontal_select) {
            if (position == 0) {
                TextView textView = holder.cardView.findViewById(R.id.hor_text);
                textView.setTextColor(Color.parseColor("#03D3BF"));
                horizontal_select = false;
            }
        }
        // Check if horizontal_select is false, change the color of text view based on its position
        else {
            TextView textView = holder.cardView.findViewById(R.id.hor_text);
            if (row_index == position) {
                textView.setTextColor(Color.parseColor("#03D3BF"));
            }
            else {
                textView.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    // Return the total number of items in the list
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Define the ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Declare variables for the views
        ImageView imageView;
        TextView name;
        CardView cardView;

        // Initialize the views in the ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the views by finding them by their id
            imageView = itemView.findViewById(R.id.horizontal_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
