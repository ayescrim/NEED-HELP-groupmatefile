package com.recipicks.recipicks;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.recipicks.recipicks.R.id.toolbar;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
    public void bRegistration_Click(View v){
        Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(i);


    }
    public void bLogin_Click(View v){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);


    }




}

//<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">


