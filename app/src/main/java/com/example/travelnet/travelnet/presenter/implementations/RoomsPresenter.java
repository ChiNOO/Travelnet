package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.RoomsCallback;
import com.example.travelnet.travelnet.view.fragments.RoomsFragment;

import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by cvazquez on 26/01/2016.
 */
public class RoomsPresenter extends BasePresenter {
    private final RoomsCallback callback;
    public RoomsPresenter(Context context, RoomsCallback callback) {
        super(context);
        this.callback = callback;
    }
}
