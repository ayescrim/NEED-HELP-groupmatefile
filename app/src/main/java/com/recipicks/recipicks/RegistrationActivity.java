package com.recipicks.recipicks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText textEmailAddress;
    private EditText textPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textEmailAddress = (EditText) findViewById(R.id.textEmailReg);
        textPassword = (EditText) findViewById(R.id.textPassReg);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void bRegister_Click(View v){

        final ProgressDialog progressDialog = ProgressDialog.show(RegistrationActivity.this , "Please, Wait", "Processing", true);
        (firebaseAuth.createUserWithEmailAndPassword(textEmailAddress.getText().toString(),textPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){

                            Toast.makeText(RegistrationActivity.this, "Registration is Successful!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                            startActivity(i);

                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
