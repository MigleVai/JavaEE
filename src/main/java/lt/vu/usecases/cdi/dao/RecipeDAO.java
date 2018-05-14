package lt.vu.usecases.cdi.dao;

import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Recipe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class RecipeDAO {

    @Inject
    private EntityManager em;

    public void create(Recipe recipe) {
        em.persist(recipe);
    }

    public Recipe update(Recipe recipe) {
        log.info(String.valueOf(recipe));
        return em.merge(recipe); //merge
        //em.getTransaction().commit();
       // em.flush();
    }
    public Recipe findOne(Integer id){return  em.createNamedQuery("Recipe.findById", Recipe.class).setParameter( "id", id).getSingleResult();}
    public Set<Recipe> getAllRecipes() {
        Set<Recipe> rec = new HashSet<>(em.createNamedQuery("Recipe.findAll", Recipe.class).getResultList());
        return rec;
    }

}
