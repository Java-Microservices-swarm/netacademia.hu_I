package hu.javalife.heroesofempires.hero.dao.jpa;

import hu.javalife.heroesofempires.hero.dao.model.Hero;
import hu.javalife.heroesofempires.hero.dao.model.HeroDao;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author user
 */
@RequestScoped
public class HeroDaoImpl implements HeroDao{
    
    @PersistenceContext(name = "HeroPU")
    private EntityManager em ;

    @Override
    public Hero getById(long pId) {
        return em.find(Hero.class, pId);
    }

    @Override
    public boolean isNameAvailable(String pName) {
        return em.createNamedQuery("Hero.name",Hero.class)
                .setParameter("name", pName)
                .getResultList().isEmpty();
    }

    @Override
    public Hero getByName(String pname) {
        return em.createNamedQuery("Hero.name",Hero.class)
                .setParameter("name", pname)
                .getSingleResult();
    }

    @Override
    public List<Hero> getAll() {
        return em.createQuery("SELECT h FROM Hero h").getResultList();
    }

    @Override
    public Hero modify(long pId, Hero pNewData) {
        Hero hero = getById(pId);
        hero.setName(pNewData.getName());
        hero.setDescription(pNewData.getDescription());
        return hero;
    }

    @Override
    public void delete(long pId) {
        em.remove(getById(pId));
    }

    @Override
    public Hero add(Hero pNewData) {
        em.persist(pNewData);
        return pNewData;
    }

    @Override
    public List<Hero> get(int pStart, int pCount, Hero pSearch, String pShortField, String pShortDirection) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Hero> query =  builder.createQuery(Hero.class);
        
        Root root = query.from(Hero.class);
        query.select(root);
        
        if(pShortField != null && pShortDirection != null){
            if("asc".equals(pShortDirection.toLowerCase()))
                query.orderBy(builder.asc(root.get(pShortField)));
            if("desc".equals(pShortDirection.toLowerCase()))
                query.orderBy(builder.desc(root.get(pShortField)));
        }
        
        return em.createQuery(query)
                .setFirstResult(pStart)
                .setMaxResults(pStart+pCount)
                .getResultList();
    }

    @Override
    public long getItemCount() {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Hero.class)));
        return em.createQuery(cq).getSingleResult();
        
    }
    
}
