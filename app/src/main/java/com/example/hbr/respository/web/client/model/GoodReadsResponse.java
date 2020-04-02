/*
 * Swagger GoodReadsApi
 * This is a sample server Petstore server. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.example.hbr.respository.web.client.model;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * GoodReadsResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-04-02T19:01:15.591+02:00[Europe/Prague]")
@Root
public class GoodReadsResponse implements Serializable {
  @SerializedName("Request")
  @Element(name = "Request", required = false)
  private Request request = null;

  @SerializedName("search")
  @Element(name = "search", required = false)
  private Search search = null;

  public GoodReadsResponse request(Request request) {
    this.request = request;
    return this;
  }

   /**
   * Get request
   * @return request
  **/
  @Schema(description = "")
  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public GoodReadsResponse search(Search search) {
    this.search = search;
    return this;
  }

   /**
   * Get search
   * @return search
  **/
  @Schema(description = "")
  public Search getSearch() {
    return search;
  }

  public void setSearch(Search search) {
    this.search = search;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoodReadsResponse goodReadsResponse = (GoodReadsResponse) o;
    return Objects.equals(this.request, goodReadsResponse.request) &&
        Objects.equals(this.search, goodReadsResponse.search);
  }

  @Override
  public int hashCode() {
    return Objects.hash(request, search);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodReadsResponse {\n");

    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    search: ").append(toIndentedString(search)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
