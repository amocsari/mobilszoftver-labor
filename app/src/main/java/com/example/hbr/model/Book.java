package com.example.hbr.model;

import com.example.hbr.respository.web.client.model.GoodReadsResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Entity
public class Book {
    public Book(){}

    @PrimaryKey
    private int goodReadsId;

    private String title;

    private String Author;

    private double averageRating;

    private int ratingsCount;

    @TypeConverters({TimestampConverter.class})
    private Date publication;

    private String imageUrl;

    private String smallImageUrl;

    public void setGoodReadsId(int goodReadsId) {
        this.goodReadsId = goodReadsId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Book(GoodReadsResponse apiResult){
        throw new RuntimeException("Not implemented");
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

    public static class TimestampConverter {

        private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @TypeConverter
        public static Date fromTimestamp(String value) {
            if (value != null) {
                try {
                    TimeZone timeZone = TimeZone.getTimeZone("IST");
                    df.setTimeZone(timeZone);
                    return df.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            } else {
                return null;
            }
        }


        @TypeConverter
        public static String dateToTimestamp(Date value) {
            TimeZone timeZone = TimeZone.getTimeZone("IST");
            df.setTimeZone(timeZone);
            return value == null ? null : df.format(value);
        }
    }
}
