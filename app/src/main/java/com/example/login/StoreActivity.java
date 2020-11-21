package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.login.adapter.StoreAdapter;
import com.example.login.model.Store;
import com.example.login.ui.home.HomeViewModel;
import com.example.login.viewmodel.StoreViewModel;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    private int locationId;
    private RecyclerView rvStore;
    private StoreViewModel storeViewModel;
    private StoreAdapter storeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        fetchIntentData();
        initViews();
        setAdapter();
    }

    public void fetchIntentData(){
        Bundle bundle=getIntent().getExtras();
        if(bundle != null){
            if(bundle.containsKey("LOCATION_ID")){
                locationId = bundle.getInt("LOCATION_ID");
            }
        }
    }

    private void initViews(){
        rvStore = findViewById(R.id.rv_store);
        rvStore.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setAdapter(){
        storeViewModel =
                ViewModelProviders.of(this).get(StoreViewModel.class);
        ArrayList<Store> storeList = storeViewModel.fetchStoreByLocationId(locationId);

        if(storeAdapter == null){
            storeAdapter=new StoreAdapter(storeList);
            rvStore.setAdapter(storeAdapter);
        }

    }
}