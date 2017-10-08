package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class compute extends AppCompatActivity {

    EditText numText;
    EditText foodText;
    Button addButton;
    Button nutriShow;
    Spinner spinnerMeasure;
    Double tempServeValue;
    Double tempCalVal;
    Double tempCalFromFatValue;
    Double tempFatValue;
    Double tempCarbValue;
    Double tempDietaryFiberValue;
    Double tempProteinValue;
    Double tempVitAValue;
    Double tempVitCValue;
    Double tempIronValue;
    Double tempCalciumValue;
    Double number;
    Double newMeasure;
    String food;
    String measure;
    DatabaseReference databaserecipeIngredient;


    ListView listViewIngredient;
    List<RecipeIngredient> recipeIngredientList;
    NutriFact nutriFactCal = new NutriFact();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

        databaserecipeIngredient = FirebaseDatabase.getInstance().getReference("recipeIngredients");


        numText = (EditText) findViewById(R.id.numText);
        foodText = (EditText) findViewById(R.id.foodText);
        spinnerMeasure = (Spinner) findViewById(R.id.spinnerMeasure);
        addButton = (Button) findViewById(R.id.addButton);
        nutriShow = (Button) findViewById(R.id.nutriShow);
        listViewIngredient = (ListView) findViewById(R.id.listViewIngredient);

        recipeIngredientList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addrecipeIngredient();
                addNutriFact();
            }
        });


        nutriShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(compute.this, Main2Activity.class);
                i.putExtra("NutritionalReview", nutriFactCal);
                startActivity(i);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        databaserecipeIngredient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                recipeIngredientList.clear();

                for(DataSnapshot recipeIngredientSnapshot : dataSnapshot.getChildren()){
                    RecipeIngredient recipeIngredient = recipeIngredientSnapshot.getValue(RecipeIngredient.class);

                    recipeIngredientList.add(recipeIngredient);
                }

                IngredientList adapter = new IngredientList(compute.this, recipeIngredientList);
                listViewIngredient.setAdapter(adapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addrecipeIngredient(){

        number = Double.parseDouble(numText.getText().toString().trim());
        food = foodText.getText().toString().trim();
        measure = spinnerMeasure.getSelectedItem().toString();

        if((number >= 0.0) && (!TextUtils.isEmpty(food))) {
            //if ((number != 0) && (!TextUtils.isEmpty(food))) {
            String id = databaserecipeIngredient.push().getKey();

            RecipeIngredient recipeIngredient = new RecipeIngredient(number, measure, food);

            databaserecipeIngredient.child(id).setValue(recipeIngredient);

            Toast.makeText(this, "ingredient Added", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Missing Fields Required", Toast.LENGTH_LONG).show();
        }

    }


    private void addNutriFact() {

        if ((number >=  0.0) && (!TextUtils.isEmpty(food))) {
            //((number * measure) * (food nutri / 100g))

            initializeIngredient();
            newMeasure = computeConversion();
            calculateIngredient();


        }


    }
    public void initializeIngredient(){
        tempServeValue = 0.0;
        tempCalVal = 0.0;
        tempCalFromFatValue = 0.0;
        tempFatValue = 0.0;
        tempCarbValue = 0.0;
        tempDietaryFiberValue = 0.0;
        tempProteinValue = 0.0;
        tempVitAValue = 0.0;
        tempVitCValue = 0.0;
        tempIronValue = 0.0;
        tempCalciumValue = 0.0;
    }

    public void calculateIngredient(){
        //serving size
        tempServeValue = tempServeValue + (number * newMeasure);

        //calories
        tempCalVal = (tempCalVal + ((number * newMeasure) * (nutriFactCal.getCalories() / 100)));

        //calories from fat
        tempCalFromFatValue = (tempCalFromFatValue + ((number * newMeasure) * (nutriFactCal.getCalFromFat() / 100)));

        //total fat
        tempFatValue = (tempFatValue + ((number * newMeasure) * (nutriFactCal.getTotalFat() / 100)));

        //total carbohydrate
        tempCarbValue = (tempCarbValue + ((number * newMeasure) * (nutriFactCal.getCarbohydrates() / 100)));

        //dietary fiber
        tempDietaryFiberValue = (tempDietaryFiberValue + ((number * newMeasure) * (nutriFactCal.getDietaryFiber() / 100 )));

        //protein
        tempProteinValue = (tempProteinValue + ((number * newMeasure) * (nutriFactCal.getProtein() / 100)));

        //vitaminA
        tempVitAValue = (tempVitAValue + ((number * newMeasure) * (nutriFactCal.getVitA() / 100)));

        //vitaminC
        tempVitCValue = (tempVitCValue + ((number * newMeasure) * (nutriFactCal.getVitC() / 100)));

        //iron
        tempIronValue = (tempIronValue + ((number * newMeasure) * (nutriFactCal.getIron() / 100)));

        //calcium
        tempCalciumValue = (tempCalciumValue + ((number * newMeasure) * (nutriFactCal.getCalcium() / 100)));

        nutriFactCal.accumulate(tempServeValue,tempCalVal, tempCalFromFatValue,tempFatValue,tempCarbValue, tempDietaryFiberValue, tempProteinValue, tempVitAValue, tempVitCValue, tempIronValue,tempCalciumValue );
    }

    public double computeConversion(){
        if (measure == "pinch"){
            return 0.2;
        } else if (measure == "tsp") {
            return 4.0;
        } else if (measure == "tbsp") {
            return 14.0;
        } else if (measure == "gram") {
            return 100.0;
        } else if (measure == "kilo") {
            return 1000.0;
        }
//not found
        return 0.0;
    }


}