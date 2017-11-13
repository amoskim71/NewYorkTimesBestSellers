package com.disruptmidwest.one20.di;

import com.disruptmidwest.one20.view.ui.BookActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jeta on 11/12/17.
 */

@Module
public abstract class BookActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract BookActivity contributeBookActivity();

}
