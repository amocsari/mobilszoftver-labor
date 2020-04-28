package com.example.hbr.tests;

import com.example.hbr.TestApplication;
import com.example.hbr.mocks.MockFactory;
import com.example.hbr.model.Book;
import com.example.hbr.presenter.BookDetailPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class BookDetailsPresenterTest {

    private BookDetailPresenter bookDetailPresenterUnderTest;

    @Before
    public void startup(){
        MockFactory.generate();

        Book book = new Book();
        book.setGoodReadsId(1001L);
        book.setAverageRating(5.0);
        MockFactory.mockTable.add(book);

        bookDetailPresenterUnderTest = new BookDetailPresenter();
        bookDetailPresenterUnderTest.attachScreen(MockFactory.mockBookDetailActivity);
    }

    @Test
    public void deleteBook_Test(){
        //Arrange
        //Act
        bookDetailPresenterUnderTest.deleteBook();

        //Assert
        verify(MockFactory.mockDatabaseRepository, times(1)).DeleteBookById(anyLong());
        verify(MockFactory.mockBookDetailActivity, times(1)).goBack();
        Assert.assertEquals(0, MockFactory.mockTable.size());
    }

    @Test
    public void displayRatingValue_Test(){
        //Arrange
        //Act
        bookDetailPresenterUnderTest.displayRatingValue();

        //Assert
        verify(MockFactory.mockBookDetailActivity, times(1)).showSnackBar(anyString());
    }
}
