package com.example.travelnet.travelnet.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.presenter.callbacks.RoomsCallback;
import com.example.travelnet.travelnet.presenter.implementations.RoomsPresenter;

import at.markushi.ui.CircleButton;
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
    LinearLayout mLinearLayout;

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
        LinearLayout placeHolder = (LinearLayout)getView().findViewById(R.id.fr_rooms_rl_rooms);
        for(int i = 1; i <= position; i++){
            LinearLayout mRoom = (LinearLayout)View.inflate(getContext(), R.layout.room, null);
            TextView txt = (TextView) mRoom.findViewById(R.id.txt);
            txt.setText("Habitación " + i);

            CircleButton mCbuttonAddA = (CircleButton)mRoom.findViewById(R.id.roomAddAdult);
            mCbuttonAddA.setId(i + 1);

            CircleButton mCbuttonLessA = (CircleButton)mRoom.findViewById(R.id.roomLessAdult);
            mCbuttonLessA.setId(i + 1);

            CircleButton mCbuttonAddK = (CircleButton)mRoom.findViewById(R.id.roomAddKids);
            mCbuttonAddK.setId(i + 1);

            CircleButton mCbuttonLessK = (CircleButton)mRoom.findViewById(R.id.roomLessKids);
            mCbuttonLessK.setId(i + 1);

            final TextView mTextViewNAdts = (TextView)mRoom.findViewById(R.id.noAdults);
            mTextViewNAdts.setId(i + 1);
            final TextView mTextViewNKids = (TextView)mRoom.findViewById(R.id.noKids);
            mTextViewNKids.setId(i + 1);
            mCbuttonAddA.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int noA = Integer.parseInt((String) mTextViewNAdts.getText());
                    if (noA < 5) {
                        noA += 1;
                        mTextViewNAdts.setText(String.valueOf(noA));
                    }

                }
            });
            mCbuttonLessA.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int noA = Integer.parseInt((String) mTextViewNAdts.getText());
                    if (noA > 1){
                        noA -= 1;
                        mTextViewNAdts.setText(String.valueOf(noA));
                    }

                }
            });
            mCbuttonAddK.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int noA = Integer.parseInt((String) mTextViewNKids.getText());
                    if (noA < 5) {
                        noA += 1;
                        mTextViewNKids.setText(String.valueOf(noA));
                    }

                }
            });
            mCbuttonLessK.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int noA = Integer.parseInt((String) mTextViewNKids.getText());
                    if (noA > 1){
                        noA -= 1;
                        mTextViewNKids.setText(String.valueOf(noA));
                    }

                }
            });
            placeHolder.addView(mRoom);
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
