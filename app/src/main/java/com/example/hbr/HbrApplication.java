package com.example.hbr;

import android.app.Application;

public class HbrApplication extends Application {

    public static HbrApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();
        initComponent();
    }

    public void initComponent(){
        injector = DaggerHbrApplicationComponent.builder().hbrModule(new HbrModule(this)).build();
    }
}
