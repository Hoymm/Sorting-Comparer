package com.hoymm.root.sortingcomparer.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.hoymm.root.sortingcomparer.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void openStaticComparsionActivity(View view) {
        startActivity(getStaticComparsionIntent());
    }

    private Intent getStaticComparsionIntent(){
        return new Intent(this, StaticComparsionActivity.class);
    }
}
