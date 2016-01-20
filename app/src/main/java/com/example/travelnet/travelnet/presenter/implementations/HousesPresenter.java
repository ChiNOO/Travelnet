package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.HousesCallback;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 13/01/2016.
 * Travelnet - Christian
 */
public class HousesPresenter extends BasePresenter{
    private final HousesCallback callback;

    public HousesPresenter(Context context, HousesCallback callback) {
        super(context);
        this.callback = callback;
    }
}
