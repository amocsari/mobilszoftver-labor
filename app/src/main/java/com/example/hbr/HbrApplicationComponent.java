package com.example.hbr;

import com.example.hbr.presenter.BookDetailPresenter;
import com.example.hbr.presenter.*;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.view.*;
import com.example.hbr.view.BookListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { HbrModule.class })
public interface HbrApplicationComponent {
    void inject(BookListActivity bookListActivity);
    void inject(BookListPresenter bookListPresenter);
    void inject(BookDetailActivity bookDetailActivity);
    void inject(BookDetailPresenter bookDetailPresenter);
    void inject(DatabaseRepository databaseRepository);
}
