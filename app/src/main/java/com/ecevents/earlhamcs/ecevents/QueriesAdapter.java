package com.ecevents.earlhamcs.ecevents;

/**
 * Created by nirdeshbhandari on 4/05/17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class QueriesAdapter extends ArrayAdapter
{
    List list = new ArrayList();
    public QueriesAdapter(Context context, int resource){
        super(context, resource);
    }


    public void add(Queries object){
        super.add(object);
        list.add(object);


    }

    @Override
    public int getCount(){
        return list.size();

    }
    @Override
    public Object getItem(int position){
        return list.get(position);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        QueriesHolder queriesHolder;

        if (row == null )
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent,false);
            queriesHolder = new QueriesHolder();


            queriesHolder.tx_event_id = (TextView) row.findViewById(R.id.tx_event_id);
            queriesHolder.tx_title = (TextView) row.findViewById(R.id.tx_title);
            queriesHolder.tx_location = (TextView) row.findViewById(R.id.tx_location);
            queriesHolder.tx_c_person = (TextView) row.findViewById(R.id.tx_c_person);
            queriesHolder.tx_email = (TextView) row.findViewById(R.id.tx_email);
            queriesHolder.tx_odate = (TextView) row.findViewById(R.id.tx_odate);
            queriesHolder.tx_date = (TextView) row.findViewById(R.id.tx_date);
            queriesHolder.tx_time = (TextView) row.findViewById(R.id.tx_time);
            queriesHolder.tx_description = (TextView) row.findViewById(R.id.tx_description);

            row.setTag(queriesHolder);
        }
        else{
            queriesHolder = (QueriesHolder)row.getTag();
        }

        Queries queries = (Queries)this.getItem(position);


        queriesHolder.tx_event_id.setText(queries.getEvent_id());
        queriesHolder.tx_title.setText(queries.getTitle());
        queriesHolder.tx_location.setText(queries.getLocation());
        queriesHolder.tx_c_person.setText(queries.getC_person());
        queriesHolder.tx_email.setText(queries.getEmail());
        queriesHolder.tx_odate.setText(queries.getOdate());
        queriesHolder.tx_date.setText(queries.getDate());
        queriesHolder.tx_time.setText(queries.getTime());
        queriesHolder.tx_description.setText(queries.getDescription());


        return row;
    }

    static class QueriesHolder
    {
        TextView tx_event_id, tx_title, tx_location, tx_c_person, tx_email, tx_odate, tx_date, tx_time, tx_description;


 }
}
