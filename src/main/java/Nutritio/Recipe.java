package Nutritio;

import java.util.ArrayList;

class Recipe {

    private String id;
    private String name;
    private ArrayList<Ingredient> ingredients;
    private String imageURL;

    public Recipe(String id, String name, ArrayList<Ingredient> ingredients, String imageURL) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + name + " ingredient list: " + ingredients;
    }

}
