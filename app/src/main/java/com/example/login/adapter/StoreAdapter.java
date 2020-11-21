package com.example.login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.listener.LocationListener;
import com.example.login.model.Location;
import com.example.login.model.Store;
import com.example.login.viewholder.LocationViewHolder;
import com.example.login.viewholder.StoreViewHolder;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreViewHolder>{

    private ArrayList<Store> storeArrayList;
    private View view;
    public StoreAdapter(ArrayList<Store> storeArrayList){
        this.storeArrayList=storeArrayList;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_store_layout,null,false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        holder.bind(storeArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return storeArrayList.size();
    }
}
