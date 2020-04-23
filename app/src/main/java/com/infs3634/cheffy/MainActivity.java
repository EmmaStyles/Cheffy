package com.infs3634.cheffy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.timqi.sectorprogressview.ColorfulRingProgressView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Button recipeButton;
    private ColorfulRingProgressView crpv;
    public static final String EXTRA_MESSAGE = "com.infs3634.cheffy.MESSAGE";
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.btnGoals);
        recipeButton = findViewById(R.id.recipesButton);
        crpv = findViewById(R.id.crpv);
        // finish percent of progress
        int count = Goal.countCheckedGoals();
        crpv.setPercent(count);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                launchDetailActivity("GoalMainActivity");
            }
        });

        recipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                launchRecipesActivity("MealsMainActivity");
            }
        });


    }

    private void launchDetailActivity(String message){
        Intent intent = new Intent(this, GoalMainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void launchRecipesActivity(String message){
        Intent intent = new Intent(this, MealsMainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
