package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.login.model.Location;
import com.example.login.model.Store;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "pharmacy.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table location(id INTEGER  primary key, name TEXT,city TEXT,state TEXT,pincode INTEGER)");
        MyDB.execSQL("CREATE TABLE store(id   INTEGER PRIMARY KEY,name TEXT    NOT NULL,location_id  INTEGER NOT NULL,FOREIGN KEY (location_id) REFERENCES location (id) ON DELETE CASCADE ON UPDATE NO ACTION )");
        insertLocationData(MyDB,1, "Vasai", "Mumbai", "Maharashtra", 401209);
        insertLocationData(MyDB,2, "Virar", "Mumbai", "Maharashtra", 401209);
        insertLocationData(MyDB,3, "Palghar", "Mumbai", "Maharashtra", 401209);
        insertLocationData(MyDB,4, "Boisar", "Mumbai", "Maharashtra", 401209);
        insertLocationData(MyDB,5, "Thane", "Mumbai", "Maharashtra", 401209);

        insertStoreData(MyDB,1, "Wellness Forever");
        insertStoreData(MyDB,1, "Wellness Forever1");
        insertStoreData(MyDB,1, "Wellness Forever2");

        insertStoreData(MyDB,2, "Wellness Forever21");
        insertStoreData(MyDB,2, "Wellness Forever22");
        insertStoreData(MyDB,2, "Wellness Forever23");
        insertStoreData(MyDB,2, "Wellness Forever24");

        insertStoreData(MyDB,3, "Wellness Forever31");
        insertStoreData(MyDB,4, "Wellness Forever41");
        insertStoreData(MyDB,5, "Wellness Forever51");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists location");
        MyDB.execSQL("drop Table if exists store");

    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;


    }

    public Boolean insertLocationData(SQLiteDatabase MyDB,int locationId, String name, String city, String state, int pincode) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", locationId);
        contentValues.put("name", name);
        contentValues.put("city", city);
        contentValues.put("state", state);
        contentValues.put("pincode", pincode);
        long result = MyDB.insert("location", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean insertStoreData(SQLiteDatabase MyDB,int locationId, String store) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("location_id", locationId);
        contentValues.put("name", store);
        long result = MyDB.insert("store", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }


    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and  password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public ArrayList<Location> fetchLocation() {
        ArrayList<Location> locationArrayList = new ArrayList<>();
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from location", null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);   //0 is the number of id column in your database table
                String name = cursor.getString(1);
                String city = cursor.getString(2);
                String state = cursor.getString(3);
                int pincode = cursor.getInt(4);

                System.out.println("RRR location "+name);

                Location location = new Location();
                location.setId(id);
                location.setName(name);
                location.setCity(city);
                location.setState(state);
                location.setPinCode(pincode);
                locationArrayList.add(location);
            }
        }
        return locationArrayList;
    }

    public ArrayList<Store> fetchStoreByLocationId(int locationId) {
        ArrayList<Store> storeList = new ArrayList<>();
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from store where location_id = ?", new String[]{String.valueOf(locationId)});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);   //0 is the number of id column in your database table
                String name = cursor.getString(1);

                System.out.println("RRR location "+name);

                Store store = new Store();
                store.setId(id);
                store.setName(name);
                storeList.add(store);
            }
        }
        return storeList;
    }


}
