package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.HotelsCallback;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class HotelsPresenter extends BasePresenter {
    private final HotelsCallback callback;

    public HotelsPresenter(Context context, HotelsCallback callback) {
        super(context);
        this.callback = callback;
    }
}
