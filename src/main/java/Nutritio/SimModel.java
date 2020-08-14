/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    
    Class will serve as adat object for File input and output



 */
package Nutritio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Patel_871632
 */
public class SimModel implements Serializable {
    
    private ArrayList<Recipe> recipes;
    private ArrayList<String> ids;

    public SimModel(ArrayList<Recipe> recipes,ArrayList<String> ids ) {
        this.recipes = recipes;
        this.ids = ids;
    }

   
    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }
    
    public ArrayList<String> getIds() {
        return ids;
    }
}
