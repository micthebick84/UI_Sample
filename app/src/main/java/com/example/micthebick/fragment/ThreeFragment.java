package com.example.micthebick.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.micthebick.ui_sample.MainActivity;
import com.example.micthebick.ui_sample.R;

/**
 * Created by micth on 2016-05-08.
 */
public class ThreeFragment extends Fragment {


    public static ThreeFragment newInstance(){

        ThreeFragment   fragment    =   new ThreeFragment();
        return fragment;

    }

    public ThreeFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView   =   inflater.inflate(R.layout.fragment_three, container, false);
        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity)getActivity()).onSectionAttached(3);
    }

}
