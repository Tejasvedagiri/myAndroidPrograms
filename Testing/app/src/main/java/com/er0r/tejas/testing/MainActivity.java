package com.er0r.tejas.testing;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    User you;
    public double latitude;
    public double longitude;
    int type;
    Pin p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        you = new User(this);
        p = new Pin(this);

        Button b1 = (Button)findViewById(R.id.UserLocation);
        Button b2 = (Button)findViewById(R.id.PIN);
        final EditText t1= (EditText)findViewById(R.id.PT);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setPin(t1.getText().toString());
                p.getlatlong();
                latitude=p.get_lat();
                longitude=p.get_log();
                Intent next = new Intent(getApplicationContext(),MapsActivity.class);
                next.putExtra("LOG",longitude);
                next.putExtra("LAT",latitude);
                startActivity(next);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(you.permision_check() == true){
                    you.set_latlong();
                    latitude=you.get_lat();
                    longitude=you.get_log();
                    type = 1;
                    Intent next = new Intent(getApplicationContext(),MapsActivity.class);
                    next.putExtra("LOG",longitude);
                    next.putExtra("LAT",latitude);
                    startActivity(next);
                    Toast.makeText(MainActivity.this, "latitude:" + latitude + " longitude:" + longitude, Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
