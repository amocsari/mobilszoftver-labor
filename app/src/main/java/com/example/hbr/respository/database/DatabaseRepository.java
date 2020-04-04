package com.example.hbr.respository.database;

import android.content.Context;
import android.os.AsyncTask;

import com.example.hbr.HbrApplication;
import com.example.hbr.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    public void insertBooks(final List<Book> books){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                for (Book book: books)
                    bookDatabase.daoAccess().insertBook(book);
                return null;
            }
        }.execute();
    }

    public List<Book> getAllBooks(){
        try {
            return new AsyncTask<Void, Void, List<Book>>() {
                @Override
                protected List<Book> doInBackground(Void... voids) {
                    return bookDatabase.daoAccess().getAllBooks();
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Book getBookById(Long bookId){
        try {
            return new AsyncTask<Void, Void, Book>() {
                @Override
                protected Book doInBackground(Void... voids) {
                    return bookDatabase.daoAccess().getBookById(bookId);
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
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

    public void DeleteBookById(final Long bookId){
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
