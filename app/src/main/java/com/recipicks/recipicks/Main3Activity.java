package com.recipicks.recipicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.recipicks.recipicks.Tables.Procedures;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    EditText EtPro;
    EditText EtProname;
    Button buttonAddProcedure;


    DatabaseReference databaseProcedures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        databaseProcedures = FirebaseDatabase.getInstance().getReference("Procedures2");

        EtPro = (EditText) findViewById(R.id.EtPro);
        EtProname = (EditText) findViewById(R.id.EtProname);
        buttonAddProcedure = (Button) findViewById(R.id.addProcedure);

        buttonAddProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProcedure();
            }
        });
    }


    private void addProcedure(){

        String procedure = EtPro.getText().toString().trim();
        String proname = EtProname.getText().toString().trim();

        if(!TextUtils.isEmpty(procedure)){

           String id = databaseProcedures.push().getKey();

            Procedures procedures = new Procedures(id, procedure , proname);

            databaseProcedures.setValue(procedures);

            Toast.makeText(this, "ADDED!" , Toast.LENGTH_LONG).show();

        } else if (!TextUtils.isEmpty((proname))){

            String id = databaseProcedures.push().getKey();

            Procedures procedures = new Procedures(id, procedure , proname);

            databaseProcedures.child(id).setValue(proname);

            Toast.makeText(this, "ADDED!" , Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, " Enter Something" , Toast.LENGTH_LONG).show();
        }
    }
}
