package com.disruptmidwest.one20.view.ui;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.disruptmidwest.one20.R;
import com.disruptmidwest.one20.databinding.FragmentBookListBinding;
import com.disruptmidwest.one20.di.Injectable;
import com.disruptmidwest.one20.service.model.OverviewResponse;
import com.disruptmidwest.one20.view.adapter.BookAdapter;
import com.disruptmidwest.one20.view.callback.BookClickCallback;
import com.disruptmidwest.one20.viewmodel.BookListViewModel;

import javax.inject.Inject;

public class BookListFragment extends Fragment implements Injectable {
    public static final String TAG = "BookListFragment";
    private BookAdapter bookAdapter;
    private FragmentBookListBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_list, container, false);

        binding.bookList.setAdapter(bookAdapter);
        bookAdapter = new BookAdapter(bookClickCallback);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final BookListViewModel viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(BookListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(BookListViewModel viewModel) {
        //Update the list when the data changes
        viewModel.getBooksListObservable().observe(this, new Observer<OverviewResponse>() {
            @Override
            public void onChanged(@Nullable OverviewResponse overviewResponse) {
                if (overviewResponse != null) {
                    binding.setIsLoading(false);
                    bookAdapter.setBookList(overviewResponse.results.lists);
                }
            }
        });
    }

    public final BookClickCallback bookClickCallback = new BookClickCallback() {
        @Override
        public void onClick(OverviewResponse response) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((BookActivity) getActivity()).show(response);
            }
        }
    };


}
