package com.hoymm.root.sortingcomparer.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.sortingcomparer.ChartHandlingClasses.ChartOptionsAndDisplaying;
import com.hoymm.root.sortingcomparer.R;

public class StaticComparsionActivity extends AppCompatActivity {
    ChartOptionsAndDisplaying chartOptionsAndDisplaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_comparsion);
        chartOptionsAndDisplaying = new ChartOptionsAndDisplaying(this);
    }
}
