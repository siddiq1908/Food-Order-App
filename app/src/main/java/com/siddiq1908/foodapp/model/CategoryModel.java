package com.siddiq1908.foodapp.model;

public class CategoryModel {
    Integer imageUrl;
    String name;

    public CategoryModel(Integer imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
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
}
