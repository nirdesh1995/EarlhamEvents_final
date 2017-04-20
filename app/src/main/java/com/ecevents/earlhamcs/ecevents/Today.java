package com.ecevents.earlhamcs.ecevents;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Today extends AppCompatActivity {
    String JSON_STRING;
    String json_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        class BackgroundTask extends AsyncTask<Void, Void, String> {
            String json_url;

            @Override
            protected void onPreExecute() {
                json_url = "https://earlhamcs.000webhostapp.com/android_day.php";
            }


            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url = new URL(json_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((JSON_STRING = bufferedReader.readLine()) != null) {
                        stringBuilder.append(JSON_STRING + "\n");
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuilder.toString().trim();
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            public void onPostExecute(String result) {
                //TextView textView = (TextView) findViewById(R.id.textview);
                //textView.setText(result);
                json_string = result;
                //Intent intent = new Intent(this,DisplayListView.class);
                //intent.putExtra("json_data", json_string);
                //startActivity(intent);
            }

        }
        new BackgroundTask().execute();
    }


    public void parseJSON(View view) {
        if (json_string == null) {
            Toast.makeText(getApplicationContext(), "First get JSOn", Toast.LENGTH_LONG).show();

        } else {
            Intent intent = new Intent(this, DisplayListView.class);
            intent.putExtra("json_data", json_string);
            startActivity(intent);

        }
    }

}