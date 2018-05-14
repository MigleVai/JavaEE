package lt.vu.usecases.cdi;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Product;
import lt.vu.entities.Recipe;
import lt.vu.usecases.cdi.dao.RecipeDAO;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;
import java.util.List;

@Slf4j
@ViewScoped
@Named
public class EditRecipe implements Serializable {

    //@Getter
    private Recipe recipe;

    @Inject
    RecipeDAO recipeDAO;


    @PostConstruct
    private void init() {
        System.out.println("EditRecipe INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer recipeId = Integer.parseInt(requestParameters.get("Id"));
        this.recipe = recipeDAO.findOne(recipeId);
        log.info(String.valueOf(this.recipe));
    }

    @Transactional
    public String editRecipeTitle() {
        try{
            Recipe rec = recipeDAO.update(this.recipe);
            log.info(String.valueOf(rec));
        } catch (OptimisticLockException e) {
            return "/edit_recipe.xhtml?faces-redirect=true&Id=" + this.recipe.getId() + "&error=optimistic-lock-exception";
        }
        log.info(String.valueOf(this.recipe));
        return "/index.xhtml";
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}