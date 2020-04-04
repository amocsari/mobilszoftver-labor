package com.example.hbr.view;

import com.example.hbr.model.Book;

public interface IBookDetailView {
    Long getBookId();
    void  goBack();
    void loadBookData(Book book);
    void showSnackBar(String message);
}
