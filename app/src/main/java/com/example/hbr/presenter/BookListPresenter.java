package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;
import com.example.hbr.adapter.BookListAdapter;
import com.example.hbr.adapter.*;
import com.example.hbr.model.Book;
import com.example.hbr.model.apimodels.GoodReadsResponse;
import com.example.hbr.model.apimodels.Results;
import com.example.hbr.model.apimodels.Search;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;
import com.example.hbr.view.IBookListView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookListPresenter extends PresenterBase<IBookListView> implements Callback<GoodReadsResponse> {
    @Inject
    Webservice webservice;

    @Inject
    DatabaseRepository databaseRepository;

    private BookListAdapter remoteListAdapter = new BookListAdapter(this);
    private BookListAdapter localListAdapter = new BookListAdapter(this);

    @Override
    public void attachScreen(IBookListView view) {
        super.attachScreen(view);
        HbrApplication.injector.inject(this);
    }

    private void loadBookList() {
        remoteListAdapter.clear();
        localListAdapter.clear();
        List<Book> bookList = databaseRepository.getAllBooks();
        if(bookList == null)
            bookList = new ArrayList<>();
        localListAdapter.addBooks(bookList);
        view.updateListVisibility();
    }

    public void findBookByTitle(String title) {
        webservice.findBookByTitle(title, "title", "Kn9jyCFyPgYJUgV4B1bsw").enqueue(this);
    }

    private void persistBooks(List<Book> books) {
        List<Long> oldBookIds = databaseRepository.getAllBooks().stream().mapToLong(Book::getGoodReadsId).boxed().collect(Collectors.toList());
        List<Book> newBooks = books.stream().filter(b -> !oldBookIds.contains(b.getGoodReadsId())).collect(Collectors.toList());

        databaseRepository.insertBooks(newBooks);
        remoteListAdapter.addBooks(books);
        localListAdapter.addBooks(newBooks);
    }

    public void showBookDetailsById(Long bookId) {
        view.goToDetails(bookId);
    }

    public BookListAdapter getRemoteListAdapter() {
        return remoteListAdapter;
    }

    public BookListAdapter getLocalListAdapter() {
        return localListAdapter;
    }

    public boolean isLocalListEmpty(){
        return localListAdapter.getItemCount() == 0;
    }

    public boolean isRemoteListEmpty(){
        return remoteListAdapter.getItemCount() == 0;
    }

    @Override
    public void onResponse(Call<GoodReadsResponse> call, Response<GoodReadsResponse> response) {
        if (!response.isSuccessful()) {
            return;
        }

        GoodReadsResponse goodReadsResponse = response.body();

        if (goodReadsResponse == null)
            return;

        Search search = goodReadsResponse.getSearch();
        if (search == null)
            return;

        Results results = search.getResults();
        if (results == null || results.getWork() == null)
            return;

        List<Book> books = results.getWork().stream().map(Book::new).collect(Collectors.toList());

        persistBooks(books);
    }

    @Override
    public void onFailure(Call<GoodReadsResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
