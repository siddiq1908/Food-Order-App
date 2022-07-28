package com.siddiq1908.foodapp.model;

public class RecommendedModel {
    String name;
    String rating;
    String time;
    String price;
    Integer imageUrl;
    String itemrating;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RecommendedModel(String name, String rating, String time, String price, Integer imageUrl, String itemrating) {
        this.name = name;
        this.rating = rating;
        this.time = time;
        this.price = price;
        this.imageUrl = imageUrl;
        this.itemrating = itemrating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemrating(){return itemrating;}

    public void setItemrating(String itemrating) {
        this.itemrating = itemrating;
    }
}
