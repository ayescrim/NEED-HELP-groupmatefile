package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.recipicks.recipicks.Tables.TableIG;

import java.util.ArrayList;
import java.util.List;

public class IGonClick extends AppCompatActivity {


    ListView LVingredients;

    DatabaseReference databaseIG;

    List<TableIG> iglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igon_click);

        databaseIG = FirebaseDatabase.getInstance().getReference("1Ingredients");

        LVingredients = (ListView) findViewById(R.id.LVingredients);

        iglist = new ArrayList<>();
    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseIG.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                iglist.clear();
                for (DataSnapshot IGsnapshot : dataSnapshot.getChildren()){

                    TableIG ingredients = IGsnapshot.getValue(TableIG.class);

                    iglist.add(ingredients);
                }

                IGlist adapter = new IGlist(IGonClick.this, iglist);
                LVingredients.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void editingredients(View view) {

        //Intent proceeds = new Intent(MainMenu.this, animalFeature.class);
        Intent proceeds = new Intent(IGonClick.this, TableForIG.class);
        //Intent proceeds = new Intent(ProfileActivity.this, swipetab.class);
        startActivity(proceeds);
    }
}
