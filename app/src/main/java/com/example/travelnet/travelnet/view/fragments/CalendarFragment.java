package com.example.travelnet.travelnet.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.CalendarCallback;
import com.example.travelnet.travelnet.presenter.callbacks.ChargingEvent;
import com.example.travelnet.travelnet.presenter.implementations.CalendarPresenter;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by cvazquez on 18/01/2016.
 */
public class CalendarFragment extends BaseFragment implements CalendarCallback, CalendarPickerView.OnDateSelectedListener {
   //@Bind(R.id.calendar_view)

    private EventBus bus = EventBus.getDefault();

    private CalendarPickerView calendar;
    private CalendarPresenter mCalendarPresenter;
    private EditText dateIni;
    private EditText dateEnd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  calendar = new (CalendarPickerView)findViewById(R.id.calendar_view);
        ButterKnife.bind(this, view);
        dateIni = (EditText)getView().findViewById(R.id.toolbar_hotels_dateIni_text);
        calendar = (CalendarPickerView) getView().findViewById(R.id.calendar_view);
        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        calendar.init(today, nextYear.getTime()) //
                .inMode(SelectionMode.SINGLE) //
                .withSelectedDate(new Date());
        calendar.setOnDateSelectedListener(this);

    }

    @Override
    protected BasePresenter getPresenter() {
        return mCalendarPresenter = new CalendarPresenter(getContext(), this);
    }

    public static Fragment newInstance() {
        return new CalendarFragment();
    }

    @Override
    public void onDateSelected(Date date) {
        ChargingEvent ev = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String result = sdf.format(date);
        ev = new ChargingEvent(result);
        bus.post(ev);
    }

    @Override
    public void onDateUnselected(Date date) {

    }

}
