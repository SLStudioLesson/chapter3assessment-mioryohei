package com.recipeapp.model;

public class Ingredient {
    private String name; // 材料の名前

    // コンストラクタ
    public Ingredient(String name) {
        this.name = name; // nameフィールドに、同名の引数を代入する
    }

    // nameフィールドを返すメソッド
    public String getName() {
        return name; // nameフィールドを返す
    }
}
