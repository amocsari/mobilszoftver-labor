package com.example.hbr;

import android.content.Context;

import com.example.hbr.mocks.MockFactory;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;

import javax.inject.Singleton;

import dagger.Provides;

public class TestModule extends HbrModule {

    TestModule(Context context) {
        super(context);
    }

    @Override
    @Provides
    @Singleton
    public Webservice webservice() {
        return MockFactory.mockWebservice;
    }

    @Override
    @Provides
    @Singleton
    public DatabaseRepository databaseRepository() {
        return MockFactory.mockDatabaseRepository;
    }
}
