package com.infs3634.cheffy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RecipeAPI {

    //right now this just returns recipes beginning with b
    //initially used just to get the recipes displaying in the recyclerview
    @GET("search.php?f=b")
    Call<MealResponse> getRecipes();


    //appends a letter onto the URL to get a specific list of recipes depending on the string that was inputted
    @GET("search.php")
    Call<MealResponse> getRecipesByFirstLetter(@Query(value = "f", encoded = true) String f);


    @GET("lookup.php")
    Call<MealResponse> getRecipeByID(@Query(value = "i", encoded = true) String i);
}
