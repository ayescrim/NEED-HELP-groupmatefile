package com.recipicks.recipicks;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ADMINPC on 8/9/2017.
 */

public class animalFeatureAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> animal_name = new ArrayList<>();
    ArrayList<String> animal_desc = new ArrayList<>();
    ArrayList<String> list_image = new ArrayList<>();

    String image_url;

    static class ViewHolder{

        TextView name_text;
        TextView desc_text;
        ImageView image;

        int position;
    }

    public animalFeatureAdapter(Activity context, ArrayList<String> animal_name,ArrayList<String> animal_desc,ArrayList<String> list_image){

        super(context, R.layout.list_item,animal_name);

        this.context=context;
        this.animal_name = animal_name;
        this.animal_desc = animal_desc;
        this.list_image = list_image;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent){

        ViewHolder holder = new ViewHolder();

        if(view == null){

            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.list_item,parent,false);

            holder.name_text = (TextView) view.findViewById(R.id.animal_name);
            holder.desc_text = (TextView) view.findViewById(R.id.animal_desc);
            holder.image = (ImageView) view.findViewById(R.id.imageView5);

            view.setTag(holder);
        } else {

            holder= (ViewHolder) view.getTag();
        }

        try {

            holder.name_text.setText(animal_name.get(position));
            holder.desc_text.setText(animal_desc.get(position));

            Glide.with(context).load(list_image.get(position)).into(holder.image);
        } catch (Exception e) {


        }

        return view;
    }
}
