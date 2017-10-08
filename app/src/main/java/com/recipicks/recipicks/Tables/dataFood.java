package com.recipicks.recipicks.Tables;

/**
 * Created by ADMINPC on 7/20/2017.
 */

public class dataFood {

    String RecipeID;
    String foodName;
    String caloriesFat;
    String fcalcium;
    String firon;
    String ffiber;
    String fvitamA;
    String fvitamC;
    String fcarbohydrate;
    String fcalories;
    String ffat;


public dataFood(){


}

    public dataFood(String RecipeID,String foodName, String caloriesFat, String fcalcium, String firon, String ffiber, String fvitamA, String fvitamC, String fcarbohydrate, String fcalories, String ffat) {

        this.RecipeID = RecipeID;
        this.foodName = foodName;
        this.caloriesFat = caloriesFat;
       this.fcalcium = fcalcium;
        this.firon = firon;
        this.ffiber = ffiber;
        this.fvitamA = fvitamA;
        this.fvitamC = fvitamC;
        this.fcarbohydrate = fcarbohydrate;
        this.fcalories = fcalories;
        this.ffat = ffat;



    }

    public String getRecipeID() { return  RecipeID; }

    public String getFoodName() {//to read values
        return foodName;
    }

    public String getCaloriesFat() {
        return caloriesFat;
    }

   public String getFcalcium() {
        return fcalcium;
    }

    public String getFiron() {
        return firon;
    }

    public String getFfiber() {
        return ffiber;
    }

    public String getFvitamA() {
        return fvitamA;
    }

    public String getFvitamC() {
        return fvitamC;
    }

    public String getFcarbohydrate() {
        return fcarbohydrate;
    }

    public String getFcalories() {
        return fcalories;
    }

    public String getFfat() {
        return ffat;
    }



}


