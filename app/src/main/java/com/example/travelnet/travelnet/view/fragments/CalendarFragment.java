package com.example.travelnet.travelnet.view.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.CalendarCallback;
import com.example.travelnet.travelnet.library.events.EventDateSelected;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by cvazquez on 18/01/2016.
 */
public class CalendarFragment extends EventBusFragment implements CalendarCallback, CalendarPickerView.OnDateSelectedListener {

    @Bind(R.id.fr_calendar_view)
    CalendarPickerView mCalendar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        mCalendar.init(today, nextYear.getTime()) //
                .inMode(SelectionMode.SINGLE) //
                .withSelectedDate(new Date());
        mCalendar.setOnDateSelectedListener(this);

    }

    public static Fragment newInstance() {
        return new CalendarFragment();
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onDateSelected(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String result = sdf.format(date);
        mBus.post(new EventDateSelected(result));
    }

    @Override
    public void onDateUnselected(Date date) {

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
