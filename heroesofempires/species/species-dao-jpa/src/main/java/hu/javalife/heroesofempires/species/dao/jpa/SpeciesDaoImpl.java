package hu.javalife.heroesofempires.species.dao.jpa;

import hu.javalife.heroesofempires.species.dao.model.Species;
import hu.javalife.heroesofempires.species.dao.model.SpeciesDao;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author user
 */
@RequestScoped
public class SpeciesDaoImpl implements SpeciesDao{
    
    private EntityManager em = Persistence.createEntityManagerFactory("SpeciesPU").createEntityManager();

    @Override
    public Species getById(long pId) {
        return em.find(Species.class, pId);
    }

    @Override
    public boolean isNameAvailable(String pName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Species getByName(String pname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Species> getAll() {
        return em.createQuery("Select s FROM Species s").getResultList();
    }

    @Override
    public Species modify(long pId, Species pNewData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long pId) {
        em.getTransaction().begin();
        em.remove(getById(pId));
        em.getTransaction().commit();
    }

    @Override
    public Species add(Species pNewData) {
        em.getTransaction().begin();
        em.persist(pNewData);
        em.getTransaction().commit();
        return pNewData;
    }

    @Override
    public List<Species> get(int pStart, int pCount, Species pSearch, String pShortField, String pShortDirection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getItemCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
