package com.infs3634.cheffy;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    String TAG = "RecipeFragment";
    private String mealID;
    private Meal mMeal;

    public RecipeFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey((ARG_ITEM_ID))){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RecipeAPI recipeAPI = retrofit.create(RecipeAPI.class);

            mealID = getArguments().getString(ARG_ITEM_ID);
            Log.d(TAG, "letter is " + mealID);
            //need to somehow retreive what letter was cicked in mealsmainactivity and pass it to the following method
            Call<MealResponse> mealsCall = recipeAPI.getRecipeByID(mealID);
            mealsCall.enqueue(new Callback<MealResponse>() {
                @Override
                public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                    List<Meal> meals = response.body().getMeals();
                    for (Meal meal : meals){
                        if(meal.getIdMeal().equals(getArguments().getString(ARG_ITEM_ID))){
                            mMeal = meal;
                            break;
                        }
                    }
                    updateData();
                }
                @Override
                public void onFailure(Call<MealResponse> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_recipe_fragment, container, false);
        updateData();
        return rootView;
    }

    private void updateData(){
        View rootView = getView();
        if (rootView != null && mMeal != null){
            ((TextView) rootView.findViewById(R.id.recipeName)).setText(mMeal.getStrMeal());
            ((TextView) rootView.findViewById(R.id.ingredient1)).setText(mMeal.getStrIngredient1());
            ((TextView) rootView.findViewById(R.id.ingredient2)).setText(mMeal.getStrIngredient2());
            ((TextView) rootView.findViewById(R.id.ingredient3)).setText(mMeal.getStrIngredient3());
            ((TextView) rootView.findViewById(R.id.ingredient4)).setText(mMeal.getStrIngredient4());
            ((TextView) rootView.findViewById(R.id.ingredient5)).setText(mMeal.getStrIngredient5());
            ((TextView) rootView.findViewById(R.id.ingredient6)).setText(mMeal.getStrIngredient6());
            ((TextView) rootView.findViewById(R.id.ingredient7)).setText(mMeal.getStrIngredient7());
            ((TextView) rootView.findViewById(R.id.ingredient8)).setText(mMeal.getStrIngredient8());
            ((TextView) rootView.findViewById(R.id.ingredient9)).setText(mMeal.getStrIngredient9());
            ((TextView) rootView.findViewById(R.id.ingredient10)).setText(mMeal.getStrIngredient10());
            ((TextView) rootView.findViewById(R.id.measure1)).setText(mMeal.getStrMeasure1());
            ((TextView) rootView.findViewById(R.id.measure2)).setText(mMeal.getStrMeasure2());
            ((TextView) rootView.findViewById(R.id.measure3)).setText(mMeal.getStrMeasure3());
            ((TextView) rootView.findViewById(R.id.measure4)).setText(mMeal.getStrMeasure4());
            ((TextView) rootView.findViewById(R.id.measure5)).setText(mMeal.getStrMeasure5());
            ((TextView) rootView.findViewById(R.id.measure6)).setText(mMeal.getStrMeasure6());
            ((TextView) rootView.findViewById(R.id.measure7)).setText(mMeal.getStrMeasure7());
            ((TextView) rootView.findViewById(R.id.measure8)).setText(mMeal.getStrMeasure8());
            ((TextView) rootView.findViewById(R.id.measure9)).setText(mMeal.getStrMeasure9());
            ((TextView) rootView.findViewById(R.id.measure10)).setText(mMeal.getStrMeasure10());
            ((TextView) rootView.findViewById(R.id.instructionsTextView)).setText(mMeal.getStrInstructions());
        }
    }
}
