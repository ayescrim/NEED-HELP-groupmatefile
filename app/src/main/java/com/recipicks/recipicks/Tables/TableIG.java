package com.recipicks.recipicks.Tables;

/**
 * Created by ADMINPC on 9/27/2017.
 */

public class TableIG {

    String ID;
    String IGname;
    String description;


    public TableIG(){


    }

    public TableIG(String ID, String IGname, String description) {
        this.ID = ID;
        this.IGname = IGname;
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public String getIGName() {
        return IGname;
    }

    public String getDescription() {
        return description;
    }
}
