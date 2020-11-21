package com.example.login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.listener.LocationListener;
import com.example.login.model.Location;
import com.example.login.viewholder.LocationViewHolder;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder>{

    private ArrayList<Location> locationArrayList;
    private View view;
    private LocationListener locationListener;
    public LocationAdapter(ArrayList<Location> locationArrayList){
        this.locationArrayList=locationArrayList;
    }

    public void setOnLocationListener(LocationListener locationListener){
        this.locationListener=locationListener;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_location_layout,null,false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.bind(locationArrayList.get(position),locationListener);
    }

    @Override
    public int getItemCount() {
        return locationArrayList.size();
    }
}
