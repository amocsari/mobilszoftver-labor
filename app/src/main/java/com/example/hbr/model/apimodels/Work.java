package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

import java.io.Serializable;
import java.math.BigDecimal;

public class Work implements Serializable {
  @SerializedName("id")
  @Element(name = "id", required = false)
  private Long id = null;

  @SerializedName("books_count")
  @Element(name = "books_count", required = false)
  private Long booksCount = null;

  @SerializedName("ratings_count")
  @Element(name = "ratings_count", required = false)
  private Long ratingsCount = null;

  @SerializedName("text_reviews_count")
  @Element(name = "text_reviews_count", required = false)
  private Long textReviewsCount = null;

  @SerializedName("original_publication_year")
  @Element(name = "original_publication_year", required = false)
  private Long originalPublicationYear = null;

  @SerializedName("original_publication_month")
  @Element(name = "original_publication_month", required = false)
  private Long originalPublicationMonth = null;

  @SerializedName("original_publication_day")
  @Element(name = "original_publication_day", required = false)
  private Long originalPublicationDay = null;

  @SerializedName("average_rating")
  @Element(name = "average_rating", required = false)
  private BigDecimal averageRating = null;

  @SerializedName("best_book")
  @Element(name = "best_book", required = false)
  private Book bestBook = null;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getBooksCount() {
    return booksCount;
  }

  public void setBooksCount(Long booksCount) {
    this.booksCount = booksCount;
  }

  public Long getRatingsCount() {
    return ratingsCount;
  }

  public void setRatingsCount(Long ratingsCount) {
    this.ratingsCount = ratingsCount;
  }

  public Long getTextReviewsCount() {
    return textReviewsCount;
  }

  public void setTextReviewsCount(Long textReviewsCount) {
    this.textReviewsCount = textReviewsCount;
  }

  public Long getOriginalPublicationYear() {
    return originalPublicationYear;
  }

  public void setOriginalPublicationYear(Long originalPublicationYear) {
    this.originalPublicationYear = originalPublicationYear;
  }

  public Long getOriginalPublicationMonth() {
    return originalPublicationMonth;
  }

  public void setOriginalPublicationMonth(Long originalPublicationMonth) {
    this.originalPublicationMonth = originalPublicationMonth;
  }

  public Long getOriginalPublicationDay() {
    return originalPublicationDay;
  }

  public void setOriginalPublicationDay(Long originalPublicationDay) {
    this.originalPublicationDay = originalPublicationDay;
  }

  public BigDecimal getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(BigDecimal averageRating) {
    this.averageRating = averageRating;
  }

  public Book getBestBook() {
    return bestBook;
  }

  public void setBestBook(Book bestBook) {
    this.bestBook = bestBook;
  }
}
