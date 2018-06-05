package hu.javalife.heroesofempires.herospecies.rest;

import hu.javalife.heroesofempires.herospecies.dao.model.Hybrid;
import hu.javalife.heroesofempires.herospecies.service.ejb.HeroSpeciesServiceImpl;
import io.swagger.annotations.Api;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author user
 */
@Path("/hybrid")
@Api(value = "hibrid lesz")
public class HybridResource {
    @EJB
    private HeroSpeciesServiceImpl service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{heroid}")
    public List<Hybrid> getAll(){return service.getAll(0);}
    
    public Hybrid add(
            @FormParam("heroid") long heroid,
            @FormParam("speciesid") long speciesid,
            @FormParam("percent") byte percent        
    ){
        Hybrid h=new Hybrid();
        h.setHeroid(heroid);
        h.setSpeciesid(speciesid);
        h.setPercent(percent);
    return service.add(h);
    }
    
    
}
