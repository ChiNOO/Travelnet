package com.example.travelnet.travelnet.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.HousesCallback;
import com.example.travelnet.travelnet.presenter.implementations.HousesPresenter;

import butterknife.ButterKnife;
import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class HousesFragment extends BaseFragment implements HousesCallback {

    private HousesPresenter mHousePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_houses,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mHousePresenter = new HousesPresenter(getContext(), this);
    }

    public static HousesFragment newInstance() {
        return new HousesFragment();
    }
}
