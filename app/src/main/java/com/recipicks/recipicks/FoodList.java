package com.recipicks.recipicks;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.recipicks.recipicks.Tables.dataFood;

import java.util.List;

/**
 * Created by ADMINPC on 7/29/2017.
 */



public class FoodList extends ArrayAdapter<dataFood> {
    private Activity context;
    private List<dataFood> foodList;

    public FoodList(Activity context, List<dataFood> foodList){
        super(context,R.layout.listlayout, foodList);
        this.context = context;
        this.foodList = foodList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listlayout,null,true);

        TextView textSaveFood = (TextView) listViewItem.findViewById(R.id.textSaveFood);
        TextView textSaveCalcium = (TextView) listViewItem.findViewById(R.id.textSaveCalcium);
        TextView textSaveCaloriesFat = (TextView) listViewItem.findViewById(R.id.textSaveCaloriesFat);
        TextView textSaveFat = (TextView) listViewItem.findViewById(R.id.textSaveFat);
        TextView textSaveVitA = (TextView) listViewItem.findViewById(R.id.textSaveVitA);
        TextView textSaveVitC = (TextView) listViewItem.findViewById(R.id.textSaveVitC);
        TextView textSaveFatCalo = (TextView) listViewItem.findViewById(R.id.textSaveFatCalo);
        TextView textSaveCarbo = (TextView) listViewItem.findViewById(R.id.textSaveCarbo);
        TextView textSaveIro = (TextView) listViewItem.findViewById(R.id.textSaveIro);
        TextView textSaveFiber = (TextView) listViewItem.findViewById(R.id.textSaveFiber);


        dataFood foods = foodList.get(position);


        textSaveFood.setText(foods.getFoodName());
        textSaveCalcium.setText(foods.getFcalcium());
        textSaveCaloriesFat.setText(foods.getCaloriesFat());
        textSaveFat.setText(foods.getFfat());
        textSaveVitA.setText(foods.getFvitamA());
        textSaveVitC.setText(foods.getFvitamC());
        textSaveFatCalo.setText(foods.getFcalories());
        textSaveCarbo.setText(foods.getFcarbohydrate());
        textSaveIro.setText(foods.getFiron());
        textSaveFiber.setText(foods.getFfiber());

        return listViewItem;

    }


}
