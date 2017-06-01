package com.hoymm.root.sortingcomparer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StaticComparsionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_comparsion);
    }

    public static Intent getNewIntent(Context context){
        return new Intent(context, StaticComparsionActivity.class);
    }
}
