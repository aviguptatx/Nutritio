package Nutritio;

import java.util.ArrayList;

class Recipe implements Comparable {

    private String name;
    private ArrayList<Ingredient> ingredients;
    private String imageURL;

    public Recipe(String name, ArrayList<Ingredient> ingredients, String imageURL) {
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
        return name;
    }

    @Override
    public int compareTo(Object oth) {
        Recipe other = (Recipe) oth;
        return name.compareTo(other.getName());
    }
    
}
