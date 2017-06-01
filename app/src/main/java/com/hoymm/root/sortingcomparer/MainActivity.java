package com.hoymm.root.sortingcomparer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openStaticComparsionActivity(View view) {
        startActivity(StaticComparsionActivity.getNewIntent(this));
        closeCurrentActivityScreen();
    }

    private void closeCurrentActivityScreen() {
        finish();
    }
}
