package com.recipicks.recipicks.Tables;

/**
 * Created by ADMINPC on 7/25/2017.
 */

public class IngredientsTable {


    String IngredientID;
    String Ingredientname;
    String description;

    public IngredientsTable(){


    }

    public IngredientsTable(String ingredientID, String ingredientname, String description) {
        IngredientID = ingredientID;
        Ingredientname = ingredientname;
        this.description = description;
    }

    public String getIngredientID() {
        return IngredientID;
    }

    public String getIngredientname() {
        return Ingredientname;
    }

    public String getDescription() {
        return description;
    }
}
