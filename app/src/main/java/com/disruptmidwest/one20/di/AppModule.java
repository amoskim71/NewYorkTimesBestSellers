package com.disruptmidwest.one20.di;

import android.arch.lifecycle.ViewModelProvider;


import com.disruptmidwest.one20.service.repository.BooksApi;
import com.disruptmidwest.one20.viewmodel.BooksViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aleckson on 11/12/17.
 * <p>
 * AppModule is a Dagger module responsible for providing singleton services on the application level
 */
@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {
    @Singleton
    @Provides
    BooksApi provideBooksApi() {
        return new Retrofit.Builder()
                .baseUrl(BooksApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BooksApi.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new BooksViewModelFactory(viewModelSubComponent.build());
    }
}
