package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        NutriFact nutriFactCal = (NutriFact)i.getSerializableExtra("NutritionalReview");
        TextView serveValue = (TextView) findViewById(R.id.serveValue);
        serveValue.setText(String.valueOf(nutriFactCal.getServingSize()));
//calories
        TextView calValue = (TextView) findViewById(R.id.calValue);
        calValue.setText(String.valueOf(nutriFactCal.getCalcium()));

//calories from fat
        TextView calFromFatValue = (TextView) findViewById(R.id.calFromFatValue);
        calFromFatValue.setText(String.valueOf(nutriFactCal.getCalFromFat()));
//total fat
        TextView fatValue = (TextView) findViewById(R.id.fatValue);
        fatValue.setText(String.valueOf(nutriFactCal.getTotalFat()));
//total carbohydrate
        TextView carbValue = (TextView) findViewById(R.id.carbValue);
        carbValue.setText(String.valueOf(nutriFactCal.getCarbohydrates()));
//dietary fiber
        TextView dietaryFiberValue = (TextView) findViewById(R.id.dietaryFiberValue);
        dietaryFiberValue.setText(String.valueOf(nutriFactCal.getDietaryFiber()));
//protein
        TextView proteinValue = (TextView) findViewById(R.id.proteinValue);
        proteinValue.setText(String.valueOf(nutriFactCal.getProtein()));
//vitaminA
        TextView vitAValue = (TextView) findViewById(R.id.vitAValue);
        vitAValue.setText(String.valueOf(nutriFactCal.getVitA()));
//vitaminC
        TextView vitCValue = (TextView) findViewById(R.id.vitCValue);
        vitCValue.setText(String.valueOf(nutriFactCal.getVitC()));
//iron
        TextView ironValue = (TextView) findViewById(R.id.ironValue);
        ironValue.setText(String.valueOf(nutriFactCal.getIron()));
//calcium
        TextView calciumValue = (TextView) findViewById(R.id.calciumValue);
        calciumValue.setText(String.valueOf(nutriFactCal.getCalcium()));

    }

};