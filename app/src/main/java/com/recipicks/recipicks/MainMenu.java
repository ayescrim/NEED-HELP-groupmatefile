package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void allrecipes(View view) {

        Intent proceeds = new Intent(MainMenu.this, smoothList.class);
        //Intent proceeds = new Intent(ProfileActivity.this, RecipeIngredient.class);
        //Intent proceeds = new Intent(ProfileActivity.this, swipetab.class);
        proceeds.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(proceeds);
    }

    public void categories(View view) {

        Intent proceeds = new Intent(MainMenu.this, ClickAnimal.class);
        //Intent proceeds = new Intent(MainMenu.this, TableForIG.class);
        //Intent proceeds = new Intent(ProfileActivity.this, swipetab.class);
        startActivity(proceeds);
    }


    public void add(View view) {

        Intent proceeds = new Intent(MainMenu.this, Main3Activity.class);
        //Intent proceeds = new Intent(MainMenu.this, dataAddingActivity.class);
        //Intent proceeds = new Intent(ProfileActivity.this, swipetab.class);
        //Intent proceeds = new Intent(MainMenu.this, ProcedureTable.class);
        startActivity(proceeds);
    }
}
