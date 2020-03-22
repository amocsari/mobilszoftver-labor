package com.example.hbr;

import android.content.Context;

import com.example.hbr.presenter.BookDetailPresenter;
import com.example.hbr.presenter.BookListPresenter;

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
        throw new RuntimeException("Not implemented");
    }

    @Provides
    @Singleton
    public BookListPresenter provideBookListPresenter(){
        throw new RuntimeException("Not implemented");

    }

    @Provides
    @Singleton
    public BookDetailPresenter provideBookDetailsPresenter(){
        throw new RuntimeException("Not implemented");
    }
}
