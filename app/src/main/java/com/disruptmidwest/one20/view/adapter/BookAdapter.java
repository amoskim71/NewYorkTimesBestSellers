package com.disruptmidwest.one20.view.adapter;


import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.disruptmidwest.one20.R;
import com.disruptmidwest.one20.databinding.BookListItemBinding;
import com.disruptmidwest.one20.service.model.ListBookCatagory;
import com.disruptmidwest.one20.view.callback.BookClickCallback;

import java.util.List;
import java.util.Objects;

/**
 * Created by Aleckson on 11/12/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    List<? extends ListBookCatagory> bookList;
    //OverviewResponse mBookList = new OverviewResponse();

    @Nullable
    private final BookClickCallback bookClickCallback;

    public BookAdapter(@Nullable BookClickCallback bookClickCallback) {
        this.bookClickCallback = bookClickCallback;
    }

    public void setBookList(final List<? extends ListBookCatagory> bookList) {
        if (this.bookList == null) {
            this.bookList = bookList;
            notifyItemRangeInserted(0, bookList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return BookAdapter.this.bookList.size();
                }

                @Override
                public int getNewListSize() {
                    return bookList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return BookAdapter.this.bookList.get(oldItemPosition).getListId() ==
                            bookList.get(newItemPosition).getListId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    ListBookCatagory overviewResponse = bookList.get(newItemPosition);
                    ListBookCatagory old = bookList.get(oldItemPosition);
                    return overviewResponse.getListId() == old.getListId()
                            && Objects.equals(overviewResponse.getListName(), old.getListName());
                }
            });
            this.bookList = bookList;
            result.dispatchUpdatesTo(this);
        }
    }


    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BookListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.book_list_item,
                        parent, false);

        binding.setCallback(bookClickCallback);

        return new BookViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BookAdapter.BookViewHolder holder, int position) {
        holder.binding.setProject(bookList.get(position));
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return bookList == null ? 0 : bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        final BookListItemBinding binding;

        public BookViewHolder(BookListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
