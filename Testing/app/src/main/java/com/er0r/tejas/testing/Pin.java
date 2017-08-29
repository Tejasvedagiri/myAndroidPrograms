package com.er0r.tejas.testing;

import android.location.Address;
import android.location.Geocoder;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tejas on 30-07-2017.
 */

public class Pin {
    private MainActivity activity;
    private Geocoder geocoder;
    private String zipCode = "" ;
    private double latitude;
    private double longitude;

    Pin(MainActivity activity){
        this.activity=activity;
        geocoder = new Geocoder(activity);
    }
    void getlatlong(){
        try {
            List<Address> addresses = geocoder.getFromLocationName(zipCode, 1);
            Address address = addresses.get(0);
            latitude = address.getLatitude();
            longitude = address.getLongitude();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    double get_lat(){
        return latitude;
    }
    double get_log(){
        return longitude;
    }

    void setPin(String p){
        zipCode = p;
    }
}
