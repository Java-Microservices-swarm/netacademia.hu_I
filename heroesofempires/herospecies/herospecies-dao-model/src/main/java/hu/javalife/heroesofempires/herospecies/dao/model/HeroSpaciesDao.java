package hu.javalife.heroesofempires.herospecies.dao.model;

import java.util.List;

/**
 * @author user
 */
public interface HeroSpaciesDao {

    public Hybrid getById(long pId);
    public Hybrid modify(long pId, Hybrid pNewData);
    public void delete(long pId);
    public Hybrid add(Hybrid pNewData);
    public List<Hybrid> getAll(long pHeroId);
}
