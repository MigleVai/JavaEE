package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Location;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LocationDAO {

    @Inject
    private EntityManager em;

    public void create(Location location) {
        em.persist(location);
    }

    public List<Location> getAllLocations() {
        return em.createNamedQuery("Location.findAll", Location.class).getResultList();
    }

}
