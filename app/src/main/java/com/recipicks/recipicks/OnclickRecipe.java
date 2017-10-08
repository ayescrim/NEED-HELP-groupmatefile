package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OnclickRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick_recipe);
    }

    public void shownutri(View view) {

        Intent proceeds = new Intent(OnclickRecipe.this, corngrit.class);
        //Intent proceeds = new Intent(ProfileActivity.this, RecipeIngredient.class);
        //Intent proceeds = new Intent(ProfileActivity.this, swipetab.class);
        startActivity(proceeds);
    }

    public void showprocedure(View view){

        Intent procedureadd = new Intent(OnclickRecipe.this, Main3Activity.class);

        startActivity(procedureadd);
    }

    public void showingredients(View view){

        //Intent nutris = new Intent(OnclickRecipe.this, compute.class);

        Intent nutris = new Intent(OnclickRecipe.this, IGonClick.class);

        startActivity(nutris);

    }
}
