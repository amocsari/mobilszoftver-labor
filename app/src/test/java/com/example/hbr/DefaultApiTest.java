/*
 * Swagger GoodReadsApi
 * This is a sample server Petstore server. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.example.hbr;

import com.example.hbr.respository.web.client.ApiException;
import com.example.hbr.respository.web.client.api.DefaultApi;
import com.example.hbr.respository.web.client.model.Book;
import com.example.hbr.respository.web.client.model.GoodReadsResponse;
import com.example.hbr.respository.web.client.model.Request;
import com.example.hbr.respository.web.client.model.Results;
import com.example.hbr.respository.web.client.model.Search;
import com.example.hbr.respository.web.client.model.Work;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for DefaultApi
 */
@Ignore
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    /**
     * Find books by title, author, or ISBN
     *
     * Get an xml response with the most popular books for the given query. This will search all books in the title/author/ISBN fields and show matches, sorted by popularity on Goodreads. There will be cases where a result is shown on the Goodreads site, but not through the API. This happens when the result is an Amazon-only edition and we have to honor Amazon&#x27;s terms of service.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void queryBooksTest() throws ApiException {
        String key = "Kn9jyCFyPgYJUgV4B1bsw";
        String q = "hobbit";
        Integer page = 1;
        String searchField = "title";
        GoodReadsResponse response = api.queryBooks(key, q, page, searchField);

        // TODO: test validations
        Assert.assertNotNull(response);

        Request request = response.getRequest();
        Assert.assertNotNull(request);

        Search search = response.getSearch();
        Assert.assertNotNull(search);

        Results results = search.getResults();
        Assert.assertNotNull(results);

        List<Work> works = results.getWork();
        Assert.assertNotNull(works);

        for (Work work: works) {
            Book bestBook = work.getBestBook();
            Assert.assertNotNull(bestBook);
        }
    }
}
