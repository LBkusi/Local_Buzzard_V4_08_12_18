package com.lb.richardk.lbfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Button feedbackbtn = (Button)findViewById(R.id.Feedbackbtn);
        feedbackbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), FeedbackActivity.class);
                startActivity(startIntent);
            }
        });


        Button helpenquirebtn = (Button)findViewById(R.id.HelpEnquirebtn);
        helpenquirebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HelpEnquireActivity.class);
                startActivity(startIntent);

            }
        });

    }
}
