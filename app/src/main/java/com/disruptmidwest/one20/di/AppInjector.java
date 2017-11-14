package com.disruptmidwest.one20.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.disruptmidwest.one20.CovrApplication;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Aleckson on 11/12/17.
 *
 *  * AppInjector is a helper class to automatically inject fragments if they implement {@link Injectable}.
 */

public class AppInjector {
    private AppInjector() {}

    public static void init(CovrApplication covrApplication){
        DaggerAppComponent.builder().application(covrApplication)
                .build().inject(covrApplication);


        covrApplication
                .registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    @Override
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                            handleActivity(activity);
                    }

                    @Override
                    public void onActivityStarted(Activity activity) {

                    }

                    @Override
                    public void onActivityResumed(Activity activity) {

                    }

                    @Override
                    public void onActivityPaused(Activity activity) {

                    }

                    @Override
                    public void onActivityStopped(Activity activity) {

                    }

                    @Override
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

                    }

                    @Override
                    public void onActivityDestroyed(Activity activity) {

                    }
                });
    }


    private static void handleActivity(Activity activity){
        if (activity instanceof HasSupportFragmentInjector){
            AndroidInjection.inject(activity);
        }
        if (activity instanceof FragmentActivity){
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(
                            new FragmentManager.FragmentLifecycleCallbacks() {
                                @Override
                                public void onFragmentCreated(FragmentManager fm, Fragment fragment, Bundle savedInstanceState) {
                                    super.onFragmentCreated(fm, fragment, savedInstanceState);
                                    if (fragment instanceof Injectable){
                                        AndroidSupportInjection.inject(fragment);
                                    }
                                }
                            }, true);
        }
    }
}
