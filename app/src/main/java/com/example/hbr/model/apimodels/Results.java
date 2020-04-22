package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.ElementList;

import java.io.Serializable;
import java.util.List;

public class Results implements Serializable {
  @SerializedName("work")
  @ElementList(name = "work", inline = true, required = false)
  private List<Work> work = null;

  public List<Work> getWork() {
    return work;
  }

  public void setWork(List<Work> work) {
    this.work = work;
  }
}
