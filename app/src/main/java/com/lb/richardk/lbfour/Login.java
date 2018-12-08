package com.lb.richardk.lbfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText EmaileditText;
    private EditText PasswordeditText;
    private Button Loginbtn;
    private Button Registernowbutton;
    private TextView ForgotPassword;
    private TextView HomeTV;

    private DatabaseReference UserRef;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        UserRef = FirebaseDatabase.getInstance().getReference().child("User");




//        final TextView ForgotPassword = (TextView) findViewById(R.id.ForgotPdtextView);
//        ForgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
//                startActivity(startIntent);
//            }
//        });
//
//        final TextView hometv = (TextView) findViewById(R.id.HometextView);
//        hometv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), HomeActivity.class);
//                startActivity(startIntent);
//            }
//        });

        Button registernow = (Button)findViewById(R.id.RegisterNowbtn);
        registernow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(startIntent);
            }
        });

        Button forgotemailpasswordbtn = (Button) findViewById(R.id.ForgotEmailPasswordbtn);
        forgotemailpasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(startIntent);
            }
        });

        EmaileditText = (EditText) findViewById(R.id.EmaileditText);
        PasswordeditText = (EditText) findViewById(R.id.PasswordeditText);

        Loginbtn = (Button) findViewById(R.id.Loginbtn);

        Loginbtn.setOnClickListener(this);


    }
    @Override
    public void onClick(View v)
    {
        String email = EmaileditText.getText().toString();
        String password = PasswordeditText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            String currentUserId = mAuth.getCurrentUser().getUid();
                            String deviceToken = FirebaseInstanceId.getInstance().getToken();

                            UserRef.child(currentUserId).child("device_token")
                                    .setValue(deviceToken)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            if (task.isSuccessful())
                                            {
                                                // Sign in success, update UI with the signed-in user's information
                                                Log.d("Success", "signInWithEmail:success");
                                                FirebaseUser user = mAuth.getCurrentUser();
                                                //updateUI(user);
                                                Intent startIntent = new Intent(getApplicationContext(), HomeActivity.class);
                                                startActivity(startIntent);
                                                setContentView(R.layout.activity_home2);
                                            }

                                        }
                                    });

                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Log.w("Failed", "signInWithEmail:failure", task.getException());
                            // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //        Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }
                    }
                });
    }
}