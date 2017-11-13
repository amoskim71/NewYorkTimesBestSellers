package com.disruptmidwest.one20.view.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.disruptmidwest.one20.R;
import com.disruptmidwest.one20.databinding.FragmentBookDetailsBinding;
import com.disruptmidwest.one20.di.Injectable;
import com.disruptmidwest.one20.viewmodel.BookViewModel;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class BookFragment extends Fragment implements Injectable {
    public static final String KEY_LIST_ID = "project_id";
    private FragmentBookDetailsBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_details, container, false);

        //Create and set the adapter for teh RecyclerView
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final BookViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(BookViewModel.class);

        viewModel.setProjectID(getArguments().getString(KEY_LIST_ID));

        binding.setProjectViewModel(viewModel);
        binding.setIsLoading(true);

        observeViewModel(viewModel);

    }

    private void observeViewModel(final BookViewModel viewModel) {
        //TODO fetch book details

    }

    /**
     * Creates project fragment for specific book ID
     */
    public static BookFragment forBook(String bookID) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();

        args.putString(KEY_LIST_ID, bookID);
        fragment.setArguments(args);

        return fragment;
    }


}
