package com.example.micthebick.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.micthebick.ui_sample.MainActivity;
import com.example.micthebick.ui_sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micth on 2016-05-01.
 */
public class FirstFragment extends Fragment {

    private Spinner TopBuildingList, TopCommList;
    private Spinner BottomBuildingList, BottomCommList;
    private Button  Lookup, selectField;
    private RecyclerView insideRecycleView;

    private ArrayAdapter<String>   dataAdapter;
    public ArrayList<String> tempData;

    public static FirstFragment newInstance(){

        FirstFragment fragment  =   new FirstFragment();
        return fragment;

    }

    public FirstFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView   =   inflater.inflate(R.layout.fragment_one, container, false);

        TopBuildingList =   (Spinner)rootView.findViewById(R.id.spn_topBuilding);
        TopCommList =   (Spinner)rootView.findViewById(R.id.spn_topCommu);

        BottomBuildingList  =   (Spinner)rootView.findViewById(R.id.spn_bottomBuilding);
        BottomCommList  =   (Spinner)rootView.findViewById(R.id.spn_bottomCommu);

        Lookup  =   (Button)rootView.findViewById(R.id.btn_lookup);
        selectField =   (Button)rootView.findViewById(R.id.btn_field);

        TopBuildingList.setAdapter(dataAdapter);
        TopCommList.setAdapter(dataAdapter);

        BottomBuildingList.setAdapter(dataAdapter);
        BottomCommList.setAdapter(dataAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((MainActivity)getActivity()).onSectionAttached(1);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tempData    =   new ArrayList<String>();
        tempData.add("Automobile");
        tempData.add("Business Services");
        tempData.add("Computers");
        tempData.add("Education");
        tempData.add("Personal");
        tempData.add("Travel");
        dataAdapter =   new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item, tempData);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
