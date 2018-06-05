package hu.javalife.heroesofempires.species.service.ejb;

import hu.javalife.heroesofempires.species.dao.model.Species;
import hu.javalife.heroesofempires.species.dao.model.SpeciesDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author user
 */
@Stateless
public class SpeciesServiceImpl {

    @Inject
    private SpeciesDao dao;

    public Species add(Species pData) {
        return dao.add(pData);
    }

    public List<Species> getAll() {
        return dao.getAll();
    }

    public Species getSpecies(int pIndex) {
        return dao.getById(pIndex);
    }

    public void doDelete(int pIndex) {
        dao.delete(pIndex);
    }

    public Species addSpecies(Species pSpecies) {
        return dao.add(pSpecies);
    }

    public List<Species> getPage(
            int pStart,
            int pCount,
            String pField,
            String pDirection
    ) {
        return dao.get(pStart, pCount, null, pField, pDirection);
    }
}
