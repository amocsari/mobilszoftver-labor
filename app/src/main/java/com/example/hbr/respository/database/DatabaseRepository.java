package com.example.hbr.respository.database;

import android.content.Context;
import android.os.AsyncTask;

import com.example.hbr.HbrApplication;
import com.example.hbr.model.Book;

import java.util.List;

import javax.inject.Inject;

import androidx.room.Room;

public class DatabaseRepository {

    @Inject
    Context context;

    private BookDatabase bookDatabase;

    public DatabaseRepository(){
        HbrApplication.injector.inject(this);
        bookDatabase = Room.databaseBuilder(context, BookDatabase.class, "db_book").build();
    }

    public void insertBook(final Book book){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                bookDatabase.daoAccess().insertBook(book);
                return null;
            }
        }.execute();
    }

    public List<Book> getAllBooks(){
        return bookDatabase.daoAccess().getAllBooks();
    }

    public Book getBookById(int bookId){
        return bookDatabase.daoAccess().getBookById(bookId);
    }

    public void DeleteBook(final Book book){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                bookDatabase.daoAccess().deleteBook(book);
                return null;
            }
        }.execute();
    }

    public void DeleteBookById(final int bookId){
        final Book book = getBookById(bookId);
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                bookDatabase.daoAccess().deleteBook(book);
                return null;
            }
        }.execute();
    }
}
