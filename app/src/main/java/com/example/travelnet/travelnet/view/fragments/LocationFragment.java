package com.example.travelnet.travelnet.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.LocationCallback;
import com.example.travelnet.travelnet.presenter.implementations.LocationsPresenter;

import butterknife.ButterKnife;
import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian Vargas on 26/01/2016.
 */
public class LocationFragment extends BaseFragment implements LocationCallback {


    private LocationsPresenter mLocationPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mLocationPresenter = new LocationsPresenter(getContext(), this);
    }

    public static Fragment newInstance() {
        return new LocationFragment();
    }
}
