package hu.javalife.heroesofempires.herospecies.dao;

import hu.javalife.heroesofempires.herospecies.dao.model.HeroSpaciesDao;
import hu.javalife.heroesofempires.herospecies.dao.model.Hybrid;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author user
 */
@RequestScoped

public class HeroSpeciesDaoImpl implements HeroSpaciesDao{
    @PersistenceContext(name = "HeroSpeciesPU")
    private EntityManager em;

    @Override
    public Hybrid getById(long pId) {
        return (Hybrid)em.find(Hybrid.class, pId);
    }

    @Override
    public Hybrid modify(long pId, Hybrid pNewData) {
       Hybrid tmp;
       tmp = getById(pId);
       tmp.setHeroid(pNewData.getHeroid());
       tmp.setSpeciesid(pNewData.getSpeciesid());
       tmp.setPercent(pNewData.getPercent());
       em.merge(tmp);
       return tmp;
    }

    @Override
    public void delete(long pId) {
        em.remove(getById(pId));
    }

    @Override
    public Hybrid add(Hybrid pNewData) {
        em.persist(pNewData);
        return pNewData;
    }

    @Override
    public List<Hybrid> getAll(long pHeroId) {
        return em.createQuery("SELECT h FROM Hybrid h WHERE h.heroid=:heroid")
                .setParameter("heroid", pHeroId)
                .getResultList();
    }
    
}
