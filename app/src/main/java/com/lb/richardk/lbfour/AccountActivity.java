package com.lb.richardk.lbfour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        Button updatedetailsbutton4 = (Button)findViewById(R.id.UpdateDetailsbutton4);
        updatedetailsbutton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), UpdateDetailsActivity.class);
                startActivity(startIntent);
            }
        });

        Button sentreceivedalertsbutton5 = (Button)findViewById(R.id.SentReceivedAlertsbutton5);
        sentreceivedalertsbutton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SentReceivedActivity.class);
                startActivity(startIntent);
            }
        });

        Button changepasswordbutton3 = (Button)findViewById(R.id.ChangePasswordbutton3);
        changepasswordbutton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ChangePasswordActivity.class);
                startActivity(startIntent);
            }
        });

        Button viewvehiclebutton = (Button) findViewById(R.id.VehicleViewbutton);
        viewvehiclebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), VehicleViewActivity.class);
                startActivity(startIntent);
            }
        });

        Button logoutbutton = (Button) findViewById(R.id.LogOutbutton);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

                Intent startIntent = new Intent(getApplicationContext(), Login.class);
                startActivity(startIntent);
            }
        });
    }
}
