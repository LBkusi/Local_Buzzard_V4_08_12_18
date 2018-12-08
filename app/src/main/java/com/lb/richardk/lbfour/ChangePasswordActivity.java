package com.lb.richardk.lbfour;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public EditText password;
    public EditText confPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        password = (EditText) findViewById(R.id.NewPasswordeditText4);
        confPassword = (EditText) findViewById(R.id.ConfirmPasswordeditText5);

        if(password == confPassword)
        {
            Button updatePass = (Button)findViewById(R.id.ChangePasswordbutton);
            updatePass.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String pass = password.getText().toString();

                    user.updatePassword(pass)
                            .addOnCompleteListener(new OnCompleteListener<Void>()
                            {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Log.d("Success", "User password updated.");
                                    }
                                }
                            });
                }
            });
        }
        else
        {
            password.setError("Passwords do not match");
        }
    }
}