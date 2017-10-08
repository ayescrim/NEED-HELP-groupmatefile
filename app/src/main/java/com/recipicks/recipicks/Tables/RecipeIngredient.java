package com.recipicks.recipicks.Tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.recipicks.recipicks.R;
import com.recipicks.recipicks.Tables.IngredientsTable;
import com.recipicks.recipicks.Tables.RecipeIngredientTableData;

public class RecipeIngredient extends AppCompatActivity {


    EditText editRecipeIngredient;
    Button addRecipeIngredients;
    DatabaseReference databaseRI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_ingredient);

        databaseRI = FirebaseDatabase.getInstance().getReference("RecipeIngredients");

        editRecipeIngredient = (EditText) findViewById(R.id.editRecipeIngredient);
        addRecipeIngredients = (Button) findViewById(R.id.addRecipeIngredient);

        addRecipeIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IngredientAdd();
            }
        });

    }

    private void IngredientAdd(){

        String name = editRecipeIngredient.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){

            String id = databaseRI.push().getKey();


            RecipeIngredientTableData RecipeIngredients = new RecipeIngredientTableData(name,id,id);
            databaseRI.child(id).setValue(RecipeIngredients);

            Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show();

        }  else {

            Toast.makeText(this, "PUT SOMETHInG", Toast.LENGTH_LONG).show();
        }
    }
}
