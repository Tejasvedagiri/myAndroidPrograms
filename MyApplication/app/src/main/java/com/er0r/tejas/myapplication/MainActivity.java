package com.er0r.tejas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button rent,sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rent= (Button)findViewById(R.id.Rent);
        sale = (Button)findViewById(R.id.Sale);



        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(getApplicationContext(), MapsActivity.class);
                next.putExtra("Extra",0);
                startActivity(next);
            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(getApplicationContext(),MapsActivity.class);
                next.putExtra("Extra",1);
                startActivity(next);
            }
        });
    }
}
