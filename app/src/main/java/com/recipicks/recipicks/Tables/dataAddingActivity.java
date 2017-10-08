package com.recipicks.recipicks.Tables;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.recipicks.recipicks.FoodList;
import com.recipicks.recipicks.R;

import java.util.ArrayList;
import java.util.List;

import static com.recipicks.recipicks.R.id.listViewFood;

public class dataAddingActivity extends AppCompatActivity {



    EditText editTextFood;
    EditText editTextFatc;
    EditText editTextCalc;
    EditText editTextFat;
    EditText editTextVita;
    EditText editTextVitc;
    EditText editTextCalo;
    EditText editTextCarbo;
    EditText editTextIron;
    EditText editTextFiber;


    Button saveFoodName;

    DatabaseReference databaseSaveFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_adding);

        databaseSaveFood = FirebaseDatabase.getInstance().getReference("Recipe");

        editTextFood = (EditText) findViewById(R.id.editTextFood);
        editTextFatc = (EditText) findViewById(R.id.editTextFatc);
        editTextCalc = (EditText) findViewById(R.id.editTextCalc);
        editTextFat = (EditText) findViewById(R.id.editTextFat);
        editTextVita = (EditText) findViewById(R.id.editTextVita);
        editTextVitc = (EditText) findViewById(R.id.editTextVitc);
        editTextCalo = (EditText) findViewById(R.id.editTextCalo);
        editTextCarbo = (EditText) findViewById(R.id.editTextCarbo);
        editTextIron = (EditText) findViewById(R.id.editTextIron);
        editTextFiber = (EditText) findViewById(R.id.editTextFiber);


        saveFoodName = (Button) findViewById(R.id.saveFood);



        saveFoodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    /*This method is to save a data to firebase*/

    private void addData(){
            //values to save
            String Foodname = editTextFood.getText().toString().trim();
            String FatCalories = editTextFatc.getText().toString().trim();
            String Calcium = editTextCalc.getText().toString().trim();
            String Fat = editTextFat.getText().toString().trim();
            String VitaminA = editTextVita.getText().toString().trim();
            String VitaminC = editTextVitc.getText().toString().trim();
            String Calories = editTextCalo.getText().toString().trim();
            String Carbohydrates = editTextCarbo.getText().toString().trim();
            String Iron = editTextIron.getText().toString().trim();
            String Fiber = editTextFiber.getText().toString().trim();

            //check if values are empty
            if(!TextUtils.isEmpty(Foodname)){
                //getting unieuqe Id using push and getkey, then creates a unique id
                String add = databaseSaveFood.push().getKey();
                //creating a food object
                dataFood fud = new dataFood(add, Foodname, FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);
                //Saving
                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            } else if(!TextUtils.isEmpty(FatCalories)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(Calcium)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(Fat)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(VitaminA)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(VitaminC)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(Calories)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(Carbohydrates)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(Iron)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }else if(!TextUtils.isEmpty(Fiber)) {

                String add = databaseSaveFood.push().getKey();

                dataFood fud = new dataFood(add,Foodname , FatCalories , Calcium , Fat , VitaminA , VitaminC , Calories , Carbohydrates , Iron ,Fiber);

                databaseSaveFood.child(add).setValue(fud);

                Toast.makeText(this, "added!" , Toast.LENGTH_LONG).show();

            }
            else {

                Toast.makeText(this, "Enter something!", Toast.LENGTH_LONG).show();
            }
        }
}

