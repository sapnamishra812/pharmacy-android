package com.example.login.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.StoreActivity;
import com.example.login.adapter.LocationAdapter;
import com.example.login.listener.LocationListener;
import com.example.login.model.Location;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements LocationListener {

    private HomeViewModel homeViewModel;
    private View view;
    private RecyclerView rvLocation;
    private LinearLayoutManager mLayoutManager;
    private LocationAdapter locationAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if(view == null){
            view = inflater.inflate(R.layout.fragment_home, container, false);
            initViews();
            setRecyclerView();

        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        setAdapter();
    }

    private void initViews(){
        rvLocation = view.findViewById(R.id.rv_locations);

    }

    private void setRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvLocation.setLayoutManager(mLayoutManager);
    }

    private void setAdapter(){
        ArrayList<Location> locationArrayList=homeViewModel.fetchLocation();
        if(locationAdapter == null){
            locationAdapter = new LocationAdapter(locationArrayList);
            locationAdapter.setOnLocationListener(this);
            rvLocation.setAdapter(locationAdapter);
        }else{
            locationAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onLocationSelected(Location location) {
        System.out.println("RRR location selected "+location.getName());

        //Passing locationId to  Store Activity
        //Calling Store Activity using Intent
        Intent storeIntent=new Intent(getActivity(), StoreActivity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("LOCATION_ID",location.getId());
        storeIntent.putExtras(bundle);
        startActivity(storeIntent);
    }
}