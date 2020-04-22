package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

import java.io.Serializable;

public class Author implements Serializable {
  @SerializedName("id")
  @Element(name = "id", required = false)
  private Long id = null;

  @SerializedName("name")
  @Element(name = "name", required = false)
  private String name = null;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
