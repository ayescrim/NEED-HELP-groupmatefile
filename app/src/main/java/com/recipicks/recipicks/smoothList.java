package com.recipicks.recipicks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class smoothList extends AppCompatActivity {


    ArrayList<String> list_name = new ArrayList<>();
    ArrayList<String> list_desc = new ArrayList<>();
    ArrayList<String> list_image = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_list);



        listView = (ListView) findViewById(R.id.listView);

        list_name.add("Corn Grit(Yellow)");
        list_name.add("Corn Grit(White)");
        list_name.add("Flattened Rice");
        list_name.add("Milled Rice");
        list_name.add("Milled Rice(Malagkit)");
        list_name.add("Bread(Brown)");
        list_name.add("Sotanghon");
        list_name.add("Bihon");
        list_name.add("Canton");
        list_name.add("Mami noodles");
        list_name.add("Misua noodles");
        list_name.add("Boiled Potato");
        list_name.add("Sweet Potato");
        list_name.add("French Fries");


        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");
        list_desc.add("Pinoy Food");

        list_image.add("https://s-media-cache-ak0.pinimg.com/736x/0a/b3/65/0ab365ad80434ac1c80711c21f97767f--cream-style-corn-corn-grits.jpg");
        list_image.add("http://authorjaneward.files.wordpress.com/2012/09/img_6936.jpg");
        list_image.add("http://food.iskcondesiretree.com/wp-content/uploads/2011/07/poha-674944.jpg");
        list_image.add("https://www.gipsa.usda.gov/fgis/commgallery/Commodities/rice_milled_big.jpg");
        list_image.add("https://upload.wikimedia.org/wikipedia/commons/a/aa/Chapssal_%28glutinous_rice%29.jpg");
        list_image.add("https://cdn1.healthambition.com/wp-content/uploads/2017/02/28094304/imag2.jpg");
        list_image.add("https://usercontent1.hubstatic.com/5887978_f1024.jpg");
        list_image.add("http://www.whats4eats.com/files/pastas-pancit-bihon-flickr-dbgg1979-3852511838-4x3.jpg");
        list_image.add("http://www.angsarap.net/wp-content/uploads/2015/09/Pancit-Canton-Wide.jpg");
        list_image.add("http://town.hallohallo.com/images/detailed/15/MAMI.jpg?t=1458525291");
        list_image.add("https://i0.wp.com/salu-salo.com/wp-content/uploads/2016/05/Misua-Soup-with-Ground-Pork-2.jpg?resize=600%2C400");
        list_image.add("https://www.storyofcooks.com/wp-content/uploads/2015/10/boiled-potato.jpg");
        list_image.add("http://i.huffpost.com/gen/1327631/images/o-SLICED-SWEET-POTATO-facebook.jpg");
        list_image.add("https://cdn.potatopro.com/cdn/farfuture/JHyuloN9w_v4NBD7TkfmaZfWN6i49VrlsfspygR2J5Y/mtime:1495749506/sites/default/files/pictures/french-fries-1200.jpg");

        ListAdapter adapter = new ListAdapter(smoothList.this,list_name,list_desc,list_image);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                if (position == 0) {

                    //Intent myIntent = new Intent(view.getContext(), corngrit.class);
                    Intent myIntent = new Intent(view.getContext(), OnclickRecipe.class);

                    startActivityForResult(myIntent, 0);

                }
            }
        });

    }
}
