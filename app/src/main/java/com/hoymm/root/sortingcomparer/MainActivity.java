package com.hoymm.root.sortingcomparer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openStaticComparsionActivity(View view) {
        startActivity(getStaticComparsionIntent());
    }

    private Intent getStaticComparsionIntent(){
        return new Intent(this, StaticComparsionActivity.class);
    }
}
