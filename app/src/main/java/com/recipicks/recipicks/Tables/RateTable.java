package com.recipicks.recipicks.Tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.recipicks.recipicks.R;

public class RateTable extends AppCompatActivity {

    EditText Rate_table;
    Button addRating;

    DatabaseReference databaseRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_table);

        databaseRating = FirebaseDatabase.getInstance().getReference("Rating");

        Rate_table = (EditText) findViewById(R.id.Rate_table);
        addRating = (Button) findViewById(R.id.addRating);

        addRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Rate();
            }
        });

    }

    private void Rate(){

        String rate = Rate_table.getText().toString().trim();

        if(!TextUtils.isEmpty(rate)){

            String id = databaseRating.push().getKey();

            RateData rateData = new RateData(id,rate);
            databaseRating.child(id).setValue(rateData);

            Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(this, "PUT SOMETHInG", Toast.LENGTH_LONG).show();
        }
    }
}
