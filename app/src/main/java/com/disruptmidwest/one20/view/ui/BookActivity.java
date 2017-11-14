package com.disruptmidwest.one20.view.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.disruptmidwest.one20.R;
import com.disruptmidwest.one20.service.model.OverviewResponse;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class BookActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> androidInjector;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // Add project list fragment if this is first creation
        if (savedInstanceState==null){
            BookListFragment fragment = new BookListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, BookListFragment.TAG).commit();
        }
    }

    /** Shows the book detail Fragment */
    /*public void show(OverviewResponse response){
        BookFragment bookFragment = BookFragment.forBook(response.results.lists.get(1).getListName());

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container,
                        bookFragment, null).commit();
    }*/

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return androidInjector;
    }
}
