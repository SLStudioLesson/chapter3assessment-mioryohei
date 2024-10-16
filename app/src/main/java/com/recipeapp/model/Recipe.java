package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;

    // コンストラクタ
    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;              // nameフィールドに引数を代入
        this.ingredients = ingredients; // ingredientsフィールドに引数を代入
    }

    // nameフィールドを返すメソッド
    public String getName() {
        return name;
    }

    // ingredientsフィールドを返すメソッド
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
}
