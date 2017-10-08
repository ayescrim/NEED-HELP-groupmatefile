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
import com.recipicks.recipicks.Tables.ProfileActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText textEmailLogin;
    private EditText textPwd;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmailLogin = (EditText) findViewById(R.id.textEmailLogin);
        textPwd = (EditText) findViewById(R.id.textPassLogin);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void bUserLogin_Click(View v){

        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Please, Wait!", "Processing.. ", true);
        (firebaseAuth.signInWithEmailAndPassword(textEmailLogin.getText().toString(), textPwd.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login Success!", Toast.LENGTH_LONG).show();
                            //Intent i = new Intent(LoginActivity.this, dataAddingActivity.class);
                            Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                            i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }
                });
    }
}
