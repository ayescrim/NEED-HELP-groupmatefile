package com.recipicks.recipicks.Tables;

/**
 * Created by ADMINPC on 7/25/2017.
 */

public class RecipeIngredientTableData {

    String name;
    String RecipeID;
    String IngredientID;


    public RecipeIngredientTableData(){


    }

    public RecipeIngredientTableData(String name, String recipeID, String ingredientID) {
        this.name = name;
        RecipeID = recipeID;
        IngredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public String getRecipeID() {
        return RecipeID;
    }

    public String getIngredientID() {
        return IngredientID;
    }
}
