package com.example.hbr;

import android.content.Context;

import com.example.hbr.presenter.BookDetailPresenter;
import com.example.hbr.presenter.BookListPresenter;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HbrModule {
    private Context context;

    public HbrModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public BookListPresenter provideBookListPresenter(){
        return new BookListPresenter();

    }

    @Provides
    @Singleton
    public BookDetailPresenter provideBookDetailsPresenter(){
        return new BookDetailPresenter();
    }

    @Provides
    @Singleton
    public Webservice webservice(){
        throw new RuntimeException("Not implemented");
    }

    @Provides
    @Singleton
    public DatabaseRepository databaseRepository(){
        return new DatabaseRepository();
    }
}
