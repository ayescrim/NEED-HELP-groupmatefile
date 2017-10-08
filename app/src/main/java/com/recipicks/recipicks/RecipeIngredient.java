package com.recipicks.recipicks;


public class RecipeIngredient {
    Double number;
    String measure;
    String food;

    public RecipeIngredient(){

    }

    public RecipeIngredient(Double number, String measure, String food) {
        this.number = number;
        this.measure = measure;
        this.food = food;
    }

    public Double getNumber() {
        return number;
    }

    public String getMeasure() {
        return measure;
    }

    public String getFood() {
        return food;
    }
}