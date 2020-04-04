package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;
import com.example.hbr.model.Book;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.view.IBookDetailView;

import javax.inject.Inject;

public class BookDetailPresenter extends PresenterBase<IBookDetailView> {

    Book book;

    @Inject
    DatabaseRepository databaseRepository;

    @Override
    public void attachScreen(IBookDetailView view){
        super.attachScreen(view);
        HbrApplication.injector.inject(this);
        Long bookId = view.getBookId();
        findBookById(bookId);
        view.loadBookData(book);
    }

    public void deleteBook(){
        databaseRepository.DeleteBookById(book.getGoodReadsId());
        view.goBack();
    }

    public void displayRatingValue(){
        if(book.getAverageRating() != null)
            view.showSnackBar(book.getAverageRating().toString());
    }

    private void findBookById(Long bookId){
        book = databaseRepository.getBookById(bookId);
        if(book == null)
            view.goBack();
    }
}
