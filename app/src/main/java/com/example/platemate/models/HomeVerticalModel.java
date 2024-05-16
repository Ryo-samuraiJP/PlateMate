package com.example.platemate.models;

import java.io.Serializable;

// Represent a model for vertical card views in the Home screen
public class HomeVerticalModel implements Serializable {
    // Define image, restaurant name, rate, rating bar, business hour, and menu price
    int image;
    String restaurant_name, rate, ratingbar, business_hour, price;

    // Create a new instance of HomeVerticalModel with the provided image, restaurant name, rate, rating bar, business hour, and menu price
    public HomeVerticalModel(int image, String restaurant_name, String rate, String ratingbar, String business_hour, String price) {
        this.image = image;
        this.restaurant_name = restaurant_name;
        this.rate = rate;
        this.ratingbar = ratingbar;
        this.business_hour = business_hour;
        this.price = price;
    }

    // Getter method to retrieve the image of item
    public int getImage() {
        return image;
    }

    // Set the image of the item
    public void setImage(int image) {
        this.image = image;
    }

    // Getter method to retrieve the restaurant image
    public String getRestaurant_name() {
        return restaurant_name;
    }

    // Set the restaurant name of the item
    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    // Getter method to retrieve the rate of the item
    public String getRate() {
        return rate;
    }

    // Set the rate of the item
    public void setRate(String rate) {
        this.rate = rate;
    }

    // Getter method to retrieve the rating bar of the item
    public String getRatingbar() {
        return ratingbar;
    }

    // Set the rating bar of the item
    public void setRatingbar(String ratingbar) {
        this.ratingbar = ratingbar;
    }

    // Getter method to retrieve the business hour of the item
    public String getBusiness_hour() {
        return business_hour;
    }

    // Set the business hour of the item
    public void setBusiness_hour(String business_hour) {
        this.business_hour = business_hour;
    }

    // Getter method to retrieve the price of the item
    public String getPrice() {
        return price;
    }

    // Set the menu price of the item
    public void setPrice(String price) {
        this.price = price;
    }
}
