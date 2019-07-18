package com.tranhuyson.canvasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String url = "https://api.openweathermap.org/data/2.5/forecast/daily?q=Paris&appid=211ff006de9aba9ddd122331f87cdf8b";
    private List<String> mListGraphDay;
    private JSONObject jsonObject;
    private JSONArray jsonArray;


    public static final String ARRAY_DATA = "DataGraph";
    public static final String BUNDLE = "bundle";
    TestCanvas testCanvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       testCanvas = findViewById(R.id.testCanvas);
        new DogetJsonGraphDay().execute(url);


    }


    class DogetJsonGraphDay extends AsyncTask<String, Void, List<String>> {
        private String result = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<String> doInBackground(String... strings) {
            try {
                URL urlHour = new URL(strings[0]);
                URLConnection urlConnectionHour = urlHour.openConnection();
                InputStream isHour = urlConnectionHour.getInputStream();
                int byteCharactorHour;
                while ((byteCharactorHour = isHour.read()) != -1) {
                    result += (char) byteCharactorHour;
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

            return ListDataGraphDay(result);

        }

        @Override
        protected void onPostExecute(List<String> graphDays) {
            super.onPostExecute(graphDays);

            testCanvas.getData(graphDays);


        }
    }


    private List<String> ListDataGraphDay(String json) {
        mListGraphDay = new ArrayList<>();

        try {

            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("list");
            int leght1 = jsonArray.length();
            for (int i = 0; i <= leght1; i++) {
                JSONObject job = jsonArray.getJSONObject(i);
                long time = job.getLong("dt");
                String sTime = new java.text.SimpleDateFormat("dd").format(new java.util.Date(time * 1000));
                jsonObject = job.getJSONObject("temp");
                double tempDay = jsonObject.getDouble("day");
                double tempDay1 = tempDay - 273.15;
                tempDay1 = Math.round(tempDay1);
                int tempDay2 = (int) tempDay1;


                mListGraphDay.add(sTime);
                mListGraphDay.add(String.valueOf(tempDay2));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListGraphDay;
    }

}


