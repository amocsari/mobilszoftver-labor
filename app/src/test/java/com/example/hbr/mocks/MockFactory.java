package com.example.hbr.mocks;

import com.example.hbr.adapter.BookListAdapter;
import com.example.hbr.model.Book;
import com.example.hbr.model.apimodels.Author;
import com.example.hbr.model.apimodels.GoodReadsResponse;
import com.example.hbr.model.apimodels.Results;
import com.example.hbr.model.apimodels.Search;
import com.example.hbr.model.apimodels.Work;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;
import com.example.hbr.view.BookDetailActivity;
import com.example.hbr.view.BookListActivity;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import retrofit2.mock.Calls;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockFactory {

    @Mock
    public static DatabaseRepository mockDatabaseRepository;
    @Mock
    public static BookListAdapter mockRemoteBookListAdapter;
    @Mock
    public static BookListAdapter mockLocalBookListAdapter;
    @Mock
    public static Webservice mockWebservice;
    @Mock
    public static BookListActivity mockBookListActivity;
    @Mock
    public static BookDetailActivity mockBookDetailActivity;

    public static List<Book> mockTable;

    public static void generate() {
        generateMockBookDetailActivity();
        generateMockBookListActivity();
        generateMockDatabaseRespository();
        generateMockLocalBookListAdapter();
        generateMockRemoteBookListAdapter();
        generateMockWebService();
    }

    private static void generateMockLocalBookListAdapter() {
        mockLocalBookListAdapter = mock(BookListAdapter.class);
    }

    private static void generateMockRemoteBookListAdapter() {
        mockRemoteBookListAdapter = mock(BookListAdapter.class);
    }

    private static void generateMockWebService() {
        GoodReadsResponse sampleResponse = generateSampleResponse();

        mockWebservice = Mockito.mock(Webservice.class);

        when(mockWebservice.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.response(sampleResponse));
    }

    private static void generateMockDatabaseRespository() {
        mockTable = new ArrayList<>();

        mockDatabaseRepository = Mockito.mock(DatabaseRepository.class);

        doAnswer(invocation -> {
            List<Book> books = invocation.getArgument(0);

            mockTable.addAll(books);

            return null;
        }).when(mockDatabaseRepository).insertBooks(anyListOf(Book.class));

        when(mockDatabaseRepository.getAllBooks()).thenReturn(mockTable);

        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);

            Optional<Book> book = mockTable.stream().filter(b -> b.getGoodReadsId().equals(id)).findFirst();

            return book.orElse(null);
        }).when(mockDatabaseRepository).getBookById(anyLong());

        doAnswer(invocation -> {
            Book book = invocation.getArgument(0);

            mockTable.remove(book);

            return null;
        }).when(mockDatabaseRepository).DeleteBook(any(Book.class));

        doAnswer(invocation -> {
            Long bookId = invocation.getArgument(0);

            mockTable.removeIf(book -> book.getGoodReadsId().equals(bookId));

            return null;
        }).when(mockDatabaseRepository).DeleteBookById(anyLong());
    }

    private static void generateMockBookListActivity() {
        mockBookListActivity = Mockito.mock(BookListActivity.class);

        doNothing().when(mockBookListActivity).updateListVisibility();
        doNothing().when(mockBookListActivity).goToDetails(anyLong());
    }

    private static void generateMockBookDetailActivity() {
        mockBookDetailActivity = Mockito.mock(BookDetailActivity.class);
        when(mockBookDetailActivity.getBookId()).thenReturn(1001L);
    }

    public static GoodReadsResponse generateSampleResponse() {
        GoodReadsResponse goodReadsResponse = new GoodReadsResponse();
        Search search = new Search();
        Results results = new Results();
        List<Work> works = new ArrayList<>();
        Author author = new Author();

        author.setId(3L);
        author.setName("RemoteAuthor3");

        for (Long l = 1001L; l <= 1010; l++) {
            Work work = new Work();
            com.example.hbr.model.apimodels.Book bestBook = new com.example.hbr.model.apimodels.Book();
            bestBook.setAuthor(author);
            bestBook.setId(l);
            bestBook.setImageUrl("ImageUrl" + l);
            bestBook.setSmallImageUrl("SmallImageUrl" + l);
            bestBook.setTitle("Title" + l);
            bestBook.setType("book");

            work.setBestBook(bestBook);
            work.setAverageRating(new BigDecimal(4.5));
            work.setOriginalPublicationDay(2020L);
            work.setOriginalPublicationDay(1L);
            work.setOriginalPublicationMonth(3L);
            work.setRatingsCount(1005L);

            works.add(work);
        }

        results.setWork(works);

        search.setResults(results);

        goodReadsResponse.setSearch(search);

        return goodReadsResponse;
    }
}
