package com.example.platemate.models;

import java.io.Serializable;

// Represent a model for menu items for restaurants in the Home screen
public class MenuModel implements Serializable {
    // Define variables
    String menuName, menuTime, menuPrice;
    int menuImage;

    // constructor to create MenuModel objects
    public MenuModel(String menuName, String menuTime, String menuPrice, int menuImage) {
        this.menuName = menuName;
        this.menuTime = menuTime;
        this.menuPrice = menuPrice;
        this.menuImage = menuImage;
    }

    // Getter method to retrieve the menu item name
    public String getMenuName() {
        return menuName;
    }

    // Setter method to set the menu item name
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    // Getter method to retrieve the menu time
    public String getMenuTime() {
        return menuTime;
    }

    // Setter method to set the menu time
    public void setMenuTime(String menuTime) {
        this.menuTime = menuTime;
    }

    // Getter method to retrieve the menu item price
    public String getMenuPrice() {
        return menuPrice;
    }

    // Setter method to set the menu item price
    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    // Getter method to retrieve the menu image
    public int getMenuImage() {
        return menuImage;
    }

    // Setter method to set the menu image
    public void setMenuImage(int menuImage) {
        this.menuImage = menuImage;
    }
}
