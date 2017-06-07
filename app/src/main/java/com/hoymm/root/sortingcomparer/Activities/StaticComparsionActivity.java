package com.hoymm.root.sortingcomparer.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.hoymm.root.sortingcomparer.ChartHandlingClasses.ChartOptionsAndDisplaying;
import com.hoymm.root.sortingcomparer.R;

public class StaticComparsionActivity extends Activity {
    ChartOptionsAndDisplaying chartOptionsAndDisplaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_static_comparsion);
        chartOptionsAndDisplaying = new ChartOptionsAndDisplaying(this);
    }
}
