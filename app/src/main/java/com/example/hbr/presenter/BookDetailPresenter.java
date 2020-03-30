package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;
import com.example.hbr.model.Book;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.view.IBookDetailView;
import com.example.hbr.view.IBookListView;

import javax.inject.Inject;

public class BookDetailPresenter extends PresenterBase<IBookDetailView> {

    Book book;

    @Inject
    DatabaseRepository databaseRepository;

    @Override
    public void attachScreen(IBookDetailView view){
        super.attachScreen(view);
        HbrApplication.injector.inject(this);
    }

    public Book getBook() {
        return book;
    }

    private Book findBookById(int bookId){
        throw new RuntimeException("Not implemented");
    }
}
