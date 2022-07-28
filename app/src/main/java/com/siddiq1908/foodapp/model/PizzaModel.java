package com.siddiq1908.foodapp.model;

public class PizzaModel {
    Integer imageUrl;
    String name;
    String rating;
    String price;
    String itemRating;

    public PizzaModel(Integer imageUrl, String name, String rating, String price, String itemRating) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.itemRating = itemRating;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItemRating() {
        return itemRating;
    }

    public void setItemRating(String itemRating) {
        this.itemRating = itemRating;
    }
}
