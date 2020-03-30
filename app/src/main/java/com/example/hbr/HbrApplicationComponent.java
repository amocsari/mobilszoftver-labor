package com.example.hbr;

import com.example.hbr.presenter.BookListPresenter;
import com.example.hbr.view.BookListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { HbrModule.class })
public interface HbrApplicationComponent {
    void inject(BookListActivity bookListActivity);
    void inject(BookListPresenter bookListPresenter);
}
