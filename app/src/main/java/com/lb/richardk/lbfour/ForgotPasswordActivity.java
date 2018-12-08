package com.lb.richardk.lbfour;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    FirebaseAuth auth = FirebaseAuth.getInstance();

    public EditText email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = (EditText) findViewById(R.id.EmailNumbereditText2);

        Button updatePass = (Button)findViewById(R.id.SendCodebutton);
        updatePass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String emailAddress = email.getText().toString();

                auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Log.d("Success", "Email sent.");
                        }
                    }
                });
            }
        });
        
    }
}
