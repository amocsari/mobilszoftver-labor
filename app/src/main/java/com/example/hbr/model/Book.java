package com.example.hbr.model;

import com.example.hbr.model.ApiModels.GoodreadsApiResult;

import java.util.Date;

public class Book {
    private int goodReadsId;
    private String title;
    private String Author;
    private double averageRating;
    private int ratingsCount;
    private Date publication;
    private String imageUrl;
    private String smallImageUrl;

    public Book(GoodreadsApiResult apiResult){
    }

    public int getGoodReadsId() {
        return goodReadsId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public Date getPublication() {
        return publication;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }
}
