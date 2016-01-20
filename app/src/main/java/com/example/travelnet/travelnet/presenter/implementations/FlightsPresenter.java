package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.FlightsCallbak;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class FlightsPresenter extends BasePresenter {
    private final FlightsCallbak callback;

    public FlightsPresenter(Context context, FlightsCallbak callback) {
        super(context);
        this.callback = callback;
    }
}
