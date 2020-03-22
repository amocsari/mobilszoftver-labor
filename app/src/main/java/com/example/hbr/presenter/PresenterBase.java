package com.example.hbr.presenter;

public abstract class PresenterBase<T> {
    T view;

    void registerView(T view){
        this.view = view;
    }

    void unregisterView(){
        this.view = null;
    }
}
