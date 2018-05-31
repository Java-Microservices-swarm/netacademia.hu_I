package hu.javalife.heroesofempires.species.dao.model;

import java.util.List;

/**
 * @author user
 */
public interface SpeciesDao {

    public Species getById(long pId);
    public boolean isNameAvailable(String pName);
    public Species getByName(String pname);
    public List<Species> getAll();
    public Species modify(long pId, Species pNewData);
    public void delete(long pId);
    public Species add(Species pNewData);
    public List<Species> get(int pStart, int pCount, Species pSearch, String pShortField, String pShortDirection);
    public long getItemCount();
        
}
