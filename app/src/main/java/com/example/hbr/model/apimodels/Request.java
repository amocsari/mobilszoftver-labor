package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

import java.io.Serializable;

public class Request implements Serializable {
  @SerializedName("authentication")
  @Element(name = "authentication", required = false)
  private Boolean authentication = null;

  @SerializedName("key")
  @Element(name = "key", required = false)
  private String key = null;

  @SerializedName("method")
  @Element(name = "method", required = false)
  private String method = null;

  public Boolean getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Boolean authentication) {
    this.authentication = authentication;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }
}
