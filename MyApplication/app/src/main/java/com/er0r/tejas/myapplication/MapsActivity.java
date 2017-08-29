package com.er0r.tejas.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        int i = getIntent().getIntExtra("Extra",0);
        h_rent test = new h_rent("Tejas","9611810077", "ID-1","S2-44/3","4th main","15th cross","Malleshwaram","Bangalore","Karnataka","RV_lab",560055,13.0064629,77.5675629);
        h_sale test1 = new h_sale("Tejas","9611810077", "ID-1","S2-44/3","4th main","15th cross","Malleshwaram","Bangalore","Karnataka","RV_lab",560055,13.061622,77.569389);
        Double x , y ;
        LatLng place;

        if(i==0) {
            x = test.get_lat();
            y = test.get_lot();
            place = new LatLng(x,y);
        }
        else {
            x = test1.get_lat();
            y = test1.get_lot();
            place = new LatLng(x,y);
        }

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(place).title(test.user_details()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
    }
}
