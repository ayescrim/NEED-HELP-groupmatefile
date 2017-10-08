package com.recipicks.recipicks;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ADMINPC on 8/16/2017.
 */

    public class IngredientList extends ArrayAdapter<RecipeIngredient> {
        private Activity context;
        private List<RecipeIngredient> ingredientList;

        public IngredientList(Activity context, List<RecipeIngredient> ingredientList){
            super(context, R.layout.list_layout, ingredientList);
            this.context = context;
            this.ingredientList = ingredientList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();

            View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

            TextView textViewNumber = (TextView) listViewItem.findViewById(R.id.textViewNumber);
            TextView textViewMeasure = (TextView) listViewItem.findViewById(R.id.textViewMeasure);
            TextView textViewFood = (TextView) listViewItem.findViewById(R.id.textViewFood);

            RecipeIngredient recipeIngredient = ingredientList.get(position);

            textViewNumber.setText(String.valueOf(recipeIngredient.getNumber()));
            textViewMeasure.setText(recipeIngredient.getMeasure());
            textViewFood.setText(recipeIngredient.getFood());

            return listViewItem;
        }
    }

