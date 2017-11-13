package com.disruptmidwest.one20.di;

import android.app.Application;

import com.disruptmidwest.one20.CovrApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Aleckson on 11/12/17.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        BookActivityModule.class
})

public interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
    void inject(CovrApplication covrApplication);
}
