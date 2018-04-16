package lt.vu.usecases.cdi.requests;

//package lt.vu.usecases.cdi.requests.JPA;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Product;
import lt.vu.entities.Recipe;
import lt.vu.usecases.cdi.dao.RecipeDAO;
import lt.vu.usecases.cdi.dao.ProductDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Model
@Slf4j
public class RecipeController {

    @Getter
    private Recipe recipe = new Recipe();
    @Getter
    private List<Recipe> recipes;
    @Getter
    @Setter
    private List<String> products;
    @PostConstruct
    public void init() {
        loadRecipes();
    }

    @Inject
    private RecipeDAO recipeDAO;

    @Inject
    private ProductDAO productDAO;

    @Transactional
    public void createRecipe() {
        List<Integer> ids = getRecipeIds();
        int tempID = 0;
        while(ids.contains(tempID))
        {
            tempID++;
        }
        log.info("HI " + products.toString());
        List<Product> prod = findProductsByName();
        log.info("Hello + " + prod.toString());
        recipe.setProductList(prod);
        recipe.setId(tempID);
        log.info("HEY");
        recipeDAO.create(recipe);
        log.info("Recipe titled: " + recipe.getTitle() + " was created...");
        loadRecipes();
    }

    private List<Product> findProductsByName(){
        List<Product> productFinal = new ArrayList<>();
        for (String item: products) {
            Product prod = productDAO.findByName(item);
            productFinal.add(prod);
        }
        log.info(productFinal.toString());
        return productFinal;
    };

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