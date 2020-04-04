package com.example.hbr.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hbr.R;
import com.example.hbr.model.Book;
import com.example.hbr.model.BookViewHolder;
import com.example.hbr.presenter.BookListPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookListAdapter extends RecyclerView.Adapter<BookViewHolder> {
    BookListPresenter bookListPresenter;

    public BookListAdapter(BookListPresenter bookListPresenter){
        this.bookListPresenter = bookListPresenter;
    }

    List<Book> bookList = new ArrayList<>();

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);

        holder.setAuthor(book.getAuthor());
        holder.setTitle(book.getTitle());
        holder.setCover(book.getImageUrl());
        holder.itemView.setOnClickListener(view -> {
            bookListPresenter.showBookDetailsById(book.getGoodReadsId());
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void clear(){
        bookList.clear();
        notifyDataSetChanged();
    }

    public void addBooks(List<Book> books){
        bookList.addAll(books);
        bookList.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        notifyDataSetChanged();
    }

    public boolean contains(Book book){
        return bookList.stream().anyMatch(b -> b.getGoodReadsId().equals(book.getGoodReadsId()));
    }
}
