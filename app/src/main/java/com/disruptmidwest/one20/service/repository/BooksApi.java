package com.disruptmidwest.one20.service.repository;

import com.disruptmidwest.one20.service.model.OverviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jeta on 11/10/17.
 */

public interface BooksApi {

    String URL = "http://BooksApi.nytimes.com/svc/books/v3/lists";

    //get best seller list
    @GET("overview.json")
    Call<OverviewResponse> getOverview();

}
