package com.example.login.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.login.DBHelper;
import com.example.login.model.Location;

import java.util.ArrayList;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private DBHelper dbHelper;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        dbHelper=new DBHelper(application);
    }


    public ArrayList<Location> fetchLocation(){
        return dbHelper.fetchLocation();
    }

}