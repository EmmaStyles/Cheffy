package com.infs3634.cheffy;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


//displays the details of an individual recipe such as name, ingredients, and instructions

public class RecipeFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    String TAG = "RecipeFragment";
    private String mealID;
    private Meal mMeal;
    private MealDatabase mealDatabase;

    public RecipeFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealDatabase = Room.databaseBuilder(getContext(), MealDatabase.class, "meal-database").build();

        //retrieves the letterSelected from MealsMainActivity
        if (getArguments().containsKey((ARG_ITEM_ID))){
            new GetMealDatabaseTask().execute(getArguments().getString(ARG_ITEM_ID));
        }
    }


    private class GetMealDatabaseTask extends AsyncTask<String, Void, Meal>{

        @Override
        protected Meal doInBackground(String... ids) {
            return mealDatabase.mealDao().getMeal(ids[0]);
        }

        @Override
        protected void onPostExecute(Meal meal){
            mMeal = meal;
            updateData();
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
        if (rootView!=null && mMeal != null){
            Glide.with(rootView)
                    .load(mMeal.getStrMealThumb() + "/preview")
                    .override(200,200)
                    .into((ImageView)rootView.findViewById(R.id.recipeImageView));
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
