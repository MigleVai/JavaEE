package lt.vu.usecases.cdi.dao;

import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Notes;
import lt.vu.entities.Recipe;
import lt.vu.entities.Savings;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class NoteDAO {

    @Inject
    private EntityManager em;

    public void create(Notes note) {
        em.persist(note);
    }

    public Notes update(Notes note) {
        log.info(String.valueOf(note));
        return em.merge(note);
    }

    public Notes findOne(Integer id){return  em.createNamedQuery("Notes.findById", Notes.class).setParameter( "id", id).getSingleResult();}
    public Set<Notes> getAllSaves() {
        Set<Notes> rec = new HashSet<>(em.createNamedQuery("Notes.findAll", Notes.class).getResultList());
        return rec;
    }
    public List<Integer> findAllIds(){
           return em.createNamedQuery("Notes.AllIds", Integer.class).getResultList();
    }
}