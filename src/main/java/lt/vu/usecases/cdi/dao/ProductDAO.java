package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ProductDAO {

    @Inject
    private EntityManager em;

    public void create(Product product) {
        em.persist(product);
    }

    public Set<Product> getAllProducts() {
        Set<Product> prod = new HashSet<>(em.createNamedQuery("Product.findAll", Product.class).getResultList());
        return prod;
    }
    public Product findByName(String name){
        return  em.createNamedQuery("Product.findByName" ,Product.class).setParameter( "name", name).getSingleResult();
    }
}
