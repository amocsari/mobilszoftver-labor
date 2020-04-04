package com.example.hbr.presenter;

public abstract class PresenterBase<T> {
    T view;

    public void attachScreen(T view){
        this.view = view;
    }

    public void detachScreen(){
        this.view = null;
    }
}
