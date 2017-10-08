package com.recipicks.recipicks;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.recipicks.recipicks.Tables.Procedures;

import java.util.List;

/**
 * Created by ADMINPC on 10/4/2017.
 */

public class PList extends ArrayAdapter<Procedures> {

    private Activity context;
    private List<Procedures> pList;

    public PList(Activity context,List<Procedures> pList){
        super(context, R.layout.procedure_layout, pList);
        this.context = context;
        this.pList = pList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItems = inflater.inflate(R.layout.procedure_layout,null,true);

        TextView textViewProcedure = (TextView) listViewItems.findViewById(R.id.textViewProcedure);
        TextView textViewProname = (TextView) listViewItems.findViewById(R.id.textViewProname);

        Procedures procedure = pList.get(position);

        textViewProcedure.setText(procedure.getPreparation());
        textViewProname.setText(procedure.getProname());

        return listViewItems;
    }
}
