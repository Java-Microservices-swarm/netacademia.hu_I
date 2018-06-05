package hu.javalife.heroesofempires.hero.service.ejb;

import hu.javalife.heroesofempires.hero.dao.model.Hero;
import hu.javalife.heroesofempires.hero.dao.model.HeroDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author user
 */
@Stateless
public class HeroServiceImpl {
    @Inject
    HeroDao dao;
    
    public Hero add(Hero pHero){
        return dao.add(pHero);
    }
    
    public List<Hero> getAll(){return dao.getAll();}
    
    public Hero getHero(int pIndex) {
        return dao.getById(pIndex);
    }    
    
    public void doDelete(int pIndex){
        dao.delete(pIndex);
    }    
    
    public Hero addHero(Hero pHero) throws BException {
        if(dao.isNameAvailable(pHero.getName())){
            return dao.add(pHero);
        }
        throw new BException(3,pHero,"nev mar hasznalatban van");
            
    }    
    
public List<Hero> getPage(
        int pStart,
        int pCount,
        String pField,
        String pDirection    
    ){
       return dao.get(pStart, pCount, null, pField, pDirection);
    }
    
}
