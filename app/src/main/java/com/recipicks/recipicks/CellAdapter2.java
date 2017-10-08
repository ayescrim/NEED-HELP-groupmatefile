package com.recipicks.recipicks;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADMINPC on 10/2/2017.
 */

public class CellAdapter2 extends RecyclerView.Adapter<CellAdapter2.ViewHolder> {

    private ArrayList<Cell2> gallerylist2;
    private Context context;

    public CellAdapter2(Context context, ArrayList<Cell2> gallerylist2){

        this.gallerylist2 = gallerylist2;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CellAdapter2.ViewHolder viewHolder, final int i){
        viewHolder.titleAnimal2.setText(gallerylist2.get(i).getTitleAnimal2());
        viewHolder.img2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img2.setImageResource(gallerylist2.get(i).getImg2());
        viewHolder.img2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                if (i == 0){

                    Intent intent = new Intent(view.getContext(), corngrit.class);
                    view.getContext().startActivity(intent);

                }
            }

        });
    }

    @Override
    public int getItemCount(){

        return gallerylist2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleAnimal2;
        private ImageView img2;

        public ViewHolder(View view){

            super(view);

            titleAnimal2 = (TextView) view.findViewById(R.id.titleAnimal2);
            img2 = (ImageView) view.findViewById(R.id.img2);

        }

    }
}
