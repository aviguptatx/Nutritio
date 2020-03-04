package Nutritio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

//        GUI g = new GUI();
        MainWindow GUI = new MainWindow();
        GUI.setVisible(true);
        PrintWriter pw = null;

//        try {
//            pw = new PrintWriter(new FileWriter(new File("ingredient.nut")));
//        } catch (IOException ex) {
//            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        FetchFromAPI http = new FetchFromAPI();
//        String rawData = null;
//        try {
//            rawData = http.getIngredients(1075071);
//        } catch (Exception ex) {
//            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        pw.print(rawData);
//
//        ArrayList<String> ingredients = new ArrayList();
//
//        String[] rawIngredients = rawData.split("name\":\"");
//
//        for (int i = 1; i < rawIngredients.length; i++) {
//            System.out.println(rawIngredients[i]);
//            String name = rawIngredients[i].split("\"")[0];
//            ingredients.add(name);
//        }
//        
//        pw.close();
    }

}
