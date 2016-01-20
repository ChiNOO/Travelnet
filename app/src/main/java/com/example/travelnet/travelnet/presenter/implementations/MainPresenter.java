package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.MainCallback;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 13/01/2016.
 * Travelnet - Christian
 */
public class MainPresenter extends BasePresenter {
    private final MainCallback callback;

    public MainPresenter(Context context, MainCallback callback) {
        super(context);
        this.callback = callback;
    }
}
