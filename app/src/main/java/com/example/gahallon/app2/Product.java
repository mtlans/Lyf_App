package com.example.gahallon.app2;

/**
 * Created by NgocTri on 10/22/2016.
 */

public class Product {
    private int imageId;
    private String title;
    private String description;
    private String description2;

    public Product(int imageId, String title, String description, String description2) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.description2 = description2;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }
}
