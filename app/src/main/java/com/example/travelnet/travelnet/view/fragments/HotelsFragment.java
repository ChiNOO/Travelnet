package com.example.travelnet.travelnet.view.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.library.events.EventDateSelected;
import com.example.travelnet.travelnet.presenter.callbacks.HotelsCallback;
import com.example.travelnet.travelnet.presenter.implementations.HotelsPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTouch;
import de.greenrobot.event.Subscribe;
import io.dflabs.lib.mvp.BasePresenter;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class HotelsFragment extends MainNavigationFragment implements HotelsCallback {
    private Date mDateIni, mDateEnd;

    public static HotelsFragment newInstance() {
        return new HotelsFragment();
    }

    private boolean focus = true;
    HotelsPresenter mHotelsPresenter;

    @Bind(R.id.toolbar_hotels_date_ini_text)
    EditText mEditTextDateIni;
    @Bind(R.id.toolbar_hotels_date_end_text)
    EditText mEditTextDateEnd;
    @Bind(R.id.toolbar_hotels_location)
    EditText mEditTextLocation;
    @Bind(R.id.toolbar_hotels_spinner)
    Spinner mSpinnerRooms;

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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (focus == true){
            if(!mEditTextDateEnd.getText().toString().matches("")){
                try {
                    mDateIni = format.parse(mEditTextDateEnd.getText().toString());
                    mDateEnd = format.parse(event.date);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                if (mDateEnd.compareTo(mDateIni) > 0){
                    Toast.makeText(getContext(), "La fecha de entrada debe ser inferior.", Toast.LENGTH_SHORT).show();
                }else{
                    mEditTextDateIni.setText(event.date);
                }
            }else{
                mEditTextDateIni.setText(event.date);
            }
        }else{
            if(!mEditTextDateIni.getText().toString().matches("")){
                try {
                    mDateIni = format.parse(mEditTextDateIni.getText().toString());
                    mDateEnd = format.parse(event.date);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                if (mDateEnd.compareTo(mDateIni) < 0){
                    Toast.makeText(getContext(), "La fecha de salida debe ser posterior.", Toast.LENGTH_SHORT).show();
                }else{
                    mEditTextDateEnd.setText(event.date);
                }
            }else{
                mEditTextDateEnd.setText(event.date);
            }
        }

    }

    @OnClick(R.id.toolbar_hotels_date_ini_text)
    public void onClickDateIni() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditTextDateIni.getWindowToken(), 0);

        mEditTextDateIni.setFocusable(true);
        focus = true;
        Fragment fragment;
        fragment = CalendarFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_hotels_fr, fragment).commit();

    }

    @OnClick(R.id.toolbar_hotels_date_end_text)
    public void onClickDateEnd() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditTextDateEnd.getWindowToken(), 0);

        mEditTextDateEnd.setFocusable(true);
        focus = false;
        Fragment fragment;
        fragment = CalendarFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_hotels_fr, fragment).commit();
    }

    @OnTouch(R.id.toolbar_hotels_location) boolean onTouch() {
        Fragment fragment;
        fragment = LocationFragment.newInstance();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_hotels_fr, fragment).commit();
        return false;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mHotelsPresenter = new HotelsPresenter(getContext(), this);
    }

    @OnItemSelected(R.id.toolbar_hotels_spinner)
    void onItemSelected(int position) {
        if (position > 0){
            Toast.makeText(getContext(), "Selected position " + position + "!", Toast.LENGTH_SHORT).show();
            Fragment fragment;
            fragment = RoomsFragment.newInstance(position);
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fragment_hotels_fr, fragment).commit();
        }

    }
}
