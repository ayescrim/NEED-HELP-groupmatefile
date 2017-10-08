package com.recipicks.recipicks.Tables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.recipicks.recipicks.MainMenu;
import com.recipicks.recipicks.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvEmail;
    EditText editTextName;
    EditText editTextAge;
    Button saveInfo;

    DatabaseReference databaseSaveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmail = (TextView) findViewById(R.id.tvEmailProfile);
        tvEmail.setText(getIntent().getExtras().getString("Email"));

        databaseSaveInfo = FirebaseDatabase.getInstance().getReference("User");


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        saveInfo = (Button) findViewById(R.id.saveButton);

        saveInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){

                saveInfo();

            }
        });

    }
    private void saveInfo(){

        String name = editTextName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            //create unique id for saveinfo and get the saveinfo stirng
            String id =  databaseSaveInfo.push().getKey();

            Profiles profiles = new Profiles(name,age);

            databaseSaveInfo.child(id).setValue(profiles);//this will store the info to id and generate a unique id, so everytime an id is generated
            //it wil lbe unique

            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();

            Intent x = new Intent(ProfileActivity.this, MainMenu.class);
            startActivity(x);


        } else if (!TextUtils.isEmpty(age)){

            //create unique id for saveinfo and get the saveinfo stirng
            String id =  databaseSaveInfo.push().getKey();

            Profiles profiles = new Profiles(name,age);

            databaseSaveInfo.child(id).setValue(profiles);//this will store the info to id and generate a unique id, so everytime an id is generated
            //it wil lbe unique

            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();

            Intent x = new Intent(ProfileActivity.this, MainMenu.class);
            startActivity(x);



        } else {

            Toast.makeText(this,"You should Enter a name", Toast.LENGTH_LONG).show();
        }
    }

    public void proceed_click(View view) {

        Intent proceeds = new Intent(ProfileActivity.this, MainMenu.class);
        //Intent proceeds = new Intent(ProfileActivity.this, RecipeIngredient.class);
       //Intent proceeds = new Intent(ProfileActivity.this, swipetab.class);
        startActivity(proceeds);
    }

}
