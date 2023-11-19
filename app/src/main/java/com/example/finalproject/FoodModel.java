package com.example.finalproject;

import java.io.Serializable;

public class FoodModel implements Serializable {
    public String name;
    public String price;
    public String rating;
    public Integer imageResourceId;

    public FoodModel(String name, String price, String rating, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImage(Integer image) {
        this.imageResourceId = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
