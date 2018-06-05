package hu.javalife.heroesofempires.herospecies.service.ejb;

import hu.javalife.heroesofempires.herospecies.dao.model.HeroSpaciesDao;
import hu.javalife.heroesofempires.herospecies.dao.model.Hybrid;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author user
 */
@Stateless
public class HeroSpeciesServiceImpl {
    
    @Inject
    private HeroSpaciesDao dao;
    
    public Hybrid add(Hybrid pData){return dao.add(pData);}
    
    public List<Hybrid> getAll(long pHeroid) {return dao.getAll(pHeroid);}
}
