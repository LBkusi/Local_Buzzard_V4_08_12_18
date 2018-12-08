package com.lb.richardk.lbfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        Button sendalertbtn = (Button)findViewById(R.id.SendAlertbtn);
        sendalertbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SendAlertActivity.class);
                startActivity(startIntent);
            }
        });

        Button receivedalertsbtn = (Button)findViewById(R.id.ReceivedAlertsbtn);
        receivedalertsbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ReceivedActivity.class);
                startActivity(startIntent);
            }
        });

        Button contactusbtn = (Button)findViewById(R.id.Contactusbtn);
        contactusbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(startIntent);
            }
        });

        Button settingbutton = (Button) findViewById(R.id.Settingbutton);
        settingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(startIntent);
            }
        });


    }
}
