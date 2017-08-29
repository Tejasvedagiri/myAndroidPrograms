package com.er0r.tejas.testing;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by Tejas on 30-07-2017.
 */

public class User {
    private MainActivity activity;
    private LocationListener locationListener;
    private LocationManager mylocation;
    int Location_ID = 100;
    private Criteria criteria;
    private String bestProvider;
    private double latitude;
    private double longitude;
    private Location location;
    boolean flag = false;

     User(MainActivity activity){
        this.activity = activity;
         if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
             ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Location_ID);
         }
    }

    private MainActivity get_activity() {
        return activity;
    }

    boolean permision_check(){
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Location_ID);
        }
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mylocation = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            criteria = new Criteria();
            bestProvider = String.valueOf(mylocation.getBestProvider(criteria, true)).toString();
            location = mylocation.getLastKnownLocation(bestProvider);
            flag = true;
        }
        else{
            Toast.makeText(activity, "Need to Give Location Access", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        return flag;
    }
    void set_latlong(){
        latitude=location.getLatitude();
        longitude=location.getLongitude();
    }
    double get_lat(){
        return latitude;
    }
    double get_log(){
        return longitude;
    }
}
