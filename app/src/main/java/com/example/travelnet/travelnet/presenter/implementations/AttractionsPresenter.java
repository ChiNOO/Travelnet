package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.AttractionsCallback;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class AttractionsPresenter extends BasePresenter {
    private final AttractionsCallback callback;

    public AttractionsPresenter(Context context, AttractionsCallback callback) {
        super(context);
        this.callback = callback;
    }
}
