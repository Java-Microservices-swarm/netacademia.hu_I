package hu.javalife.heroesofempires.species.rest;

import hu.javalife.heroesofempires.species.dao.model.Species;
import hu.javalife.heroesofempires.species.dao.model.SpeciesDao;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    
    @Inject
    private SpeciesDao dao;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Species> getAll(){return dao.getAll();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Species getOne(@PathParam("id") int pIndex){return dao.getById(pIndex);}
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int pIndex){dao.delete(pIndex);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add(
            @FormParam("name") String pName,
            @FormParam("desc") String pDesc
    ){
        
        Species newInstance = new Species(pName, pDesc);
        return Response.ok(dao.add(newInstance)).build();
    }
    
}









