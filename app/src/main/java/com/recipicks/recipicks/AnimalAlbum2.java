package com.recipicks.recipicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAlbum2 extends AppCompatActivity {


    private final String image_titles2[] = {


            "Granny Liver",
            "Liver Meat Balls",
            "Beef Liver & Onions with White Wine",
            "Ultimate Beef & Liver Chili",
            "Rosemary & Garlic Beef Liver Appetizer",
            "Beef Liver with Caramelized Peaches and Onion Compote",
            "Pan Seared Beef Liver & Onions",
            "Baked Liver & Onions with Bacon"


    };

    private final Integer image_ids2[] = {

            R.drawable.grannyliver,
            R.drawable.livermeatballs,
            R.drawable.beefliveronionswithwhitewine,
            R.drawable.liverchili,
            R.drawable.rosemarieliver,
            R.drawable.beeflivecaramelized,
            R.drawable.searedliver,
            R.drawable.bakedliver

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_album3);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery2);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell2> cells2 = prepareData();
        CellAdapter2 adapter2 = new CellAdapter2(getApplicationContext(),cells2);
        recyclerView.setAdapter(adapter2);


    }

    private ArrayList<Cell2> prepareData(){

        ArrayList<Cell2> theimage2 = new ArrayList<>();
        for (int i = 0; i < image_titles2.length; i++){

            Cell2 cell2 = new Cell2();
            cell2.setTitleAnimal2(image_titles2[i]);
            cell2.setImg2(image_ids2[i]);
            theimage2.add(cell2);
        }
        return theimage2;
    }

}
