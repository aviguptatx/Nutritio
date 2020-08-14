package Nutritio;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

class FetchFromAPI implements Serializable{

    // Insert API Key from RapidAPI
    private String APIKey = PrivateAPIKey.APIKey;

    public String getRecipeData(ArrayList<String> ingredients) throws Exception {

        final String tail = "&limitLicense=false&number=3&ranking=1";
        String base = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?number=5&ranking=1&ignorePantry=false&ingredients=";

        // formatting base url based on ingredients inputted
        for (String ingredient : ingredients) {
            base += ingredient + "%252C";
        }

        // chop off final "%25C" - not needed
        base = base.substring(0, base.length() - 5);

        StringBuilder recStrBldr = new StringBuilder("");
        String separator = "%2C";
        int numIngredients = ingredients.size();
        int lastIngredient = numIngredients - 1;

        // Build the ingredientString based on the above url format using %2C for separators
        for (int k = 0; k < numIngredients; k++) {
            String curIng = ingredients.get(k);
            curIng = curIng.replaceAll("[\\n\\t ]", "");
            recStrBldr.append(curIng);

            if (k != lastIngredient) {
                recStrBldr.append(separator);
            }
        }

        String url = base + recStrBldr.toString() + tail;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        // add request header
        con.setRequestProperty("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", APIKey);

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        StringBuffer response = new StringBuffer();

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String resultString = sb.toString();
        return resultString;
    }

    public String getURL(String recipeId) throws Exception {

        String base = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/";
        String tail = "/information";
        String url = base + recipeId.substring(0,recipeId.length()-1) + tail;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        // add request header
        con.setRequestProperty("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", APIKey);

        int responseCode = con.getResponseCode();

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        StringBuffer response = new StringBuffer();

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String resultString = sb.toString();

        String[] parsed = resultString.split("dairyFree");
        String recipeURL = "";

        recipeURL = parsed[1].split("\"sourceUrl\":\"")[1].split("\"")[0].trim();

        return recipeURL;
    }
}
