package com.ecevents.earlhamcs.ecevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    QueriesAdapter queriesAdapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_list_view);
        listView = (ListView)findViewById(R.id.listview);



        queriesAdapter = new QueriesAdapter(this,R.layout.row_layout);
        listView.setAdapter(queriesAdapter);
        json_string = getIntent().getExtras().getString("json_data");


        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = new JSONObject(json_string).getJSONArray("event");
            int count = 0;
            String event_id, title,location ,c_person,email,odate ,date,time,description;

            while(count<jsonObject.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);

                event_id = JO.getString("event_id");
                title = JO.getString("title");
                location = JO.getString("location");
                c_person = JO.getString("c_person");
                email = JO.getString("email");
                odate= JO.getString("odate");
                date = JO.getString("date");
                time = JO.getString("time");
                description = JO.getString("description");

                Queries queries = new Queries(event_id, title, location, c_person, email, odate, date, time, description );
                queriesAdapter.add(queries);
                count++;
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
