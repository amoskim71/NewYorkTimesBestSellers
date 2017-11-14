package com.disruptmidwest.one20.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.disruptmidwest.one20.service.model.OverviewResponse;
import com.disruptmidwest.one20.service.repository.BooksRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;

/**
 * Created by Aleckson on 11/12/17.
 */

public class BookListViewModel extends AndroidViewModel {
    private final LiveData<OverviewResponse> booksListObservable;

    @Inject
    public BookListViewModel(@Nonnull BooksRepository booksRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        booksListObservable = booksRepository.getOverview();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */

    public LiveData<OverviewResponse> getBooksListObservable(){
        return booksListObservable;
    }
}
