package com.er0r.tejas.loginserver;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    Person p;
    EditText username,password;
    Button login;
    Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.LogIN);
        username = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                p = new Person(username.getText().toString(),password.getText().toString(),MainActivity.this);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        flag = p.test();
                        if(flag){
                            Toast.makeText(MainActivity.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, 2000);


            }
        });
    }
}
