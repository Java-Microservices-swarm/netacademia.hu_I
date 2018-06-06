package hu.javalife.heroesofempires.herospecies.service.ejb;

import hu.javalife.heroesofempires.hero.dao.model.Hero;
import hu.javalife.heroesofempires.herospecies.dao.model.HeroSpaciesDao;
import hu.javalife.heroesofempires.herospecies.dao.model.Hybrid;
import hu.javalife.heroesofempires.species.dao.model.Species;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

/**
 * @author user
 */
@Stateless
public class HeroSpeciesServiceImpl {
    
    @Inject
    private HeroSpaciesDao dao;
    
    public Hybrid add(Hybrid pData) throws NullPointerException{
        Client client = ClientBuilder.newClient();
        Invocation.Builder req = client.target("http://localhost:8081")
                .path("/hero/"+pData.getHeroid())
                .request(MediaType.APPLICATION_JSON);
        Hero hero =req.get(Hero.class);

        req = client.target("http://localhost:8080")
                .path("/species/"+pData.getSpeciesid())
                .request(MediaType.APPLICATION_JSON);
        Species species =req.get(Species.class);
        if(hero!=null && species!=null){
            return dao.add(pData);
        }
        else throw new NullPointerException();
    }
    
    public List<Hybrid> getAll(long pHeroid) {return dao.getAll(pHeroid);}
}
