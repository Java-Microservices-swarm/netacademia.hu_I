package hu.javalife.heroesofempires.herospecies.rest;

import hu.javalife.heroesofempires.herospecies.dao.model.Hybrid;
import hu.javalife.heroesofempires.herospecies.service.ejb.HeroSpeciesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sun.security.provider.certpath.ResponderId;

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
    public List<Hybrid> getAll(
            @PathParam("heroid") long pHeroId
    ){return service.getAll(pHeroId);}
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "Hero or Spaces not available")
    })
    public Response add(
            @FormParam("heroid") long heroid,
            @FormParam("speciesid") long speciesid,
            @FormParam("percent") byte percent        
    ){
        Hybrid h=new Hybrid();
        h.setHeroid(heroid);
        h.setSpeciesid(speciesid);
        h.setPercent(percent);
        try{
            return Response.ok(service.add(h)).build();
        }
        catch(Throwable e){
            return Response.status(404).entity(h).build();
        }
    }
    
    
}
