package com.hoymm.root.sortingcomparer;

import android.app.Activity;
import android.os.Bundle;

public class StaticComparsionActivity extends Activity {
    ChartOptionsAndDisplaying chartOptionsAndDisplaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_comparsion);
        chartOptionsAndDisplaying = new ChartOptionsAndDisplaying(this);
    }
}
