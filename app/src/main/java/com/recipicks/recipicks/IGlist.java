package com.recipicks.recipicks;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.recipicks.recipicks.Tables.TableIG;

import java.util.List;

/**
 * Created by ADMINPC on 9/27/2017.
 */

public class IGlist extends ArrayAdapter<TableIG> {

    private Activity context;
    private List<TableIG> iglist;

    public IGlist(Activity context, List<TableIG> iglist){

        super(context, R.layout.iglayout, iglist);
        this.context = context;
        this.iglist = iglist;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewIG = inflater.inflate(R.layout.iglayout, null, true);

        TextView TVname = (TextView) listViewIG.findViewById(R.id.TVname);
        TextView TVdescription = (TextView) listViewIG.findViewById(R.id.TVdescription);

        TableIG ingredients = iglist.get(position);

        TVname.setText(ingredients.getIGName());
        TVdescription.setText(ingredients.getDescription());

        return listViewIG;
    }
}
