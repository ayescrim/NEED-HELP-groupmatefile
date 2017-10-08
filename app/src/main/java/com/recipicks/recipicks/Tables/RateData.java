package com.recipicks.recipicks.Tables;

import android.provider.Telephony;

/**
 * Created by ADMINPC on 8/15/2017.
 */

public class RateData {

    String rate_no;
    String Recipe_ID;


    public RateData(){


    }

    public RateData(String rate_no, String recipe_ID) {
        this.rate_no = rate_no;
        Recipe_ID = recipe_ID;
    }


    public String getRate_no() {
        return rate_no;
    }

    public String getRecipe_ID() {
        return Recipe_ID;
    }
}
