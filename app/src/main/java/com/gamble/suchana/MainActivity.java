package com.gamble.suchana;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userID, password;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("details",MODE_PRIVATE);
        userID = (EditText)findViewById(R.id.userID);
        password = (EditText)findViewById(R.id.userpassword);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(userID.getText().toString())) {
                    if (!TextUtils.isEmpty(password.getText().toString())) {
                        editor = sharedPreferences.edit();
                        editor.putString("Registration",userID.getText().toString());
                        editor.putString("Password",password.getText().toString());
                        editor.apply();
                        Intent gotologinpage = new Intent(MainActivity.this,Home.class);
                        startActivity(gotologinpage);

                    }else
                        password.setError("password is required");
                }else
                    userID.setError("ID is required");

            }
        });

        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);

    }




}
