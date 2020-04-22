package com.example.hbr.view;

import android.os.Bundle;

import com.example.hbr.HbrApplication;
import com.example.hbr.R;

import com.example.hbr.presenter.*;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class BookListActivity extends AppCompatActivity implements IBookListView {

    @Inject
    BookListPresenter bookListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        HbrApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bookListPresenter.attachScreen(this);
    }

    @Override
    protected void onStop(){
        super.onStop();
        bookListPresenter.detachScreen();
    }

    @Override
    public void updateListVisibility() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void clearEditText() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void goToDetails(Long bookId) {
        throw new RuntimeException("Not implemented");
    }
}
