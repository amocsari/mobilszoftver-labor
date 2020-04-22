package com.example.hbr.mocks;

import com.example.hbr.model.Book;
import com.example.hbr.model.apimodels.Author;
import com.example.hbr.model.apimodels.GoodReadsResponse;
import com.example.hbr.model.apimodels.Results;
import com.example.hbr.model.apimodels.Search;
import com.example.hbr.model.apimodels.Work;
import com.example.hbr.respository.database.DatabaseRepository;
import com.example.hbr.respository.web.Webservice;

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
import static org.mockito.Mockito.when;

public class MockFactory {
    public static Webservice getMockWebService() {
        GoodReadsResponse sampleResponse = generateSampleResponse();

        Webservice mockWebService = Mockito.mock(Webservice.class);

        when(mockWebService.findBookByTitle(any(String.class), any(String.class), any(String.class))).thenReturn(Calls.response(sampleResponse));

        return mockWebService;
    }

    public static DatabaseRepository getMockDatabaseRespository() {
        List<Book> mockTable = generateSampleBooks();

        DatabaseRepository mockDatabaseRepository = Mockito.mock(DatabaseRepository.class);

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

        return mockDatabaseRepository;
    }

    private static List<Book> generateSampleBooks() {
        List<Book> bookList = new ArrayList<>();
        for (Long i = 0L; i < 20; i++) {
            Book book = new Book();
            book.setAuthor("Author" + i);
            book.setAverageRating(i % 5);
            book.setGoodReadsId(i);
            book.setPublication("publication" + i);
            book.setImageUrl("imgageUrl" + i);
            book.setSmallImageUrl("smallImageUrl" + i);
            book.setTitle("Title" + i);

            bookList.add(book);
        }

        return bookList;
    }

    private static GoodReadsResponse generateSampleResponse(){
        GoodReadsResponse goodReadsResponse = new GoodReadsResponse();
        Search search = new Search();
        Results results = new Results();
        List<Work> works = new ArrayList<>();
        Author author = new Author();

        author.setId(3L);
        author.setName("RemoteAuthor3");

        for(Long l = 1001L; l < 1010; l++) {
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
