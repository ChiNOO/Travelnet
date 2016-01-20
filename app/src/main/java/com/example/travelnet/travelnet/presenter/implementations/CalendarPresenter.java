package com.example.travelnet.travelnet.presenter.implementations;

import android.content.Context;

import com.example.travelnet.travelnet.presenter.callbacks.CalendarCallback;
import com.example.travelnet.travelnet.view.fragments.CalendarFragment;

import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by cvazquez on 18/01/2016.
 */
public class CalendarPresenter extends BasePresenter {
    private final CalendarCallback callback;

    public CalendarPresenter(Context context, CalendarFragment callback) {
        super(context);
        this.callback = callback;
    }
}
