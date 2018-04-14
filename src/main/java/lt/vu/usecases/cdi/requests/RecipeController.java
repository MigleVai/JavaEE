package lt.vu.usecases.cdi.requests;

//package lt.vu.usecases.cdi.requests.JPA;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Recipe;
import lt.vu.usecases.cdi.dao.RecipeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Model
@Slf4j
public class RecipeController {

    @Getter
    private Recipe recipe = new Recipe();
    @Getter
    private List<Recipe> recipes;

    @PostConstruct
    public void init() {
        loadRecipes();
    }

    @Inject
    private RecipeDAO recipeDAO;

    @Transactional
    public void createRecipe() {
        List<Integer> ids = getRecipeIds();
        int tempID = 0;
        while(ids.contains(tempID))
        {
            tempID++;
        }
        recipe.setId(tempID);
        recipeDAO.create(recipe);
        log.info("Recipe titled: " + recipe.getTitle() + " was created...");
        loadRecipes();
    }

    public List<String> getRecipeNames() {
        return recipes.stream().map(Recipe::getTitle).collect(Collectors.toList());
    }

    public List<Integer> getRecipeIds() {
        return recipes.stream().map(Recipe::getId).collect(Collectors.toList());
    }

    private void loadRecipes() {
        recipes = recipeDAO.getAllRecipes();
    }
}