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

package com.example.hbr.respository.web.client.api;

import com.example.hbr.respository.web.client.ApiCallback;
import com.example.hbr.respository.web.client.ApiClient;
import com.example.hbr.respository.web.client.ApiException;
import com.example.hbr.respository.web.client.ApiResponse;
import com.example.hbr.respository.web.client.Configuration;
import com.example.hbr.respository.web.client.Pair;
import com.example.hbr.respository.web.client.ProgressRequestBody;
import com.example.hbr.respository.web.client.ProgressResponseBody;
import com.example.hbr.respository.web.client.model.GoodReadsResponse;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for queryBooks
     * @param key Developer key (required)
     * @param q The query text to match against book title, author, and ISBN fields. Supports boolean operators and phrase searching. (optional)
     * @param page Which page to return (default 1, optional) (optional)
     * @param searchField Field to search, one of &#x27;title&#x27;, &#x27;author&#x27;, or &#x27;all&#x27; (default is &#x27;all&#x27;) (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call queryBooksCall(String key, String q, Integer page, String searchField, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/search/index.xml";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (q != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (key != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("key", key));
        if (searchField != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("search[field]", searchField));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call queryBooksValidateBeforeCall(String key, String q, Integer page, String searchField, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new ApiException("Missing the required parameter 'key' when calling queryBooks(Async)");
        }
        
        com.squareup.okhttp.Call call = queryBooksCall(key, q, page, searchField, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Find books by title, author, or ISBN
     * Get an xml response with the most popular books for the given query. This will search all books in the title/author/ISBN fields and show matches, sorted by popularity on Goodreads. There will be cases where a result is shown on the Goodreads site, but not through the API. This happens when the result is an Amazon-only edition and we have to honor Amazon&#x27;s terms of service.
     * @param key Developer key (required)
     * @param q The query text to match against book title, author, and ISBN fields. Supports boolean operators and phrase searching. (optional)
     * @param page Which page to return (default 1, optional) (optional)
     * @param searchField Field to search, one of &#x27;title&#x27;, &#x27;author&#x27;, or &#x27;all&#x27; (default is &#x27;all&#x27;) (optional)
     * @return GoodReadsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GoodReadsResponse queryBooks(String key, String q, Integer page, String searchField) throws ApiException {
        ApiResponse<GoodReadsResponse> resp = queryBooksWithHttpInfo(key, q, page, searchField);
        return resp.getData();
    }

    /**
     * Find books by title, author, or ISBN
     * Get an xml response with the most popular books for the given query. This will search all books in the title/author/ISBN fields and show matches, sorted by popularity on Goodreads. There will be cases where a result is shown on the Goodreads site, but not through the API. This happens when the result is an Amazon-only edition and we have to honor Amazon&#x27;s terms of service.
     * @param key Developer key (required)
     * @param q The query text to match against book title, author, and ISBN fields. Supports boolean operators and phrase searching. (optional)
     * @param page Which page to return (default 1, optional) (optional)
     * @param searchField Field to search, one of &#x27;title&#x27;, &#x27;author&#x27;, or &#x27;all&#x27; (default is &#x27;all&#x27;) (optional)
     * @return ApiResponse&lt;GoodReadsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GoodReadsResponse> queryBooksWithHttpInfo(String key, String q, Integer page, String searchField) throws ApiException {
        com.squareup.okhttp.Call call = queryBooksValidateBeforeCall(key, q, page, searchField, null, null);
        Type localVarReturnType = new TypeToken<GoodReadsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Find books by title, author, or ISBN (asynchronously)
     * Get an xml response with the most popular books for the given query. This will search all books in the title/author/ISBN fields and show matches, sorted by popularity on Goodreads. There will be cases where a result is shown on the Goodreads site, but not through the API. This happens when the result is an Amazon-only edition and we have to honor Amazon&#x27;s terms of service.
     * @param key Developer key (required)
     * @param q The query text to match against book title, author, and ISBN fields. Supports boolean operators and phrase searching. (optional)
     * @param page Which page to return (default 1, optional) (optional)
     * @param searchField Field to search, one of &#x27;title&#x27;, &#x27;author&#x27;, or &#x27;all&#x27; (default is &#x27;all&#x27;) (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call queryBooksAsync(String key, String q, Integer page, String searchField, final ApiCallback<GoodReadsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = queryBooksValidateBeforeCall(key, q, page, searchField, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GoodReadsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
