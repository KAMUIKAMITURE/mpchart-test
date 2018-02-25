package com.kamiture.kamui.mpchart_test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart chart = findViewById(R.id.chart);

        Data[] dataObjects = createDummy();
        List<Entry> entries = new ArrayList<Entry>();
        for(Data data : dataObjects){
            entries.add(new Entry(data.x, data.y));
        }
        LineDataSet dataSet = new LineDataSet(entries,"Label");
        dataSet.setColor(Color.BLACK);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }

    private Data[] createDummy() {
        int dataSize = 10;        // int dataX[] = new int [dataSize];
        // int dataY[] = new int [dataSize];
        Data[] data = new Data[dataSize];

        for (int i = 0; i < data.length; i++) {
            data[i] = new Data(i + 1, (i + 1) * 20);
        }

        return data;
    }

    class Data {
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
