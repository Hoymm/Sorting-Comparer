package com.hoymm.root.sortingcomparer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class StaticComparsionActivity extends Activity {
    ChartOptions chartOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_comparsion);
        chartDisplaying = new ChartDisplaying(this);
    }
}
