package com.example.hbr.tests;

import android.os.Build;

import com.example.hbr.TestApplication;
import com.example.hbr.presenter.BookListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class BookListPresenterTest {

    BookListPresenter bookListPresenterUnderTest = new BookListPresenter();

    @Before
    public void startup(){
        TestApplication.injector.inject(bookListPresenterUnderTest);
    }

    @Test
    public void findBookByTitle(){
        bookListPresenterUnderTest.findBookByTitle("Title");
    }
}
