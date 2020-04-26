package com.infs3634.cheffy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Context.CONTEXT_IGNORE_SECURITY;
import static android.content.Context.MODE_PRIVATE;

//Adapter class for Goals
public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {
    private GoalMainActivity mParentActivity;
    private List<Goal> mGoals;
    private boolean mTwoPane;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Goal goal = (Goal) v.getTag();
            //chooses to display fragment view or single activity depending on display size
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

    public static class GoalViewHolder extends RecyclerView.ViewHolder {
        public TextView goalText;
        public TextView goalId;
        public Switch switchGoal;
        public SharedPreferences preferences;
        public GoalViewHolder(View v) {
            super(v);
            goalText = v.findViewById(R.id.tvGoal);
            goalId = v.findViewById(R.id.tvGoalId);
            switchGoal = v.findViewById(R.id.switchGoal);

            //This piece of code was to save whether switch is on or not.
            //Can't get it to work but it was supposed to set goalBoolean (in Goals) to true if switch turned on
//
//            SharedPreferences preferences = Context.getSharedPreferences("Save", MODE_PRIVATE);
//            switchGoal.setChecked(preferences.getBoolean("value", false));
//            switchGoal.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (switchGoal.isChecked()) {
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putBoolean("value", true);
//                        editor.apply();
//                        switchGoal.setChecked(true);
//                        //mGoal.setGoalBoolean(true);
//                    } else {
//                        SharedPreferences.Editor editor = preferences.edit();
//                        editor.putBoolean("value", false);
//                        editor.apply();
//                        switchGoal.setChecked(false);
//                        //mGoal.setGoalBoolean(false);
//                    }
//                }
//            });
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
