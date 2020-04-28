package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root
public class GoodReadsResponse implements Serializable {
  @SerializedName("Request")
  @Element(name = "Request", required = false)
  private Request request = null;

  @SerializedName("search")
  @Element(name = "search", required = false)
  private Search search = null;

  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public Search getSearch() {
    return search;
  }

  public void setSearch(Search search) {
    this.search = search;
  }
}
