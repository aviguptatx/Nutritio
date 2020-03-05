package Nutritio;

import java.util.ArrayList;

class Recipe {

    private String id;
    private String name;
    private ArrayList<Ingredient> ingredients;
    private String[] instructions;
    private String imageURL;

    public Recipe(String id, String name, ArrayList<Ingredient> ingredients, String[] instructions, String imageURL) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + name + " ingredient list: " + ingredients;
    }

}
