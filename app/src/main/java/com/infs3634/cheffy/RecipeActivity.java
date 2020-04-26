package com.infs3634.cheffy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //displays RecipeFragment class
        if (savedInstanceState == null){
            Bundle arguments = new Bundle();
            arguments.putString(RecipeFragment.ARG_ITEM_ID, getIntent().getStringExtra(RecipeFragment.ARG_ITEM_ID));
            RecipeFragment fragment = new RecipeFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recipe_container, fragment)
                    .commit();
        }

    }
}
