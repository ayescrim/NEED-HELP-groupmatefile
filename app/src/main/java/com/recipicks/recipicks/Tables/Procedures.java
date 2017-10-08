package com.recipicks.recipicks.Tables;

/**
 * Created by ADMINPC on 10/4/2017.
 */

public class Procedures {

    String procedureID;
    String preparation;
    String proname;

    public Procedures(){


    }

    public Procedures(String procedureID, String preparation, String proname) {
        this.procedureID = procedureID;
        this.preparation = preparation;
        this.proname = proname;
    }

    public String getProcedureID() {
        return procedureID;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getProname() {
        return proname;
    }
}
