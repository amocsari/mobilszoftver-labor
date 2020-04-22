package com.example.hbr.presenter;

public abstract class PresenterBase<T> {
    private T view;

    public void attachScreen(T view){
        this.view = view;
    }

    public void detachScreen(){
        this.view = null;
    }
}
