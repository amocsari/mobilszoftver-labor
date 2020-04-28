package com.example.hbr.respository.database;

import com.example.hbr.model.Book;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DaoAccess {
    @Insert
    void insertBook(Book book);

    @Query("SELECT * FROM Book")
    List<Book> getAllBooks();

    @Query("SELECT * FROM Book WHERE goodReadsId = :bookId")
    Book getBookById(Long bookId);

    @Delete
    void deleteBook(Book book);
}