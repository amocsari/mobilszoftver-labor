package com.example.hbr.presenter;

import com.example.hbr.model.Book;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.view.IBookDetailView;

import javax.inject.Inject;

public class BookDetailPresenter extends PresenterBase<IBookDetailView> {

    Book book;

    @Inject
    DatabaseRepository databaseRepository;

    public Book getBook() {
        return book;
    }

    private Book findBookById(int bookId){
        throw new RuntimeException("Not implemented");
    }
}
