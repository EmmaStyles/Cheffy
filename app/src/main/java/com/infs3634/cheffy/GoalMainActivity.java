package com.infs3634.cheffy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

//Class for Goal Main Activity
public class GoalMainActivity extends AppCompatActivity {
    private boolean mTwoPane;
    private String TAG = "GoalMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (findViewById(R.id.goal_detail_container) != null) {
            mTwoPane = true;
        }
        RecyclerView mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mTwoPane = findViewById(R.id.goal_detail_container) != null;
        RecyclerView.Adapter mAdapter = new GoalAdapter(this, Goal.getGoals(), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);

    }
}