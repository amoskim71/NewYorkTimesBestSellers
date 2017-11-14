package com.disruptmidwest.one20.di;

import com.disruptmidwest.one20.viewmodel.BookListViewModel;
import com.disruptmidwest.one20.viewmodel.BookViewModel;

import dagger.Subcomponent;

/**
 * Created by Aleckson on 11/12/17.
 *
 * This is a sub component to create View Model instances.
 */

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    BookListViewModel bookListViewModel();
    BookViewModel booksViewModel();
}
