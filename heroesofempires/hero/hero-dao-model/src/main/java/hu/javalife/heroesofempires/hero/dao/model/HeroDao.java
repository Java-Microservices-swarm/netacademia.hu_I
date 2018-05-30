package hu.javalife.heroesofempires.hero.dao.model;

import java.util.List;

/**
 * @author user
 */
public interface HeroDao {

    public Hero getById(long pId);
    public boolean isNameAvailable(String pName);
    public Hero getByName(String pname);
    public List<Hero> getAll();
    public Hero modify(long pId, Hero pNewData);
    public void delete(long pId);
    public Hero add(Hero pNewData);
    public List<Hero> get(int pStart, int pCount, Hero pSearch, String pShortField, String pShortDirection);
    public long getItemCount();
        
}
