package com.example.hbr.view;

import android.os.Bundle;

import com.example.hbr.HbrApplication;
import com.example.hbr.R;
import com.example.hbr.model.Book;
import com.example.hbr.presenter.BookDetailPresenter;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailActivity extends AppCompatActivity implements IBookDetailView {

    @Inject
    BookDetailPresenter bookDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        HbrApplication.injector.inject(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        bookDetailPresenter.attachScreen(this);
    }

    @Override
    public Long getBookId() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void goBack() {
        onBackPressed();
    }

    @Override
    public void loadBookData(Book book) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void showSnackBar(String message) {
        throw new RuntimeException("Not implemented");
    }
}
