package com.example.hbr.model.ApiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoodreadsApiResult {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("books_count")
    @Expose
    private int booksCount;

    @SerializedName("ratings_count")
    @Expose
    private  int ratingsCount;

    @SerializedName("text_reviews_count")
    @Expose
    private int textReviewsCount;

    @SerializedName("original_publication_year")
    @Expose
    private int originalPublicationYear;

    @SerializedName("original_publication_month")
    @Expose
    private int originalPublicationMonth;

    @SerializedName("original_publication_day")
    @Expose
    private int originalPublicationDay;

    @SerializedName("average_rating")
    @Expose
    private double averageRating;

    @SerializedName("best_book")
    @Expose
    private BestBook bestBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public int getTextReviewsCount() {
        return textReviewsCount;
    }

    public void setTextReviewsCount(int textReviewsCount) {
        this.textReviewsCount = textReviewsCount;
    }

    public int getOriginalPublicationYear() {
        return originalPublicationYear;
    }

    public void setOriginalPublicationYear(int originalPublicationYear) {
        this.originalPublicationYear = originalPublicationYear;
    }

    public int getOriginalPublicationMonth() {
        return originalPublicationMonth;
    }

    public void setOriginalPublicationMonth(int originalPublicationMonth) {
        this.originalPublicationMonth = originalPublicationMonth;
    }

    public int getOriginalPublicationDay() {
        return originalPublicationDay;
    }

    public void setOriginalPublicationDay(int originalPublicationDay) {
        this.originalPublicationDay = originalPublicationDay;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public BestBook getBestBook() {
        return bestBook;
    }

    public void setBestBook(BestBook bestBook) {
        this.bestBook = bestBook;
    }
}
