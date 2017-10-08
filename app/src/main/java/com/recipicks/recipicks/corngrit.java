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
import com.recipicks.recipicks.Tables.dataAddingActivity;
import com.recipicks.recipicks.Tables.dataFood;

import java.util.ArrayList;
import java.util.List;

public class corngrit extends AppCompatActivity {
    DatabaseReference databaseSaveFood;
    ListView adoboListView2;
    List<dataFood> foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corngrit);


        databaseSaveFood = FirebaseDatabase.getInstance().getReference("Recipe");
        adoboListView2 = (ListView) findViewById(R.id.adoboListView2);


        foodList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseSaveFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                foodList.clear();


                for (DataSnapshot foodSnapShot : dataSnapshot.getChildren()){
                    dataFood foods = foodSnapShot.getValue(dataFood.class);


                    foodList.add(foods);

                }

                FoodList adapter = new FoodList(corngrit.this, foodList);
                adoboListView2.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

/*
    public void addprocedure(View view){

        Intent procedureadd = new Intent(corngrit.this, ProcedureTable.class);

        startActivity(procedureadd);
    }*/

    public void editnutri(View view){

        Intent nutri = new Intent(corngrit.this, dataAddingActivity.class);

            startActivity(nutri);

    }
/*
    public void editingredient(View view){

        Intent nutris = new Intent(corngrit.this, compute.class);

        startActivity(nutris);

    }*/


}







