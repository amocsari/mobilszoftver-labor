package com.example.hbr;

public class TestApplication extends HbrApplication {

    @Override
    public void initComponent(){
        injector = DaggerHbrApplicationComponent.builder().hbrModule(new TestModule(this)).build();
    }
}
