package com.siddiq1908.foodapp.model;

public class SeeMoreNearbyModel {

    String name;
    Integer imageUrl;
    String time;

    public SeeMoreNearbyModel(String name, Integer imageUrl, String time) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
