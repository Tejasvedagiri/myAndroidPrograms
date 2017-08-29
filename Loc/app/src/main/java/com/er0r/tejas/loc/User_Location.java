package com.er0r.tejas.loc;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;

/**
 * Created by Tejas on 27-07-2017.
 */

public class User_Location {
    public Criteria criteria;
    public String bestProvider;
    public double latitude;
    public double longitude;
    public LocationManager lm;
    public Button MyLocation;
    public Location location;
    LocationListener locationListener;

    User_Location() {

}
