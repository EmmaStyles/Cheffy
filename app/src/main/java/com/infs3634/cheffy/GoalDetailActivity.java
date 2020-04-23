package com.infs3634.cheffy;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class GoalDetailActivity extends AppCompatActivity {
    private Goal mGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(GoalDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(GoalDetailFragment.ARG_ITEM_ID));
            GoalDetailFragment fragment = new GoalDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.goal_detail_container, fragment)
                    .commit();
        }
    }
}