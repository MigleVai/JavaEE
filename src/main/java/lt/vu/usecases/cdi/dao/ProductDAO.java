package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProductDAO {

    @Inject
    private EntityManager em;

    public void create(Product product) {
        em.persist(product);
    }

    public List<Product> getAllProducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

}
