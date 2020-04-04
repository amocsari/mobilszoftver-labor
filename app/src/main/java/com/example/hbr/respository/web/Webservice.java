package com.example.hbr.respository.web;

import android.os.AsyncTask;

import com.example.hbr.model.Book;
import com.example.hbr.respository.web.client.ApiException;
import com.example.hbr.respository.web.client.api.DefaultApi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Webservice {
    public List<Book> findBookByTitle(String title) {
        try {
            return new AsyncTask<String, Integer, List<Book>>() {
                @Override
                protected List<Book> doInBackground(String... strings) {
                    String title = strings[0];
                    DefaultApi api = new DefaultApi();
                    try {
                        return api.queryBooks("Kn9jyCFyPgYJUgV4B1bsw", title, 1, "title").getSearch().getResults().getWork()
                                .stream().filter(w -> w.getBestBook() != null).map(Book::new).collect(Collectors.toList());
                    } catch (ApiException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return new ArrayList<>();
                }
            }.execute(title).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
