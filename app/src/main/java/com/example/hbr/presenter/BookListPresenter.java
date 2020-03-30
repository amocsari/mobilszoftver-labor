package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;
import com.example.hbr.model.Book;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;
import com.example.hbr.view.IBookListView;

import java.util.List;

import javax.inject.Inject;

public class BookListPresenter extends PresenterBase<IBookListView> {

    List<Book> bookList;

    @Inject
    Webservice webservice;

    @Inject
    DatabaseRepository databaseRepository;

    @Override
    public void attachScreen(IBookListView view){
        super.attachScreen(view);
        HbrApplication.injector.inject(this);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    private Book findBookByTitle(String title){
        throw new RuntimeException("Not implemented");
    }

    private Book persistBook(Book book){
        throw new RuntimeException("Not implemented");
    }

    private void showBookDetailsById(int bookId){
        throw new RuntimeException("Not implemented");
    }
}
