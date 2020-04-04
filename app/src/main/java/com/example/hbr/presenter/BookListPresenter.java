package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;
import com.example.hbr.adapter.BookListAdapter;
import com.example.hbr.model.Book;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;
import com.example.hbr.view.IBookListView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class BookListPresenter extends PresenterBase<IBookListView> {
    @Inject
    Webservice webservice;

    @Inject
    DatabaseRepository databaseRepository;

    private BookListAdapter remoteListAdapter = new BookListAdapter(this);
    private BookListAdapter localListAdapter = new BookListAdapter(this);

    @Override
    public void attachScreen(IBookListView view){
        super.attachScreen(view);
        HbrApplication.injector.inject(this);
        loadBookList();
    }

    private void loadBookList() {
        remoteListAdapter.clear();
        localListAdapter.clear();
        List<Book> bookList = databaseRepository.getAllBooks();
        if(bookList == null)
            bookList = new ArrayList<>();
        localListAdapter.addBooks(bookList);
        view.updateListVisibility();
    }

    public void findBookByTitle(String title){
        remoteListAdapter.clear();
        List<Book> bookList = webservice.findBookByTitle(title);
        remoteListAdapter.addBooks(bookList);

        List<Book> newBooks = bookList.stream().filter(b -> !localListAdapter.contains(b)).collect(Collectors.toList());
        persistBooks(newBooks);
        localListAdapter.addBooks(newBooks);

        view.clearEditText();
        view.updateListVisibility();
    }

    private void persistBooks(List<Book> books){
        databaseRepository.insertBooks(books);
    }

    public void showBookDetailsById(Long bookId){
        view.goToDetails(bookId);
    }

    public BookListAdapter getRemoteListAdapter() {
        return remoteListAdapter;
    }

    public BookListAdapter getLocalListAdapter() {
        return localListAdapter;
    }

    public boolean isLocalListEmpty(){
        return localListAdapter.getItemCount() == 0;
    }

    public boolean isRemoteListEmpty(){
        return remoteListAdapter.getItemCount() == 0;
    }
}
