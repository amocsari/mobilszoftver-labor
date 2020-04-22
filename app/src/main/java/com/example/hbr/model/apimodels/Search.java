package com.example.hbr.model.apimodels;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;

import java.io.Serializable;
import java.math.BigDecimal;

public class Search implements Serializable {
  @SerializedName("query")
  @Element(name = "query", required = false)
  private String query = null;

  @SerializedName("results-start")
  @Element(name = "results-start", required = false)
  private Long resultsStart = null;

  @SerializedName("results-end")
  @Element(name = "results-end", required = false)
  private Long resultsEnd = null;

  @SerializedName("total-results")
  @Element(name = "total-results", required = false)
  private Long totalResults = null;

  @SerializedName("source")
  @Element(name = "source", required = false)
  private String source = null;

  @SerializedName("query-time-seconds")
  @Element(name = "query-time-seconds", required = false)
  private BigDecimal queryTimeSeconds = null;

  @SerializedName("results")
  @Element(name = "results", required = false)
  private Results results = null;

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Long getResultsStart() {
    return resultsStart;
  }

  public void setResultsStart(Long resultsStart) {
    this.resultsStart = resultsStart;
  }

  public Long getResultsEnd() {
    return resultsEnd;
  }

  public void setResultsEnd(Long resultsEnd) {
    this.resultsEnd = resultsEnd;
  }

  public Long getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Long totalResults) {
    this.totalResults = totalResults;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public BigDecimal getQueryTimeSeconds() {
    return queryTimeSeconds;
  }

  public void setQueryTimeSeconds(BigDecimal queryTimeSeconds) {
    this.queryTimeSeconds = queryTimeSeconds;
  }

  public Results getResults() {
    return results;
  }

  public void setResults(Results results) {
    this.results = results;
  }
}
