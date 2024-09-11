package catering.businesslogic.Preparation;

import catering.businesslogic.recipe.Recipe;

import java.util.ArrayList;

public class PreparationManager {

    public PreparationManager() {Preparation.loadAllPreparation();
    }

    public ArrayList<Preparation> getRecipes() {
        return Preparation.getAllRecipes();
    }
}
