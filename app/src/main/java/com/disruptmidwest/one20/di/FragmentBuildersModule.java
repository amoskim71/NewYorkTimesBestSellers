package com.disruptmidwest.one20.di;

import com.disruptmidwest.one20.view.ui.BookListFragment;
import com.disruptmidwest.one20.view.ui.BookFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jeta on 11/12/17.
 */

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract BookListFragment contriBookListFragment();

    @ContributesAndroidInjector
    abstract BookFragment bookDetailsFragment();
}
