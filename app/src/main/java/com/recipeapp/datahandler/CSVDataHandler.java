package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CSVDataHandler implements DataHandler {
    private String filePath; // レシピデータを格納するCSVファイルのパス
    
    // デフォルトコンストラクタ
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv"; // デフォルトのファイルパス
    }

    // 引数付きコンストラクタ
    public CSVDataHandler(String filePath) {
        this.filePath = filePath; // 引数で指定されたファイルパス
    }

    @Override
    public String getMode() {
        return "CSV"; // モードとしてCSVを返す
    }

    @Override
public ArrayList<Recipe> readData() throws IOException {
    ArrayList<Recipe> recipes = new ArrayList<>();
    
    // recipes.csvファイルを読み込む
    List<String> lines = Files.readAllLines(Paths.get(filePath));
    
    // 各行を解析してRecipeオブジェクトを生成し、リストに追加する
    for (String line : lines) {
        String[] parts = line.split(",", 2); // レシピ名と材料を2つの部分に分割
        if (parts.length == 2) {
            String name = parts[0];
            String[] ingredientsArray = parts[1].split(","); // 材料を分割
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            for (String ingredientName : ingredientsArray) {
                ingredients.add(new Ingredient(ingredientName.trim())); // トリミングして追加
            }
            Recipe recipe = new Recipe(name, ingredients);
            recipes.add(recipe);
        }
    }
    
    return recipes;
}

@Override
public void writeData(Recipe recipe) throws IOException {
    StringBuilder sb = new StringBuilder();
    sb.append(recipe.getName()).append(","); // レシピ名

    // 材料を追加
    for (Ingredient ingredient : recipe.getIngredients()) {
        sb.append(ingredient.getName()).append(","); // IngredientクラスにgetNameメソッドがあると仮定
    }

    // 最後のカンマを削除
    if (sb.length() > 0) {
        sb.setLength(sb.length() - 1);
    }
    sb.append("\n"); // 改行を追加

    // recipes.csv に書き込み
    try {
        Files.write(Paths.get(filePath), sb.toString().getBytes());
    } catch (IOException e) {
        System.err.println("Error writing to file for recipe '" + recipe.getName() + "': " + e.getMessage());
        throw e; // 再スローして呼び出し元でハンドリングできるようにする
    }
}


    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        // 処理の実装は行わず、nullを返す
        return null;
    }
}
