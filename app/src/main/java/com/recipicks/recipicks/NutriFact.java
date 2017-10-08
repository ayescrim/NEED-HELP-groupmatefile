package com.recipicks.recipicks;



import java.io.Serializable;

public class NutriFact implements Serializable {
    Double servingSize;
    Double calories;
    Double calFromFat;
    Double totalFat;
    Double carbohydrates;
    Double dietaryFiber;
    Double protein;
    Double vitA;
    Double vitC;
    Double calcium;
    Double iron;



    public NutriFact(){
        this.servingSize = 4.0;
        this.calories = 5.0;
        this.calFromFat = 6.0;
        this.totalFat = 7.0;
        this.carbohydrates = 8.0;
        this.dietaryFiber = 9.0;
        this.protein = 1.0;
        this.vitA = 22.0;
        this.vitC = 23.0;
        this.calcium = 24.0;
        this.iron = 10.0;
    }
    public void accumulate(Double servingSize, Double calories, Double calFromFat, Double totalFat, Double carbohydrates, Double dietaryFiber, Double protein, Double vitA, Double vitC, Double calcium, Double iron) {
        this.servingSize = servingSize;
        this.calories = calories;
        this.calFromFat = calFromFat;
        this.totalFat = totalFat;
        this.carbohydrates = carbohydrates;
        this.dietaryFiber = dietaryFiber;
        this.protein = protein;
        this.vitA = vitA;
        this.vitC = vitC;
        this.calcium = calcium;
        this.iron = iron;


    }

    public Double getServingSize() {
        return this.servingSize;
    }

    public Double getCalories() {
        return this.calories;
    }

    public Double getCalFromFat() {
        return this.calFromFat;
    }

    public Double getTotalFat() {
        return this.totalFat;
    }

    public Double getCarbohydrates() {
        return this.carbohydrates;
    }

    public Double getDietaryFiber() {
        return this.dietaryFiber;
    }

    public Double getProtein() {
        return this.protein;
    }

    public Double getVitA() {
        return this.vitA;
    }

    public Double getVitC() {
        return vitC;
    }

    public Double getCalcium() {
        return calcium;
    }

    public Double getIron() {
        return iron;
    }
}