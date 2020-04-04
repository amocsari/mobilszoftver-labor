package com.example.hbr.model;

import com.example.hbr.respository.web.client.model.GoodReadsResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    public Book(){}

    @PrimaryKey
    private Long goodReadsId;

    private String title;

    private String author;

    private double averageRating;

    private Long ratingsCount;

    private String publication;

    private String imageUrl;

    private String smallImageUrl;

    public Long getGoodReadsId() {
        return goodReadsId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Long getRatingsCount() {
        return ratingsCount;
    }

    public String getPublication() {
        return publication;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setGoodReadsId(Long goodReadsId) {
        this.goodReadsId = goodReadsId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setRatingsCount(Long ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }
}
