package com.disruptmidwest.one20.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.disruptmidwest.one20.service.model.OverviewResponse;
import com.disruptmidwest.one20.service.repository.OverviewRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;

/**
 * Created by Aleckson on 11/12/17.
 */

public class BookViewModel extends AndroidViewModel {
    private static final String TAG = BookViewModel.class.getName();
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private final LiveData<OverviewResponse> booksObservable;
    private final MutableLiveData<String> booksID;

    public ObservableField<OverviewResponse> response = new ObservableField<>();

    @Inject
    public BookViewModel(@NonNull OverviewRepository overviewRepository, @Nonnull  Application application) {
        super(application);

        this.booksID = new MutableLiveData<>();

        booksObservable = Transformations.switchMap(booksID, input -> {
            if (input.isEmpty()){
                Log.i(TAG, "ProjectViewModel projectID is absent!!!");
                return ABSENT;
            }
            Log.i(TAG, "ProjectViewModel projectID is" + booksID.getValue());

            return overviewRepository.getOverview();
        });
    }

    public LiveData<OverviewResponse> overviewResponseLiveData(){
        return booksObservable;
    }
    public void setProject(OverviewResponse response){
        this.response.set(response);
    }

    public void setProjectID(String projectID){
        this.booksID.setValue(projectID);
    }
}
