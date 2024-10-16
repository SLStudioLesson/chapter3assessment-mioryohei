package com.recipeapp.datahandler;
import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;

public class CSVDataHandler implements DataHandler {
    String filePath;

    //フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }
    //フィールドfilePathに引数を代入する
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }
    @Override
    //文字列CSVを返してください。
    public String getMode() {
        return "CSV";
    }
    //以降の設問で処理を実装するため定義し、nullをreturnしてください。
    @Override
    public ArrayList<Recipe> readData() {
        return null;
    }
    @Override
    public void writeData(Recipe recipe) {

    }
    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}