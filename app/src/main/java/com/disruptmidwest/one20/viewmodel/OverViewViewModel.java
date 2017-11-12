package com.disruptmidwest.one20.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;


import com.disruptmidwest.one20.model.OverviewResponse;
import com.disruptmidwest.one20.networking.OverviewRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;

/**
 * Created by jeta on 11/12/17.
 */

public class OverViewViewModel extends AndroidViewModel {
    private final LiveData<OverviewResponse> overviewResponseObservable;

    @Inject
    public OverViewViewModel(@Nonnull OverviewRepository overviewRepository, @Nonnull Application application) {
        super(application);
        overviewResponseObservable = overviewRepository.getOverview();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<OverviewResponse> getOverviewResponseLiveData(){
        return overviewResponseObservable;
    }
}
