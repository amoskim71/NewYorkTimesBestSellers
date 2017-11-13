package com.disruptmidwest.one20.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.disruptmidwest.one20.service.model.OverviewResponse;
import com.disruptmidwest.one20.service.repository.OverviewRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Aleckson on 11/12/17.
 */

public class BookListViewModel extends AndroidViewModel {
    private final LiveData<OverviewResponse> booksListObservable;

    @Inject
    public BookListViewModel(@Nonnull OverviewRepository overviewRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        booksListObservable = overviewRepository.getOverview();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */

    public LiveData<OverviewResponse> getBooksListObservable(){
        return booksListObservable;
    }
}
