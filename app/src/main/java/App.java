import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;

import java.io.*;

public class App {

    public static void main(String[] args) {
        DataHandler dataHandler; // DataHandlerインスタンスを格納する変数を定義

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            
            //ユーザーの選択に応じて、CSVDataHandlerまたはJSONDataHandlerのインスタンスを生成する
            if("1".equals(choice)) {
                dataHandler = new CSVDataHandler(); //csvの場合
            } else if ("2".equals(choice)) {
                dataHandler = new JSONDataHandler(); //Json　の場合
            } else {
                dataHandler = new CSVDataHandler(); //それ以外
            }
            //選択されたモードを表示
            System.out.println("Current mode:" + dataHandler.getMode());

            //RecipeUIクラスのDisplayMenuメソッドを呼び出す
            RecipeUI.displayMenu(dataHandler);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}