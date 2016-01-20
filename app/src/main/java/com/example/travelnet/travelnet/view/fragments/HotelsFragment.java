package com.example.travelnet.travelnet.view.fragments;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.ChargingEvent;
import com.example.travelnet.travelnet.presenter.callbacks.HotelsCallback;
import com.example.travelnet.travelnet.presenter.implementations.HotelsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import io.dflabs.lib.mvp.BaseFragment;
import io.dflabs.lib.mvp.BasePresenter;

import static com.example.travelnet.travelnet.R.color.buttonSelected;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public class HotelsFragment extends BaseFragment implements HotelsCallback {
    private HotelsPresenter mHotelsPresenter;
    private EventBus bus = EventBus.getDefault();

    @Bind(R.id.toolbar_hotels_seekbar)
    SeekBar seekBarNoRooms;
    @Bind(R.id.toolbar_hotels_noRooms)
    TextView textViewNoRooms;
    @Bind(R.id.toolbar_hotels_dateIni_text)
    EditText editTextDateIni;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotels, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        bus.register(this);
        seekBarNoRooms.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue + 1;
                textViewNoRooms.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }

    public void onEvent(ChargingEvent event){
        editTextDateIni.setText(event.getData());
    }

    @Override
    public void onDestroy() {
        // Unregister
        bus.unregister(this);
        super.onDestroy();
    }

    @OnClick(R.id.toolbar_hotels_dateIni_text)
    public void onClick() {
        Fragment fragment = null;
        fragment = new CalendarFragment().newInstance();
        editTextDateIni.setBackgroundColor(Color.argb(10, 255, 255, 255));
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragment_hotels_fr, fragment).commit();

    }


    @Override
    protected BasePresenter getPresenter() {
        return mHotelsPresenter = new HotelsPresenter(getContext(), this);
    }

    public static HotelsFragment newInstance() {
        return new HotelsFragment();
    }


}
