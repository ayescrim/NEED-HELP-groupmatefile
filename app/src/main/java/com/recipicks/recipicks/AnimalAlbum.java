package com.recipicks.recipicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAlbum extends AppCompatActivity {


    private final String image_titles[] = {


            "Cow Liver",
            "Cow Tounge",
            "Cow Chuck",
            "Cow Ribs",
            "Cow Shank",
            "Cow Tenderloin",
            "Cow Flank"



    };

    private final Integer image_ids[] = {

            R.drawable.cowliverraw,
            R.drawable.beeftounge,
            R.drawable.chuckcut,
            R.drawable.cowribs,
            R.drawable.beefshank,
            R.drawable.beeftenderloin,
            R.drawable.beefflank


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_album);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell> cells = prepareData();
        CellAdapter adapter = new CellAdapter(getApplicationContext(),cells);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Cell> prepareData(){

        ArrayList<Cell> theimage = new ArrayList<>();

        for (int i = 0; i < image_titles.length; i++){

            Cell cell = new Cell();
            cell.setTitle(image_titles[i]);
            cell.setImg(image_ids[i]);
            theimage.add(cell);
        }
        return theimage;
    }
}
