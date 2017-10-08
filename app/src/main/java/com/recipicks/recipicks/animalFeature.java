package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class animalFeature extends AppCompatActivity {


    ArrayList<String> animal_name = new ArrayList<>();
    ArrayList<String> animal_desc = new ArrayList<>();
    ArrayList<String> list_image = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_list);



        listView = (ListView) findViewById(R.id.listView);


        animal_name.add("Chicken");
        animal_name.add("Cow");
        animal_name.add("Carabao");

        animal_desc.add("Pinoy Food");
        animal_desc.add("Pinoy Food");
        animal_desc.add("Pinoy Food");


        list_image.add("http://www.prevention.com/sites/prevention.com/files/images/news/featured_images/raw-roasting-chicken-628x363.jpg");
        list_image.add("https://d1pra95f92lrn3.cloudfront.net/media/thumb/21806_fit512.jpg");
        list_image.add("https://previews.123rf.com/images/lirtlon/lirtlon1210/lirtlon121000002/15540091-Carabao-isolated-on-white-background-Stock-Photo-buffalo-carabao.jpg");


        ListAdapter adapter = new ListAdapter(animalFeature.this,animal_name,animal_desc,list_image);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), corngrit
                            .class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });

    }
}
