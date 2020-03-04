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

        GUI g = new GUI();
        g.setVisible(true);
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileWriter(new File("ingredient.nut")));
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FetchFromAPI http = new FetchFromAPI();
        String rawData = null;
        try {
            rawData = http.getIngredients(1075071);
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        pw.print(rawData);

        ArrayList<String> ingredients = new ArrayList();

        String[] rawIngredients = rawData.split("name\":\"");

        for (int i = 1; i < rawIngredients.length; i++) {
            System.out.println(rawIngredients[i]);
            String name = rawIngredients[i].split("\"")[0];
            ingredients.add(name);
        }
        System.out.println(Arrays.toString(rawIngredients));
        System.out.println(ingredients);
//
//        //Test print to show recipes ArrayList is being populated and its contents are accessible        
        //String[] rawRecipes = rawData.split("title");

//        ArrayList<Recipe> recipes = new ArrayList();
//        
//        System.out.println(rawRecipes.length);
//        
//        for (int i = 1; i < rawRecipes.length; i++) {
//            String recipeName = (rawRecipes[i].split("\",\"")[0]).substring(3);
//            String imageURL = rawRecipes[i].split("\",\"")[1].split("\":\"")[1];
//            recipes.add(new Recipe("0", recipeName, "", imageURL ));
//            System.out.println(imageURL);
//        }
//        for (String recipe : rawRecipes) {
//            pw.print(recipe + "\n\n\n\n\n");
//        }
        pw.close();

    }

}
