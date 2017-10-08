package com.recipicks.recipicks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.recipicks.recipicks.Tables.dataAddingActivity;
import com.recipicks.recipicks.Tables.dataFood;

import java.util.ArrayList;
import java.util.List;

public class list_View extends Activity {


    //DatabaseReference databaseSaveFood;

    //ListView listViewFood;
    //List<dataFood> foodList;
   ListView listViewFood;

    String[] itemname ={
            "Corn Grit(white)", "Corn Grit(yellow)", "Flattened Rice", "Milled Rice", "Milled Rice(malagkit)", "Purple Rice",
            "Red Rice", "Brown Rice"
    };

    Integer[] imgid= {
            R.drawable.back1,
            R.drawable.back1,
            R.drawable.back1,
            R.drawable.back1,
            R.drawable.back1,
            R.drawable.back1,
            R.drawable.back1,
            R.drawable.back1,


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view);


        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        listViewFood = (ListView)findViewById(R.id.listViewFood);
        listViewFood.setAdapter(adapter);

        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), corngrit
                            .class);
                    startActivityForResult(myIntent, 0);
                } else {

                    String Slecteditem= itemname[+position];
                    Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                }

            }
        });


/*

        databaseSaveFood = FirebaseDatabase.getInstance().getReference("Recipe");
        listViewFood = (ListView) findViewById(R.id.listViewFood);

        foodList = new ArrayList<>();//iitialize
*/

    }
/*
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

                FoodList adapter = new FoodList(list_View.this, foodList);
                listViewFood.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
*/
    }


/*    <ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/listViewFood"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="24dp" />
*/

