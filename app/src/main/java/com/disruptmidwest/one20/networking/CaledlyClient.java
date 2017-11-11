package com.disruptmidwest.one20.networking;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jeta on 11/10/17.
 */

public class CaledlyClient {

    private String URL = "https://calendly.com/api/v1/users/me";

    Retrofit retrofit =
            new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
