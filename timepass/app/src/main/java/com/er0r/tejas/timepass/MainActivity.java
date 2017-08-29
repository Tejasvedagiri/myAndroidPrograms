package com.er0r.tejas.timepass;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
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
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_ACCESS_FINE_LOCATION = 101;
    LocationManager lm;
    LocationListener loclis;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_ACCESS_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //

                    }
                    else{
                        Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button UserLocation = (Button)findViewById(R.id.Getloc);
        Button PinLocation = (Button)findViewById(R.id.PinLoc);
        EditText Pin = (EditText)findViewById(R.id.Pin);
        lm= (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ACCESS_FINE_LOCATION);

        }
        else{
            Location lla = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double lat;
            lat=lla.getLatitude();
            Log.d("Hello", String.valueOf(lat));
        }

            loclis = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

    }
}
