package com.disruptmidwest.one20;

import android.app.Activity;
import android.app.Application;

import com.disruptmidwest.one20.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Aleckson on 11/12/17.
 */

public class CovrApplication  extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector(){
        return dispatchingAndroidInjector;
    }


}
