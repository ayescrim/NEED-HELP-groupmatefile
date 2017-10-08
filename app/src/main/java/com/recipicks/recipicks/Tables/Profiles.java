package com.recipicks.recipicks.Tables;

/**
 * Created by ADMINPC on 7/16/2017.
 */

public class Profiles {

    String userName;
    String userAge;



    public Profiles(){


    }

    public Profiles(String userName, String userAge) {//constructors
        this.userName = userName;
        this.userAge = userAge;
    }

    public String getUserName() {// to read values
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }
}
