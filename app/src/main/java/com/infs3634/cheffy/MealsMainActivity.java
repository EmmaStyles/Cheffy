package com.infs3634.cheffy;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsMainActivity extends AppCompatActivity{
    private boolean twoPane;
    private String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "v", "w", "y"};

    private String letterSelected;
    private MealsAdapter mealsAdapter;
    private String TAG = "MealsMainActivity";
    private Spinner letterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_main);

        if (findViewById(R.id.recipe_container) != null){
            twoPane = true;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RecipeAPI recipeAPI = retrofit.create(RecipeAPI.class);

        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mealsAdapter = new MealsAdapter(this, new ArrayList<Meal>(), twoPane);
        recyclerView.setAdapter(mealsAdapter);

        letterSpinner = findViewById(R.id.letterSpinner);
        ArrayAdapter letterSpinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, alphabet);
        letterSpinner.setAdapter(letterSpinnerAdapter);

        letterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                letterSelected = letterSpinner.getItemAtPosition(position).toString();
                Log.d(TAG, "letter selected is " + letterSelected);
                Bundle bundle = new Bundle();
                bundle.putString(RecipeFragment.ARG_ITEM_ID, letterSelected);
                RecipeFragment rf = new RecipeFragment();
                rf.setArguments(bundle);
                Call<MealResponse> call = recipeAPI.getRecipesByFirstLetter(letterSelected);

                call.enqueue(new Callback<MealResponse>() {
                    @Override
                    public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                        Log.d(TAG, "Success!");
                        List<Meal> meals = response.body().getMeals();
                        mealsAdapter.setMeals(meals);
                    }

                    @Override
                    public void onFailure(Call<MealResponse> call, Throwable t) {
                        Log.d(TAG, "Failure");
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}