package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.LocationCallback;
import com.example.travelnet.travelnet.view.fragments.LocationFragment;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by cvazquez on 26/01/2016.
 */
public class LocationsPresenter extends BasePresenter {
    private final LocationCallback callback;
    public LocationsPresenter(Context context, LocationCallback callback) {
        super(context);
        this.callback = callback;
    }
}
