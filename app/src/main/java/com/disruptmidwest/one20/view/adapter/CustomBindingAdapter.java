package com.disruptmidwest.one20.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by jeta on 11/13/17.
 */

public class CustomBindingAdapter {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show){
        view.setVisibility(show ? View.VISIBLE : View.GONE );
    }
}
