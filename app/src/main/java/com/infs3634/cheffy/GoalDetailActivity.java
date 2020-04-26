package com.infs3634.cheffy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//Detail activity for goal
public class GoalDetailActivity extends AppCompatActivity {

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