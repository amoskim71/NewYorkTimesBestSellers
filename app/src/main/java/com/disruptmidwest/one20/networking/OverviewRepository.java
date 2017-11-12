package com.disruptmidwest.one20.networking;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Aleckson on 11/12/17.
 */

@Singleton
public class OverviewRepository {
    private BooksApi booksApi;

    @Inject

    public OverviewRepository(BooksApi booksApi) {
        this.booksApi = booksApi;
    }
}
