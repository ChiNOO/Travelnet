package com.example.travelnet.travelnet.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.RoomsCallback;
import com.example.travelnet.travelnet.presenter.implementations.RoomsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian Vargas on 26/01/2016.
 */
public class RoomsFragment extends BaseFragment implements RoomsCallback {
    private RoomsPresenter mBasePresenter;
    private int position;
    TextView tv;
    @Bind(R.id.fragment_rooms_layout)
    RelativeLayout mLinearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rooms, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        position =  getArguments().getInt("position", 0);
        ButterKnife.bind(this, view);
        for(int i = 1; i <= position; i++) {

        }
    }

    @Override
    protected BasePresenter getPresenter() {
       return mBasePresenter = new RoomsPresenter(getContext(), this);
    }

    public static Fragment newInstance(int position) {
        RoomsFragment f = new RoomsFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);
        return f;
    }
}
