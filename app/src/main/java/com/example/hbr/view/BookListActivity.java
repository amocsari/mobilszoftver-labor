package com.example.hbr.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hbr.R;
import com.example.hbr.presenter.BookListPresenter;

import javax.inject.Inject;

public class BookListActivity extends AppCompatActivity implements IBookListView {

    @Inject
    BookListPresenter bookListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
    }
}
