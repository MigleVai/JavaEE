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
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Model
@Slf4j
public class RecipeController {

    @Getter
    private Recipe recipe = new Recipe();
    @Getter
    private Set<Recipe> recipes;
    @Getter
    @Setter
    private Set<String> products;
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
        Set<Integer> ids = getRecipeIds();
        int tempID = 1;
        while(ids.contains(tempID))
        {
            tempID++;
        }
        Set<Product> prod = findProductsByName();
        recipe.setProductList(prod);
        recipe.setId(tempID);
        recipeDAO.create(recipe);
        recipe = new Recipe();
        loadRecipes();
    }

    private Set<Product> findProductsByName(){
        Set<Product> productFinal = new HashSet<>();
        for (String item: products) {
            Product prod = productDAO.findByName(item);
            productFinal.add(prod);
        }
        return productFinal;
    }

    public Set<String> getRecipeNames() {
        List list = recipes.stream().map(Recipe::getTitle).collect(Collectors.toList());
        Set<String> rec = new HashSet<String>(list);
        return  rec;
    }

    public Set<Integer> getRecipeIds() {
        List list = recipes.stream().map(Recipe::getId).collect(Collectors.toList());
        Set<Integer> rec = new HashSet<Integer>(list);
        return rec;
    }

    private void loadRecipes() {
        recipes = recipeDAO.getAllRecipes();
    }
}