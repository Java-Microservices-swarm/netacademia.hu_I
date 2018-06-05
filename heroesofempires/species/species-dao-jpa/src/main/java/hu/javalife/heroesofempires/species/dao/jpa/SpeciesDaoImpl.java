package hu.javalife.heroesofempires.species.dao.jpa;

import hu.javalife.heroesofempires.species.dao.model.Species;
import hu.javalife.heroesofempires.species.dao.model.SpeciesDao;
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
public class SpeciesDaoImpl implements SpeciesDao {

    @PersistenceContext(name = "SpeciesPU")
    private EntityManager em;

    @Override
    public Species getById(long pId) {
        return em.find(Species.class, pId);
    }

    @Override
    public boolean isNameAvailable(String pName) {
        return em.createNamedQuery("Species.name").setParameter("name", pName).getResultList().isEmpty();
    }

    @Override
    public Species getByName(String pname) {
        return (Species) em.createNamedQuery("Species.name").setParameter("name", pname).getSingleResult();
    }

    @Override
    public List<Species> getAll() {
        return em.createQuery("Select s FROM Species s").getResultList();
    }

    @Override
    public Species modify(long pId, Species pNewData) {
        Species tmp = getById(pId);
        tmp.setName(pNewData.getName());
        tmp.setDescription(pNewData.getDescription());
        em.merge(tmp);
        return tmp;
    }

    @Override
    public void delete(long pId) {
        em.remove(getById(pId));
    }

    @Override
    public Species add(Species pNewData) {
        em.persist(pNewData);
        return pNewData;
    }

    @Override
    public List<Species> get(int pStart, int pCount, Species pSearch, String pShortField, String pShortDirection) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Species> query = builder.createQuery(Species.class);

        Root root = query.from(Species.class);
        query.select(root);

        if (pShortField != null && pShortDirection != null) {
            if ("asc".equals(pShortDirection.toLowerCase())) {
                query.orderBy(builder.asc(root.get(pShortField)));
            }
            if ("desc".equals(pShortDirection.toLowerCase())) {
                query.orderBy(builder.desc(root.get(pShortField)));
            }
        }

        return em.createQuery(query)
                .setFirstResult(pStart)
                .setMaxResults(pStart + pCount)
                .getResultList();
    }

    @Override
    public long getItemCount() {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Species.class)));
        return em.createQuery(cq).getSingleResult();
    }

}
