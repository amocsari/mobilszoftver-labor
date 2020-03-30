package com.example.hbr.presenter;

import com.example.hbr.HbrApplication;

public abstract class PresenterBase<T> {
    T view;

    public void attachScreen(T view){
        this.view = view;
    }

    public void detachScreen(){
        this.view = null;
    }
}
