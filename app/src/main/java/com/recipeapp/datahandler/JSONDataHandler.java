package com.recipeapp.datahandler;
import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;
//JSON形式に対応したクラス
public class JSONDataHandler implements DataHandler {
    //文字列JSONを返してください。
    @Override
    public String getMode() {
        return "JSON";
    }
    @Override
    //処理の実装は行わないので定義し、nullをreturnしてください。
    public ArrayList<Recipe> readData() {
        return null;
    }
    @Override
    //処理の実装は行わないので定義のみ行います。
    public void writeData(Recipe recipe) {

    }
    @Override
    //処理の実装は行わないので定義し、nullをreturnしてください。
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}