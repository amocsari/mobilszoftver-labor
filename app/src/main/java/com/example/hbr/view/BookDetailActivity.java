package com.example.hbr.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hbr.R;

public class BookDetailActivity extends AppCompatActivity implements IBookDetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
    }
}
