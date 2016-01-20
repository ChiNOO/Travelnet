package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.TravelsCallBack;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class TravelPresenter extends BasePresenter{
    private final TravelsCallBack callback;

    public TravelPresenter(Context context, TravelsCallBack callBack) {
        super(context);
        this.callback = callBack;
    }
}
