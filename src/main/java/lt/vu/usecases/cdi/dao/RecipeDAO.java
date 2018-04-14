package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Recipe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class RecipeDAO {

    @Inject
    private EntityManager em;

    public void create(Recipe recipe) {
        em.persist(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return em.createNamedQuery("Recipe.findAll", Recipe.class).getResultList();
    }

}
