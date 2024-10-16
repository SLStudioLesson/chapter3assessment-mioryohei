package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {
        System.out.println("Current mode: " + dataHandler.getMode());
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");
                String choice = reader.readLine();
                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData();
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                System.out.println("Recipes: ");
                for (Recipe recipe : recipes) {
                    System.out.println("--------------------------------");
                    System.out.println("Recipe Name: " + recipe.getName());
                    System.out.print("Main Ingredints: ");
                    ArrayList<String> ingredientNames = new ArrayList<>();
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        ingredientNames.add(ingredient.getName());
                    }
                    System.out.println(String.join(",", ingredientNames));
                }
                System.out.println("-----------------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private String filePath = "app/src/main/resources/recipes.csv"; 
    private void addNewRecipe() {
        

        try {
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine().trim();

            // レシピ名が空でないことを確認
            if (recipeName.isEmpty()) {
                System.out.println("Recipe name cannot be empty.");
                return;
            }

            ArrayList<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");
            while (true) {
                System.out.print("Ingredient: ");
                String ingredientName = reader.readLine().trim();
                if (ingredientName.equalsIgnoreCase("done")) {
                    break;
                }
                // 材料名が空でないことを確認
                if (!ingredientName.isEmpty()) {
                    ingredients.add(new Ingredient(ingredientName));
                } else {
                    System.out.println("Ingredient name cannot be empty.");
                }
            }

            // 材料が入力されていない場合
            if (ingredients.isEmpty()) {
                System.out.println("At least one ingredient must be added.");
                return;
            }

            // Recipeオブジェクトを作成
            Recipe newRecipe = new Recipe(recipeName, ingredients);

            // DataHandlerを使ってファイルに追加
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(newRecipe.getName() + ",");
                for (Ingredient ingredient : newRecipe.getIngredients()) {
                    writer.write(ingredient.getName() + ",");
                }
                writer.write("\n"); // 改行を追加
            }

            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }

}