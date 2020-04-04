package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;
import com.example.hbr.adapter.BookListAdapter;
import com.example.hbr.model.Book;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;
import com.example.hbr.view.IBookListView;

import java.util.List;

import javax.inject.Inject;

public class BookListPresenter extends PresenterBase<IBookListView> {
    @Inject
    Webservice webservice;

    @Inject
    DatabaseRepository databaseRepository;

    private BookListAdapter remoteListAdapter = new BookListAdapter(this);
    private BookListAdapter localListAdapter = new BookListAdapter(this);

    @Override
    public void attachScreen(IBookListView view){
        super.attachScreen(view);
        HbrApplication.injector.inject(this);
    }

    private void loadBookList() {
        throw new RuntimeException("Not implemented");
    }

    public void findBookByTitle(String title){
        throw new RuntimeException("Not implemented");
    }

    private void persistBooks(List<Book> books){
        throw new RuntimeException("Not implemented");
    }

    public void showBookDetailsById(Long bookId){
        throw new RuntimeException("Not implemented");
    }

    public BookListAdapter getRemoteListAdapter() {
        return remoteListAdapter;
    }

    public BookListAdapter getLocalListAdapter() {
        return localListAdapter;
    }

    public boolean isLocalListEmpty(){
        throw new RuntimeException("Not implemented");
    }

    public boolean isRemoteListEmpty(){
        throw new RuntimeException("Not implemented");
    }
}
