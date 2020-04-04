package com.example.hbr.adapter;

import android.view.ViewGroup;

import com.example.hbr.model.Book;
import com.example.hbr.model.BookViewHolder;
import com.example.hbr.presenter.BookListPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookListAdapter extends RecyclerView.Adapter<BookViewHolder> {
    BookListPresenter bookListPresenter;
    List<Book> bookList = new ArrayList<>();

    public BookListAdapter(BookListPresenter bookListPresenter){
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getItemCount() {
        throw new RuntimeException("Not implemented");
    }

    public void clear(){
        throw new RuntimeException("Not implemented");
    }

    public void addBooks(List<Book> books){
        throw new RuntimeException("Not implemented");
    }

    public boolean contains(Book book){
        throw new RuntimeException("Not implemented");
    }
}
