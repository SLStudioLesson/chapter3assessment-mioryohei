package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler {

    @Override
    public String getMode() {
        return "JSON"; // モードとしてJSONを返す
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        // 処理の実装は行わず、nullを返す
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 処理の実装は行わない
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        // 処理の実装は行わず、nullを返す
        return null;
    }
}
