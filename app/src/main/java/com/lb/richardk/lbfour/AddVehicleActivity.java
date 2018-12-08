package com.lb.richardk.lbfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class AddVehicleActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Car");
    DatabaseReference myRegRef = database.getReference("Registration");

    public EditText registration;
    public EditText model;
    public EditText colour;
    public EditText make;
    public EditText borough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        registration = (EditText) findViewById(R.id.ViewMakeeditText);
        model = (EditText) findViewById(R.id.ViewModeleditText2);
        colour = (EditText) findViewById(R.id.ViewColoureditText2);
        make = (EditText) findViewById(R.id.ViewMakeeditText);
        borough = (EditText) findViewById(R.id.BorougheditText);


        Button addBtn = (Button)findViewById(R.id.AddVehiclebutton);
        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String vReg = registration.getText().toString();
                String mod = model.getText().toString();
                String col = colour.getText().toString();
                String mk = make.getText().toString();
                String bor = borough.getText().toString();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                String uid = user.getUid();

                Car car = new Car(vReg, mod, col, mk, bor);

                myRef.child(uid).push().setValue(car);
                myRegRef.child(vReg).child("uid").setValue(uid);
            }
        });
    }
}
