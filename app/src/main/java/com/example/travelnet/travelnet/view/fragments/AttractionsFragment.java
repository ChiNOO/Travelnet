package com.example.travelnet.travelnet.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.AttractionsCallback;
import com.example.travelnet.travelnet.presenter.implementations.AttractionsPresenter;

import butterknife.ButterKnife;
import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class AttractionsFragment extends BaseFragment implements AttractionsCallback {

    private AttractionsPresenter mAttraction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_travels, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    protected BasePresenter getPresenter() {
        return mAttraction = new AttractionsPresenter(getContext(), this);
    }

    public static Fragment newInstance() {
        return new AttractionsFragment();
    }
}
