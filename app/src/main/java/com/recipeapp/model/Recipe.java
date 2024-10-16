package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;

    //nameフィールドとingredientsフィールドそれぞれに、同名の引数を代入する

    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;       //nameフィールドを返す
        this.ingredients = Ingredient;  //ingredientsフィールドを返す
    }
    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
}