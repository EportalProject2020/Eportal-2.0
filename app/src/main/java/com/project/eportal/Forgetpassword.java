package com.project.eportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgetpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
    }

    public void ForgotPassword(View view) {
        EditText et_getemail = findViewById(R.id.et_enteremail);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = et_getemail.getText().toString();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Forgetpassword.this, "An email will be sent to your account",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Forgetpassword.this, "Something went wrong recheck the email you entered",
                                    Toast.LENGTH_SHORT).show();
                    }
                });

    }
}