package com.example.hbr.respository.web;

import com.example.hbr.model.apimodels.GoodReadsResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public interface Webservice {
    static Webservice build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.goodreads.com")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return retrofit.create(Webservice.class);
    }

    @GET("search/index.xml")
    Call<GoodReadsResponse> findBookByTitle(@Query("q") String title, @Query("search[field]") String searchField, @Query("key") String apiKey);
}
