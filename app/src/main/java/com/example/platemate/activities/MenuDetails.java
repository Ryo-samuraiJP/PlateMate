package com.example.platemate.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.platemate.R;
import com.example.platemate.models.MenuModel;
import com.example.platemate.adapters.MenuDetailsAdapter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class MenuDetails extends AppCompatActivity {
    // Initialize variables
    RoundedImageView restaurantImg;
    Button btnAddToCart;
    RecyclerView menuListRecyclerView;
    ArrayList<MenuModel> menuList;
    MenuDetailsAdapter menuDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);

        // Retrieve data from intent
        String restaurantName = getIntent().getStringExtra("restaurant_name");
        int restaurantImage = getIntent().getIntExtra("restaurant_image", 0);

        // Set restaurant name and image
//        TextView restaurantNameTextView = findViewById(R.id.restaurant_name);
//        restaurantNameTextView.setText(restaurantName);

        // Get reference and set its image
        restaurantImg = findViewById(R.id.restaurant_img);
        restaurantImg.setImageResource(restaurantImage);

        // Get the menu list based on restaurant name
        menuList = getMenuList(restaurantName);

        // Set up the recycler view for the menu items
        menuListRecyclerView = findViewById(R.id.menu_item_rec);
        btnAddToCart = findViewById(R.id.btn_addToCart);
        menuDetailsAdapter = new MenuDetailsAdapter(this, menuList);
        menuListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuListRecyclerView.setAdapter(menuDetailsAdapter);
    }

    // Method to get the list of menu items for an each restaurant
    public ArrayList<MenuModel> getMenuList(String restaurantName) {
        // Create an array list to hold the menu items
        ArrayList<MenuModel> menuList = new ArrayList<>();

        // Populate the menu items and restaurant logo image based on the restaurant name
        switch (restaurantName) {
            case "Max Donald":
                restaurantImg.setImageResource(R.drawable.burger_logo1);
                menuList.add(new MenuModel("Max Burger", "12min", "15", R.drawable.burger1));
                menuList.add(new MenuModel("Cheese Burger", "10min", "10", R.drawable.cheese_burger));
                menuList.add(new MenuModel("Creamy Combo", "10min", "12", R.drawable.burger_combo));
                break;
            case "Burger Queen":
                restaurantImg.setImageResource(R.drawable.burger_logo2);
                menuList.add(new MenuModel("Queen Burger", "10min", "15", R.drawable.burger2));
                menuList.add(new MenuModel("Fish Burger", "10min", "10", R.drawable.fish_burger));
                menuList.add(new MenuModel("Shrimp Burger", "12min", "15", R.drawable.shrimp_burger));
                break;
            case "B&X":
                restaurantImg.setImageResource(R.drawable.burger_logo3);
                menuList.add(new MenuModel("B&X Burger", "15min", "15", R.drawable.burger3));
                menuList.add(new MenuModel("Burger Combo", "17min", "17", R.drawable.burger_combo2));
                menuList.add(new MenuModel("Tomato Burger", "10min", "15", R.drawable.tomato_burger));
                break;
            case "Pizza Cap":
                restaurantImg.setImageResource(R.drawable.italian_logo1);
                menuList.add(new MenuModel("Margerita", "15min", "12", R.drawable.margerita));
                menuList.add(new MenuModel("Vegetable Pizza", "15min", "11", R.drawable.vege_pizza));
                menuList.add(new MenuModel("Cheese Pizza", "15min", "12", R.drawable.cheese_pizza));
                break;
            case "Mr.Pastalian":
                restaurantImg.setImageResource(R.drawable.italian_logo2);
                menuList.add(new MenuModel("Pescatore", "15min", "15", R.drawable.pescatore));
                menuList.add(new MenuModel("Genoveze", "15min", "15", R.drawable.genoveze));
                menuList.add(new MenuModel("Cream Pasta", "10min", "10", R.drawable.cream_pasta));
                break;
            case "Domingo Pizza":
                restaurantImg.setImageResource(R.drawable.italian_logo3);
                menuList.add(new MenuModel("Ham Pizza", "15min", "15", R.drawable.ham_pizza));
                menuList.add(new MenuModel("Beef Pizza", "15min", "15", R.drawable.beef_pizza));
                menuList.add(new MenuModel("Chicken Pizza", "10min", "10", R.drawable.chicken_pizza));
                break;
            case "Sushi Ohtani":
                restaurantImg.setImageResource(R.drawable.asian_logo1);
                menuList.add(new MenuModel("Ohtani Special", "15min", "30", R.drawable.asian1));
                menuList.add(new MenuModel("Sashimi", "10min", "25", R.drawable.sashimi));
                menuList.add(new MenuModel("Roll Sushi", "7min", "20", R.drawable.roll_sushi));
                break;
            case "Coming soon":
                restaurantImg.setImageResource(R.drawable.asian_logo2);
                // coming soon
                break;
            case "Beijing Kitchen":
                restaurantImg.setImageResource(R.drawable.asian_logo3);
                menuList.add(new MenuModel("Beijing Chicken", "15min", "12", R.drawable.asian3));
                menuList.add(new MenuModel("Garlic Rice", "20min", "15", R.drawable.garlic_rice));
                menuList.add(new MenuModel("Tenshinhan", "20min", "20", R.drawable.tenshinhan));
                break;
            case "Salad House":
                restaurantImg.setImageResource(R.drawable.vegetarian_logo1);
                menuList.add(new MenuModel("Mr.Vegetarian", "10min", "15", R.drawable.vegetarian1));
                menuList.add(new MenuModel("Vegetarian Pasta", "15min", "15", R.drawable.vege_pasta));
                menuList.add(new MenuModel("Vegetarian Tacos", "7min", "20", R.drawable.tacos));
                break;
            case "Vege Wrap":
                restaurantImg.setImageResource(R.drawable.vegetarian_logo2);
                menuList.add(new MenuModel("Vegetarian Wraps", "10min", "12", R.drawable.vegetarian2));
                menuList.add(new MenuModel("Green Wraps", "12min", "15", R.drawable.green_wrap));
                menuList.add(new MenuModel("Vege Sandwich", "10min", "15", R.drawable.vege_sand));
                break;
            case "Vegeta":
                restaurantImg.setImageResource(R.drawable.vegetarian_logo3);
                menuList.add(new MenuModel("Vegetarian Roll", "15min", "15", R.drawable.vegetarian3));
                menuList.add(new MenuModel("Vege Norimaki", "20min", "20", R.drawable.vege_norimaki));
                menuList.add(new MenuModel("Vegeta Special", "20min", "25", R.drawable.vegeta_special));
                break;
            case "Starbox Coffee":
                restaurantImg.setImageResource(R.drawable.coffee_logo1);
                menuList.add(new MenuModel("Captino", "7min", "7", R.drawable.captino));
                menuList.add(new MenuModel("Espresso", "10min", "10", R.drawable.espresso));
                menuList.add(new MenuModel("Starbox Cookie", "10min", "7", R.drawable.cookie));
                break;
            case "Tom Houston":
                restaurantImg.setImageResource(R.drawable.coffee_logo2);
                menuList.add(new MenuModel("Americano", "7min", "7", R.drawable.americano));
                menuList.add(new MenuModel("Caffe Latte", "10min", "10", R.drawable.caffe_latte));
                menuList.add(new MenuModel("Black Coffee", "9min", "8", R.drawable.black_coffee));
                break;
            case "Sweet Hub":
                restaurantImg.setImageResource(R.drawable.dessert_logo1);
                menuList.add(new MenuModel("Muffin All Stars", "15min", "15", R.drawable.desserts1));
                menuList.add(new MenuModel("Blueberry Muffin", "10min", "6", R.drawable.blueberry));
                menuList.add(new MenuModel("Strawberry Muffin", "10min", "6", R.drawable.strawberry));
                break;
            case "Kam Cake":
                restaurantImg.setImageResource(R.drawable.dessert_logo2);
                menuList.add(new MenuModel("Kam Cake Set", "15min", "25", R.drawable.desserts2));
                menuList.add(new MenuModel("Chocolate Cake", "10min", "6", R.drawable.choco_cake));
                menuList.add(new MenuModel("Tiramisu", "10min", "6", R.drawable.tiramisu));
                break;
            case "Horny Honey":
                restaurantImg.setImageResource(R.drawable.dessert_logo3);
                menuList.add(new MenuModel("Gold Pudding", "13min", "10", R.drawable.desserts3));
                menuList.add(new MenuModel("Berries Pudding", "10min", "12", R.drawable.berry_pudding));
                menuList.add(new MenuModel("Banana Mousse", "12min", "12", R.drawable.banana_mousse));
                break;
        }
        return menuList;    // return the updated menu list array
    }
}