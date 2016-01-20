package com.example.travelnet.travelnet.view.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.library.events.EventDateSelected;
import com.example.travelnet.travelnet.presenter.callbacks.HotelsCallback;
import com.example.travelnet.travelnet.presenter.implementations.HotelsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.Subscribe;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class HotelsFragment extends MainNavigationFragment implements HotelsCallback {
    public static HotelsFragment newInstance() {
        return new HotelsFragment();
    }

    HotelsPresenter mHotelsPresenter;

    @Bind(R.id.toolbar_hotels_date_ini_text)
    EditText editTextDateIni;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotels, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @Override
    protected View getToolbarView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.toolbar_items_hotels, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Subscribe
    public void onDateSelectedEvent(EventDateSelected event) {
        editTextDateIni.setText(event.date);
    }

    @OnClick(R.id.toolbar_hotels_date_ini_text)
    public void onClick() {
        Fragment fragment;
        fragment = CalendarFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_hotels_fr, fragment).commit();

    }

    @Override
    protected BasePresenter getPresenter() {
        return mHotelsPresenter = new HotelsPresenter(getContext(), this);
    }

}
