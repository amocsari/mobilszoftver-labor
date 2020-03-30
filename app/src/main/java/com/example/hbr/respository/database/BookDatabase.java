package com.example.hbr.respository.database;

import com.example.hbr.model.Book;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Book.class, version = 1, exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
