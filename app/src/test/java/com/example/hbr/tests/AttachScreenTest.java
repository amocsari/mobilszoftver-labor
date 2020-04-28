package com.example.hbr.tests;

import com.example.hbr.TestApplication;
import com.example.hbr.mocks.MockFactory;
import com.example.hbr.model.Book;
import com.example.hbr.observable.ObservableBookListPresenter;
import com.example.hbr.presenter.BookDetailPresenter;
import com.example.hbr.view.IBookDetailView;
import com.example.hbr.view.IBookListView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class AttachScreenTest {

    @Before
    public void startup(){
        MockFactory.generate();
    }

    @Test
    public void bookListPresenterAttachScreenTest() {
        //Arrange
        ObservableBookListPresenter bookListPresenterUnderTest = new ObservableBookListPresenter();
        IBookListView expectedview = MockFactory.mockBookListActivity;

        //Act
        bookListPresenterUnderTest.attachScreen(expectedview);

        //Assert
        Assert.assertEquals(expectedview, MockFactory.mockBookListActivity);

        verify(MockFactory.mockBookListActivity, times(1)).clearEditText();
        verify(MockFactory.mockBookListActivity, times(1)).updateListVisibility();

        verify(MockFactory.mockDatabaseRepository, times(1)).getAllBooks();

        verify(MockFactory.mockLocalBookListAdapter, times(1)).clear();
        verify(MockFactory.mockLocalBookListAdapter, times(1)).addBooks(anyList());

        verify(MockFactory.mockRemoteBookListAdapter, times(1)).clear();
    }

    @Test
    public void bookListPresenterAttachScreenTest_getAllBooks_Null(){
        //Arrange
        when(MockFactory.mockDatabaseRepository.getAllBooks()).thenReturn(null);
        ObservableBookListPresenter bookListPresenterUnderTest = new ObservableBookListPresenter();
        IBookListView expectedview = MockFactory.mockBookListActivity;

        //Act
        bookListPresenterUnderTest.attachScreen(expectedview);

        //Assert
        Assert.assertEquals(expectedview, MockFactory.mockBookListActivity);

        verify(MockFactory.mockBookListActivity, times(1)).clearEditText();
        verify(MockFactory.mockBookListActivity, times(1)).updateListVisibility();

        verify(MockFactory.mockDatabaseRepository, times(1)).getAllBooks();

        verify(MockFactory.mockLocalBookListAdapter, times(1)).clear();
        verify(MockFactory.mockLocalBookListAdapter, times(1)).addBooks(anyList());

        verify(MockFactory.mockRemoteBookListAdapter, times(1)).clear();
    }

    @Test
    public void bookDetailPresenterAttachScreenTest_BookFound(){
        //Arrange
        BookDetailPresenter bookDetailPresenterUnderTest = new BookDetailPresenter();
        IBookDetailView expectedView = MockFactory.mockBookDetailActivity;

        when(MockFactory.mockDatabaseRepository.getBookById(anyLong())).thenReturn(new Book());

        //Act
        bookDetailPresenterUnderTest.attachScreen(expectedView);

        //Assert
        Assert.assertEquals(expectedView, MockFactory.mockBookDetailActivity);

        verify(MockFactory.mockDatabaseRepository, times(1)).getBookById(anyLong());

        verify(MockFactory.mockBookDetailActivity, times(0)).goBack();

        verify(MockFactory.mockBookDetailActivity, times(1)).loadBookData(any(Book.class));
    }

    @Test
    public void bookDetailPresenterAttachScreenTest_BookNotFounc(){
        //Arrange
        BookDetailPresenter bookDetailPresenterUnderTest = new BookDetailPresenter();
        IBookDetailView expectedView = MockFactory.mockBookDetailActivity;

        when(MockFactory.mockDatabaseRepository.getBookById(anyLong())).thenReturn(null);

        //Act
        bookDetailPresenterUnderTest.attachScreen(expectedView);

        //Assert
        Assert.assertEquals(expectedView, MockFactory.mockBookDetailActivity);

        verify(MockFactory.mockDatabaseRepository, times(1)).getBookById(anyLong());

        verify(MockFactory.mockBookDetailActivity, times(1)).goBack();

        verify(MockFactory.mockBookDetailActivity, times(0)).loadBookData(any(Book.class));
    }
}
