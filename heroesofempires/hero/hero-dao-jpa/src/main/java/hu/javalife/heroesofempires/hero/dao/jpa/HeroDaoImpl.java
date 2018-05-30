package hu.javalife.heroesofempires.hero.dao.jpa;

import hu.javalife.heroesofempires.hero.dao.model.Hero;
import hu.javalife.heroesofempires.hero.dao.model.HeroDao;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author user
 */
@RequestScoped
public class HeroDaoImpl implements HeroDao{
    
    private EntityManager em = Persistence.createEntityManagerFactory("HeroPU").createEntityManager();

    @Override
    public Hero getById(long pId) {
        return em.find(Hero.class, pId);
    }

    @Override
    public boolean isNameAvailable(String pName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hero getByName(String pname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hero> getAll() {
        return em.createQuery("SELECT h FROM Hero h").getResultList();
    }

    @Override
    public Hero modify(long pId, Hero pNewData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long pId) {
        em.getTransaction().begin();
        em.remove(getById(pId));
        em.getTransaction().commit();
    }

    @Override
    public Hero add(Hero pNewData) {
        em.getTransaction().begin();
        em.persist(pNewData);
        em.getTransaction().commit();
        return pNewData;
    }

    @Override
    public List<Hero> get(int pStart, int pCount, Hero pSearch, String pShortField, String pShortDirection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getItemCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
