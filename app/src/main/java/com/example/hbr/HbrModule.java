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
class HbrModule {
    private Context context;

    HbrModule(Context context){
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    BookListPresenter provideBookListPresenter(){
        return new BookListPresenter();

    }

    @Provides
    @Singleton
    BookDetailPresenter provideBookDetailsPresenter(){
        return new BookDetailPresenter();
    }

    @Provides
    @Singleton
    Webservice webservice(){
        return Webservice.build();
    }

    @Provides
    @Singleton
    DatabaseRepository databaseRepository(){
        return new DatabaseRepository();
    }
}
