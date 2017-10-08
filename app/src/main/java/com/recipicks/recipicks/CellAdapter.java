package com.recipicks.recipicks;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.recipicks.recipicks.R.id.img;

/**
 * Created by ADMINPC on 10/1/2017.
 */

public class CellAdapter extends RecyclerView.Adapter<CellAdapter.ViewHolder> {

    private ArrayList<Cell> galleryList;
    private Context context;

    public CellAdapter(Context context, ArrayList<Cell> galleryList){

        this.galleryList = galleryList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CellAdapter.ViewHolder viewHolder, final int i){

        viewHolder.titleAnimal.setText(galleryList.get(i).getTitle());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageResource(galleryList.get(i).getImg());
        viewHolder.img.setOnClickListener(new View.OnClickListener(){


           @Override
            public void onClick(View view){

              // Toast.makeText(context, "" + galleryList.get(i).getTitle(), Toast.LENGTH_SHORT).show();
               if (i == 0){

                   Intent intent = new Intent(view.getContext(), AnimalAlbum2.class);
                   view.getContext().startActivity(intent);

               }
           }

        });

    }

    @Override
    public int getItemCount(){

        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleAnimal;
        private ImageView img;
        public ViewHolder(View view){

            super(view);

            titleAnimal = (TextView) view.findViewById(R.id.titleAnimal);
            img = (ImageView) view.findViewById(R.id.img);
        }




    }
}
