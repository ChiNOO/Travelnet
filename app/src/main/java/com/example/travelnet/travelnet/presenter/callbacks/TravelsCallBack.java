package com.example.travelnet.travelnet.presenter.callbacks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Christian on 12/01/2016.
 * Travelnet - Christian
 */
public interface TravelsCallBack {
    @Nullable
    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
