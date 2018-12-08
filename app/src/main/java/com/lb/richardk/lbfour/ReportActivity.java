package com.lb.richardk.lbfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Report");

    public EditText name;
    public EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        name = (EditText) findViewById(R.id.SubjecttText);
        message = (EditText) findViewById(R.id.MessageText);

        Button report = (Button) findViewById(R.id.Reportbtn);
        report.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(startIntent);

                String nam = name.getText().toString();
                String mess = message.getText().toString();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                String uid = user.getUid();

                Report newReport = new Report(nam, mess);

                myRef.child(uid).push().setValue(newReport);
            }
        });
    }
}

