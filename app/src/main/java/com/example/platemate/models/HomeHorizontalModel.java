package com.example.platemate.models;

// Represent a model for horizontal card views in the Home screen
public class HomeHorizontalModel {
    // Define image and name of the item
    int image;
    String name;

    // Create a new instance of HomeHorizontalModel with the provided image and name
    public HomeHorizontalModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    // Getter method to retrieve the image of item
    public int getImage() {
        return image;
    }

    // Set the image of the item
    public void setImage(int image) {
        this.image = image;
    }

    // Getter method to retrieve the name of item
    public String getName() {
        return name;
    }

    // Set the name of the item
    public void setName(String name) {
        this.name = name;
    }
}
