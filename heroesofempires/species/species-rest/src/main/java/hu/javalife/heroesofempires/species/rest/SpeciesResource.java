package hu.javalife.heroesofempires.species.rest;

import hu.javalife.heroesofempires.species.dao.model.Species;
import hu.javalife.heroesofempires.species.service.ejb.SpeciesServiceImpl;
import io.swagger.annotations.Api;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author user
 */
@Path("/species")
@RequestScoped
@Api(value = "fajok kezelése")
public class SpeciesResource {
    
    @EJB
    private SpeciesServiceImpl service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Species> getAll(){return service.getAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Species getOne(@PathParam("id") int pIndex){return getOne(pIndex);}
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int pIndex){service.doDelete(pIndex);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add(
            @FormParam("name") String pName,
            @FormParam("desc") String pDesc
    ){
        
        Species newInstance = new Species();
        newInstance.setName(pName);
        newInstance.setDescription(pDesc);
        return Response.ok(service.add(newInstance)).build();
    }
    
}









