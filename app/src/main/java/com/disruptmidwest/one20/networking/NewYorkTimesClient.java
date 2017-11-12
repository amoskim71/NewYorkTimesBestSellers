package com.disruptmidwest.one20.networking;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jeta on 11/10/17.
 */

public class NewYorkTimesClient {


    private static final String URL = "http://BooksApi.nytimes.com/svc/books/v3/lists";

    HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    BooksApi bookServiceApi = retrofit.create(BooksApi.class);

}
