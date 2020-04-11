package com.infs3634.cheffy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GoalDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private Goal mGoal;


    public GoalDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(ARG_ITEM_ID)) {
            mGoal = Goal.getGoal(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle("Goal " + mGoal.getGoalId());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.goal_detail_fragment, container, false);
        if(mGoal != null) {
            ((TextView) rootView.findViewById(R.id.tvGoalText)).setText(mGoal.getGoalText());
            ((TextView) rootView.findViewById(R.id.tvGoalNumber)).setText(mGoal.getGoalId());
        }
        return rootView;
    }
}
