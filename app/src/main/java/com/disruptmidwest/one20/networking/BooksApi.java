package com.disruptmidwest.one20.networking;

import com.disruptmidwest.one20.model.OverviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jeta on 11/10/17.
 */

public interface BooksApi {

    //get best seller list
    @GET("overview.json")
    Call<OverviewResponse> getOverview();

}
