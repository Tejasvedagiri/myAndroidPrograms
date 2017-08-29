package com.er0r.tejas.mylatlong;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Criteria criteria;
    public String bestProvider;
    public double latitude;
    public double longitude;
    public LocationManager lm;
    public Button MyLocation;
    public Location location;
    int flag = 0;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            Log.i("Hello", "PRelM");
             lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
             criteria = new Criteria();
             bestProvider = String.valueOf(lm.getBestProvider(criteria, true)).toString();
             location = lm.getLastKnownLocation(bestProvider);
        }
        else{
            return;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyLocation = (Button) findViewById(R.id.Getloc);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, flag);
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            flag = 1;

        } else {
            Log.i("Hello", "asldov");
            lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            criteria = new Criteria();
            bestProvider = String.valueOf(lm.getBestProvider(criteria, true)).toString();
            location = lm.getLastKnownLocation(bestProvider);
        }


            MyLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (location != null) {
                        Log.e("Hello", "GPS is on");
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                        Toast.makeText(MainActivity.this, "latitude:" + latitude + " longitude:" + longitude, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

}

