package com.example.hbr.respository.web;

import com.example.hbr.respository.web.client.ApiException;
import com.example.hbr.respository.web.client.api.DefaultApi;
import com.example.hbr.respository.web.client.model.GoodReadsResponse;

public class Webservice {
    GoodReadsResponse findBookByTitle(String title){
        DefaultApi api = new DefaultApi();
        try {
            return api.queryBooks("Kn9jyCFyPgYJUgV4B1bsw", title, 1, "title");
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
