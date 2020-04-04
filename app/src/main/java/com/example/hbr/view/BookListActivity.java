package com.example.hbr.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hbr.HbrApplication;
import com.example.hbr.R;
import com.example.hbr.presenter.BookListPresenter;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookListActivity extends AppCompatActivity implements IBookListView {

    @Inject
    BookListPresenter bookListPresenter;

    RecyclerView rwRemote;
    RecyclerView rwLocal;
    TextInputEditText etTitle;
    Button btnSearch;
    TextView tvRemoteEmpty;
    TextView tvLocalEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        HbrApplication.injector.inject(this);

        rwRemote = findViewById(R.id.rwRemote);
        rwLocal = findViewById(R.id.rwLocal);
        etTitle = findViewById(R.id.etTitle);
        btnSearch = findViewById(R.id.btnSearch);
        tvRemoteEmpty = findViewById(R.id.tvRemoteEmpty);
        tvLocalEmpty = findViewById(R.id.tvLocalEmpty);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bookListPresenter.attachScreen(this);

        rwRemote.setAdapter(bookListPresenter.getRemoteListAdapter());
        rwRemote.setLayoutManager(new LinearLayoutManager(this));

        rwLocal.setAdapter(bookListPresenter.getLocalListAdapter());
        rwLocal.setLayoutManager(new LinearLayoutManager(this));

        btnSearch.setOnClickListener(view -> {
            String title = etTitle.getText().toString();
            bookListPresenter.findBookByTitle(title);
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        bookListPresenter.detachScreen();
    }

    @Override
    public void updateListVisibility() {
        if(bookListPresenter.isLocalListEmpty()){
            tvLocalEmpty.setVisibility(View.VISIBLE);
            rwLocal.setVisibility(View.GONE);
        }
        else {
            tvLocalEmpty.setVisibility(View.GONE);
            rwLocal.setVisibility(View.VISIBLE);
        }

        if(bookListPresenter.isRemoteListEmpty()){
            tvRemoteEmpty.setVisibility(View.VISIBLE);
            rwRemote.setVisibility(View.GONE);
        }
        else {
            tvRemoteEmpty.setVisibility(View.GONE);
            rwRemote.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void clearEditText() {
        etTitle.getText().clear();
    }

    @Override
    public void goToDetails(Long bookId) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra("bookId", bookId);
        this.startActivity(intent);
    }
}
