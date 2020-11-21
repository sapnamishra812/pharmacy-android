package com.example.login.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.login.DBHelper;
import com.example.login.model.Store;

import java.util.ArrayList;

public class StoreViewModel extends AndroidViewModel {

    private DBHelper dbHelper;


    public StoreViewModel(@NonNull Application application) {
        super(application);
        dbHelper=new DBHelper(application);
    }
    public ArrayList<Store> fetchStoreByLocationId(int locationId){
        return dbHelper.fetchStoreByLocationId(locationId);
    }
}
