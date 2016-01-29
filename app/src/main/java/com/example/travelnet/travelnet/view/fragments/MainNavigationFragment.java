package com.example.travelnet.travelnet.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;

import com.example.travelnet.travelnet.view.activities.MainActivity;

public abstract class MainNavigationFragment extends EventBusFragment {

    private FrameLayout mToolbarContainer;



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbarContainer = ((MainActivity) getActivity()).getToolbarContainer();
        attachToolbarContainer();

    }

    private void attachToolbarContainer() {
        View toolbarView = getToolbarView();
        mToolbarContainer.addView(toolbarView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mToolbarContainer.removeAllViews();
    }

    protected abstract View getToolbarView();

}
