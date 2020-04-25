package com.infs3634.cheffy;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import android.os.Bundle;
import android.widget.TextView;

public class AchievementsActivity extends AppCompatActivity {
    private String TAG = "AchievementsActivity";
    public TextView mLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        mLevel = findViewById(R.id.tvLevel);
    }
}
