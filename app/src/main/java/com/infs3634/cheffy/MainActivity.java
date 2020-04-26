package com.infs3634.cheffy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.timqi.sectorprogressview.ColorfulRingProgressView;

import static com.infs3634.cheffy.Level.getLevels;

// Class for main activity of app
public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Button recipeButton;
    private Button achievementsButton;
    private ColorfulRingProgressView crpv;
    private TextView mLevel;
    public int levelCounter;
    public static final String EXTRA_MESSAGE = "com.infs3634.cheffy.MESSAGE";
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.btnGoals);
        recipeButton = findViewById(R.id.recipesButton);
        achievementsButton = findViewById(R.id.btnAchievements);
        mLevel = findViewById(R.id.tvLevel);
        //CRPV code from https://github.com/timqi/SectorProgressView.git
        crpv = findViewById(R.id.crpv);

        //To set graph and level on main activity

        //This was used to get the number of goals completed, but couldn't get it to work
        //levelCounter = Goal.countCheckedGoals();

        //******FEEL FREE TO CHANGE LEVELCOUNTER TO SEE DIFFERENT LEVELS AND GRAPH CHANGE********
        //CHOOSE A NUMBER BETWEEN 0-100 (inclusive)
        levelCounter = 70;
        crpv.setPercent(levelCounter);

        if(levelCounter <25){
            mLevel.setText(getLevels().get(0).getLevel());
        }
        if(levelCounter <50 && levelCounter>24){
            mLevel.setText(getLevels().get(1).getLevel());
        }
        if(levelCounter <75 && levelCounter >49){
            mLevel.setText(getLevels().get(2).getLevel());
        }
        if(levelCounter >74){
            mLevel.setText(getLevels().get(3).getLevel());
        }

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

        achievementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                launchAchievementsActivity("AchievementsActivity");
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

    private void launchAchievementsActivity(String message){
        Intent intent = new Intent(this, AchievementsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
