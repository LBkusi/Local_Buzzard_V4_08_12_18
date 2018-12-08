package com.lb.richardk.lbfour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Feedback");

    Intent SubmitApp;

    public RatingBar ratingBar;
    public EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        SubmitApp = new Intent(Intent. ACTION_VIEW);
        comment = findViewById(R.id.CommenteditText);

//        if (comment.getText().toString().equals(""))
//            comment.setError("Please complete");
//        else
//        {
        Button submit = (Button) findViewById(R.id.SubmitFeedbackbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String comS = comment.getText().toString();
                float rating = ratingBar.getRating();

                Feedback feedback = new Feedback(rating, comS);

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                String uid = user.getUid();

                myRef.child(uid).push().setValue(feedback);

//                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setData(Uri.parse("mailto:"));
//                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"enquiries@localbuzzard.co.uk"});
//                i.putExtra(Intent. EXTRA_SUBJECT, comment.getText().toString());
//
//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.putExtra(Intent.EXTRA_TEXT, comS);
//
//                email.setType("message/rfc822");
//                startActivity(Intent.createChooser(email, "enquiries@localbuzzard.co.uk") );
//
//                SubmitApp.setData(Uri.parse("enquiries@localbuzzard.co.uk"));
//                startActivity(SubmitApp);


            }
        });


        // final RatingBar Ratingratingbar = (RatingBar) findViewById(R.id.RatingratingBar);


//    }

}
}