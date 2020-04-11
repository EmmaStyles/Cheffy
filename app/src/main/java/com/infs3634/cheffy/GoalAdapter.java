package com.infs3634.cheffy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {
    private GoalMainActivity mParentActivity;
    private List<Goal> mGoals;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Goal goal = (Goal) v.getTag();
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(GoalDetailFragment.ARG_ITEM_ID, goal.getGoalId());
                GoalDetailFragment fragment = new GoalDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.goal_detail_container, fragment).commit();
            }
            else {
                Context context = v.getContext();
                Intent intent = new Intent(context, GoalDetailActivity.class);
                intent.putExtra(GoalDetailFragment.ARG_ITEM_ID, goal.getGoalId());
                context.startActivity(intent);
            }
        }
    };

    public GoalAdapter(GoalMainActivity parent, List<Goal> goals, boolean twoPane) {
        mParentActivity = parent;
        mGoals = goals;
        mTwoPane = twoPane;
    }

    public static class GoalViewHolder extends RecyclerView.ViewHolder  {
        public TextView goalText;
        public TextView goalId;
        public GoalViewHolder(View v) {
            super(v);
            goalText = v.findViewById(R.id.tvGoal);
            goalId = v.findViewById(R.id.tvGoalId);
        }
    }
    @Override
    public GoalAdapter.GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.goal_list_row, parent, false);
        return new GoalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GoalViewHolder holder, int position) {
        Goal goal = mGoals.get(position);
        holder.goalText.setText(goal.getGoalText());
        holder.goalId.setText(goal.getGoalId());
        holder.itemView.setTag(goal);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mGoals.size();
    }

    public void setGoals(List<Goal> goals) {
        mGoals.clear();;
        mGoals.addAll(goals);
        notifyDataSetChanged();
    }
}
