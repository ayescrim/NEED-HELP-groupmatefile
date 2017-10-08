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

public class IngredientTable extends AppCompatActivity {

    EditText EditIngredient;
    EditText editDescrip;
    Button ButtonaddIngredients;

    DatabaseReference databaseIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_table);

        databaseIngredient = FirebaseDatabase.getInstance().getReference("Ingredients");

        EditIngredient = (EditText) findViewById(R.id.EditIngredient);
        editDescrip = (EditText) findViewById(R.id.editDescrip);

        ButtonaddIngredients = (Button) findViewById(R.id.addIngredient);

        ButtonaddIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProcedureAdd();
            }
        });
    }

    private void ProcedureAdd(){
        String name = EditIngredient.getText().toString().trim();
        String descrip = editDescrip.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){

            String id = databaseIngredient.push().getKey();

            IngredientsTable Ingredients = new IngredientsTable(id,name,descrip);
            databaseIngredient.child(id).setValue(Ingredients);

            Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show();

        } else if(!TextUtils.isEmpty(descrip)) {

            String id = databaseIngredient.push().getKey();

            IngredientsTable Ingredients = new IngredientsTable(id,name,descrip);
            databaseIngredient.child(id).setValue(Ingredients);

            Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, "PUT SOMETHInG", Toast.LENGTH_LONG).show();
        }

    }

}
