package com.disruptmidwest.one20.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jeta on 11/13/17.
 */

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder> {

    @Override
    public CrimeAdapter.CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CrimeAdapter.CrimeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CrimeViewHolder extends RecyclerView.ViewHolder {
        public CrimeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
