package lt.vu.usecases.cdi;

import lombok.Getter;
import lombok.Setter;
import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class GeneratingRecipe implements Serializable {
    @Inject
    RecipeGenerator generator;

    @Setter
    @Getter
    private String recipeName;

    private Future<String> recipeGenerationTask = null;

    @LoggedInvocation
    public String generateRecipe() {
        recipeGenerationTask = generator.generateFood(recipeName);
        return  "/generate-food";
    }

    public boolean isRecipeGenerationRunning() {
        return recipeGenerationTask != null && !recipeGenerationTask.isDone();
    }

    public String getRecipeGenerationStatus() throws ExecutionException, InterruptedException {
        if (recipeGenerationTask == null) {
            return null;
        } else if (isRecipeGenerationRunning()) {
            return "Recipe generation is in progress";
        }
        return recipeGenerationTask.get();
    }


}