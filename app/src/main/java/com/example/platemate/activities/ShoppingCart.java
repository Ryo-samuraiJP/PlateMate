package com.example.platemate.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.platemate.R;
import com.example.platemate.models.MenuModel;
import com.example.platemate.adapters.ShoppingCartAdapter;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {
    // Initialize variables
    RecyclerView recyclerView;
    ArrayList<MenuModel> shoppingCartList;
    TextView item_subtotal, delivery_fee, service_fee, tax, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // Get references
        recyclerView = findViewById(R.id.shopping_cart_rec);
        item_subtotal = findViewById(R.id.item_subtotal);
        delivery_fee = findViewById(R.id.delivery_fee);
        service_fee = findViewById(R.id.service_fee);
        tax = findViewById(R.id.tax);
        total = findViewById(R.id.total);

        // Retrieve shopping cart list from previous activity
        Intent intent = getIntent();
        shoppingCartList = (ArrayList<MenuModel>) intent.getSerializableExtra("shoppingCartList");
        if (shoppingCartList == null) {
            shoppingCartList = new ArrayList<>();
        }
        ShoppingCartAdapter adapter = new ShoppingCartAdapter(this, shoppingCartList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Call the calculatePrices method to calculate prices
        calculatePrices();
    }

    // create a calculatePrices method to calculate and display the item subtotal, delivery fee, etc.
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void calculatePrices() {
        double subtotal = 0.0;
        for (MenuModel menuModel : shoppingCartList) {
            subtotal += Double.parseDouble(menuModel.getMenuPrice());
        }
        item_subtotal.setText("Item Subtotal: $" + String.format("%.2f", subtotal));

        // delivery fee is always $3.00 till version1.2 when users can set their address
        double deliveryFee = 3.0;
        delivery_fee.setText("Delivery Fee: $" + deliveryFee);

        // service fee is $3.00, but will be $5.00 if subtotal is more than $50.00
        double serviceFee = subtotal <= 50 ? 3.0 : 5.0;
        service_fee.setText("Service Fee: $" + serviceFee);

        double TAX_RATE = 0.07;  // tax is 7.00%
        double taxAmount = subtotal * TAX_RATE;
        tax.setText("Tax: $" + String.format("%.2f", taxAmount));

        double totalPrice = subtotal + deliveryFee + serviceFee + taxAmount;
        total.setText("Total (CAD): $" + String.format("%.2f", totalPrice));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle back button click
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Create a notification and start OrderPlaced activity to confirm the order placement
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void placeOrder(View view) {
        // set up notification channel
        String channelId = "channel_id";
        String channelName = "Order Notification";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

        // Build notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Order Confirmation")
                .setContentText("Your order has been placed successfully")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        // send notification
        notificationManager.notify(1, builder.build());

        // start the OrderPlaced activity
        startActivity(new Intent(this, OrderPlaced.class));
        // Show success toast message
        Toast.makeText(this, "Your order has been placed successfully", Toast.LENGTH_SHORT).show();
    }
}
