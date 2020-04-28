package com.example.hbr.tests;

import com.example.hbr.TestApplication;
import com.example.hbr.adapter.BookListAdapter;
import com.example.hbr.mocks.MockFactory;
import com.example.hbr.model.Book;
import com.example.hbr.model.apimodels.GoodReadsResponse;
import com.example.hbr.model.apimodels.Results;
import com.example.hbr.model.apimodels.Search;
import com.example.hbr.observable.ObservableBookListPresenter;
import com.example.hbr.view.IBookListView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.HTTP;
import retrofit2.mock.Calls;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class BookListPresenterTest {

    @Spy
    private ObservableBookListPresenter bookListPresenterUnderTest;

    @Before
    public void startup() {
        MockFactory.generate();
        bookListPresenterUnderTest = spy(new ObservableBookListPresenter());
        IBookListView mockBookListActivity = MockFactory.mockBookListActivity;
        bookListPresenterUnderTest.attachScreen(mockBookListActivity);
        TestApplication.injector.inject(bookListPresenterUnderTest);
    }

    @Test
    public void findBookByTitleTest_Success() {
        //Arrange
        //Act
        bookListPresenterUnderTest.findBookByTitle("Title");
        int expectedBookCount = 10;

        //Assert
        verify(MockFactory.mockRemoteBookListAdapter, times(2)).clear();//1 from attachScreen

        verify(MockFactory.mockRemoteBookListAdapter, times(1)).addBooks(anyList());
        verify(MockFactory.mockLocalBookListAdapter, times(2)).addBooks(anyList());//1 from attachScreen

        verify(bookListPresenterUnderTest, times(1)).onResponse(any(Call.class), any(Response.class));

        verify(MockFactory.mockBookListActivity, times(2)).updateListVisibility();//1 from attachScreen
        verify(MockFactory.mockBookListActivity, times(2)).clearEditText();//1 from attachScreen

        verify(MockFactory.mockDatabaseRepository, times(2)).getAllBooks();//1 from attachScreen
        verify(MockFactory.mockDatabaseRepository, times(1)).insertBooks(anyList());

        List<Book> mockTable = MockFactory.mockTable;
        Assert.assertEquals(expectedBookCount, mockTable.size());
    }


    @Test
    public void findBookByTitleTest_Success_IncorrectData_No_Response() {
        //Arrange
        GoodReadsResponse response = null;
        when(MockFactory.mockWebservice.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.response(response));

        //Act
        bookListPresenterUnderTest.findBookByTitle("Title");

        //Assert
        assertFindBookByTitleTest_Success_IncorrectData();
    }

    @Test
    public void findBookByTitleTest_Success_IncorrectData_No_Search() {
        //Arrange
        GoodReadsResponse response = new GoodReadsResponse();
        when(MockFactory.mockWebservice.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.response(response));

        //Act
        bookListPresenterUnderTest.findBookByTitle("Title");

        //Assert
        assertFindBookByTitleTest_Success_IncorrectData();
    }

    @Test
    public void findBookByTitleTest_Success_IncorrectData_No_Results() {
        //Arrange
        GoodReadsResponse response = new GoodReadsResponse();
        Search search = new Search();
        response.setSearch(search);
        when(MockFactory.mockWebservice.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.response(response));

        //Act
        bookListPresenterUnderTest.findBookByTitle("Title");

        //Assert
        assertFindBookByTitleTest_Success_IncorrectData();
    }

    @Test
    public void findBookByTitleTest_Success_IncorrectData_No_Work() {
        //Arrange
        GoodReadsResponse response = new GoodReadsResponse();
        Search search = new Search();
        response.setSearch(search);
        Results results = new Results();
        search.setResults(results);
        when(MockFactory.mockWebservice.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.response(response));

        //Act
        bookListPresenterUnderTest.findBookByTitle("Title");

        //Assert
        assertFindBookByTitleTest_Success_IncorrectData();
    }

    private void assertFindBookByTitleTest_Success_IncorrectData() {
        verify(MockFactory.mockRemoteBookListAdapter, times(2)).clear();//1 from attachScreen

        verify(MockFactory.mockRemoteBookListAdapter, times(0)).addBooks(anyList());
        verify(MockFactory.mockLocalBookListAdapter, times(1)).addBooks(anyList());//1 from attachScreen

        verify(bookListPresenterUnderTest, times(1)).onResponse(any(Call.class), any(Response.class));

        verify(MockFactory.mockBookListActivity, times(1)).updateListVisibility();//1 from attachScreen
        verify(MockFactory.mockBookListActivity, times(1)).clearEditText();//1 from attachScreen

        verify(MockFactory.mockDatabaseRepository, times(1)).getAllBooks();//1 from attachScreen
        verify(MockFactory.mockDatabaseRepository, times(0)).insertBooks(anyList());
    }

    @Test
    public void findBookByTitleTest_Failure() {
        //Arrange
        when(MockFactory.mockWebservice.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.failure(new Exception()));

        //Act
        bookListPresenterUnderTest.findBookByTitle("Title");

        //Assert
        verify(bookListPresenterUnderTest, times(1)).onFailure(any(Call.class), any(Throwable.class));
    }

    @Test
    public void showBookDetailsByIdTest() {
        //Arrange
        //Act
        bookListPresenterUnderTest.showBookDetailsById(1L);

        //Assert
        verify(MockFactory.mockBookListActivity, times(1)).goToDetails(anyLong());
    }

    @Test
    public void getListAdaptersTest() {
        //Arrange
        //Act
        BookListAdapter actualRemoteListAdapter = bookListPresenterUnderTest.getRemoteListAdapter();
        BookListAdapter actualLocalListAdapter = bookListPresenterUnderTest.getLocalListAdapter();

        //Assert
        Assert.assertNotNull(actualRemoteListAdapter);
        Assert.assertNotNull(actualLocalListAdapter);
    }

    @Test
    public void isListsEmptyTest_True() {
        //Arrange
        // Act
        //Assert
        Assert.assertTrue(bookListPresenterUnderTest.isLocalListEmpty());
        Assert.assertTrue(bookListPresenterUnderTest.isRemoteListEmpty());

        verify(MockFactory.mockLocalBookListAdapter, times(1)).getItemCount();
        verify(MockFactory.mockRemoteBookListAdapter, times(1)).getItemCount();
    }

    @Test
    public void isListsEmptyTest_False() {
        //Arrange
        when(MockFactory.mockLocalBookListAdapter.getItemCount()).thenReturn(1);
        when(MockFactory.mockRemoteBookListAdapter.getItemCount()).thenReturn(1);

        //Act
        //Assert
        Assert.assertFalse(bookListPresenterUnderTest.isLocalListEmpty());
        Assert.assertFalse(bookListPresenterUnderTest.isRemoteListEmpty());

        verify(MockFactory.mockLocalBookListAdapter, times(1)).getItemCount();
        verify(MockFactory.mockRemoteBookListAdapter, times(1)).getItemCount();
    }
}
