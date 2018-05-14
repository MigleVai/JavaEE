package lt.vu.usecases.cdi.dao;

import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Savings;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class SavingsDAO {

    @Inject
    private EntityManager em;

    public void create(Savings save) {
        em.persist(save);
    }

    public Savings findOne(Integer id){return  em.createNamedQuery("Savings.findById", Savings.class).setParameter( "id", id).getSingleResult();}
    public Set<Savings> getAllSaves() {
        Set<Savings> rec = new HashSet<>(em.createNamedQuery("Savings.findAll", Savings.class).getResultList());
        return rec;
    }
    public Set<Integer> findAllIds(){
        Set<Integer> rec = new HashSet<>(em.createNamedQuery("Savings.AllIds", Integer.class).getResultList());
        return rec;
    }
}
