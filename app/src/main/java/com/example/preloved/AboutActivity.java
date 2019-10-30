package com.example.preloved;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("About Preloved");
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
