package com.infs3634.cheffy;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import android.os.Bundle;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

//Establishes AchievementsActivity
public class AchievementsActivity extends AppCompatActivity {
    private String TAG = "AchievementsActivity";
    public TextView mLevel;
    public CircularImageView circleStar;
    public CircularImageView circleWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        mLevel = findViewById(R.id.tvLevel);
        circleStar = findViewById(R.id.circleStar);
        circleWorld = findViewById(R.id.circleWorld);
    }
}
