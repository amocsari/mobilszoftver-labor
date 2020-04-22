package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.io.Serializable;

public class Book implements Serializable {
  @SerializedName("id")
  @Element(name = "id", required = false)
  private Long id = null;

  @SerializedName("title")
  @Element(name = "title", required = false)
  private String title = null;

  @SerializedName("author")
  @Element(name = "author", required = false)
  private Author author = null;

  @SerializedName("image_url")
  @Element(name = "image_url", required = false)
  private String imageUrl = null;

  @SerializedName("small_image_url")
  @Element(name = "small_image_url", required = false)
  private String smallImageUrl = null;

  @Attribute
  private String type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getSmallImageUrl() {
    return smallImageUrl;
  }

  public void setSmallImageUrl(String smallImageUrl) {
    this.smallImageUrl = smallImageUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
