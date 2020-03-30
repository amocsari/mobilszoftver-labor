package com.example.hbr.respository.web;

import com.example.hbr.model.ApiModels.GoodreadsApiResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Webservice {
    static Webservice build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.goodreads.com/search/")
                .build();
        return retrofit.create(Webservice.class);
    }

    @GET("search/index.xml")
    Call<GoodreadsApiResult> findBookByTitle(@Query("q") String title, @Query("search[field]") String searchField, @Query("key") String apiKey);
}
