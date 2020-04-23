package com.infs3634.cheffy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;

public class GoalDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Goal mGoal;
    private Switch switchGoal;

    public GoalDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //switchGoal.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        if(getArguments().containsKey(ARG_ITEM_ID)) {
            mGoal = Goal.getGoal(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle("Goal " + mGoal.getGoalId());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.goal_detail_fragment, container, false);
        switchGoal = (Switch) rootView.findViewById(R.id.switchGoal);
        SharedPreferences preferences = this.getContext().getSharedPreferences("save", Context.MODE_PRIVATE);
        switchGoal.setChecked(preferences.getBoolean("value", false));
        switchGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchGoal.isChecked()) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    switchGoal.setChecked(true);
                    mGoal.setGoalBoolean(true);
                } else {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switchGoal.setChecked(false);
                    mGoal.setGoalBoolean(false);
                }
            }
        });
        if(mGoal != null) {
            ((TextView) rootView.findViewById(R.id.tvGoalText)).setText(mGoal.getGoalText());
            ((TextView) rootView.findViewById(R.id.tvGoalNumber)).setText(mGoal.getGoalId());
        }
        return rootView;
    }
}
