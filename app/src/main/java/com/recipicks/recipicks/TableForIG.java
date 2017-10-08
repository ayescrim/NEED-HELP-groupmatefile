package com.recipicks.recipicks;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.recipicks.recipicks.Tables.TableIG;

public class TableForIG extends AppCompatActivity {


    EditText EtName;
    EditText EtDescription;
    Button buttonAddIG;

    DatabaseReference databaseIG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_for_ig);

        databaseIG = FirebaseDatabase.getInstance().getReference("1Ingredients");

        EtName = (EditText) findViewById(R.id.EtName);
        EtDescription = (EditText) findViewById(R.id.EtDescription);
        buttonAddIG = (Button) findViewById(R.id.addIG);


        buttonAddIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIngredients();
            }
        });
    }


    private void addIngredients(){

        String name = EtName.getText().toString().trim();
        String description = EtDescription.getText().toString().trim();


        if(!TextUtils.isEmpty(name)){

            String id = databaseIG.push().getKey();

            TableIG ingredients = new TableIG(id, name , description);

            databaseIG.child(id).setValue(ingredients);

            Toast.makeText(this, "ADDED!", Toast.LENGTH_LONG).show();

        } else if(!TextUtils.isEmpty(description)) {

            String id = databaseIG.push().getKey();

            TableIG ingredients = new TableIG(id, name , description);

            databaseIG.child(id).setValue(ingredients);

            Toast.makeText(this, "ADDED!", Toast.LENGTH_LONG).show();


        } else {

            Toast.makeText(this, "Enter Something!" , Toast.LENGTH_LONG).show();
        }
    }
}
