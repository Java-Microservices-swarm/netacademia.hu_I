package hu.javalife.heroesofempires.species.rest;

import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
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
@ApplicationScoped
@Api(value = "fajok kezelése")
public class SpeciesResource {
    private List<Species> species = new ArrayList<>();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Species> getAll(){return species;}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Species getOne(@PathParam("id") int pIndex){return species.get(pIndex);}
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Species delete(@PathParam("id") int pIndex){return species.remove(pIndex);}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add(
            @FormParam("name") String pName,
            @FormParam("desc") String pDesc
    ){
      Species available = null;
      for(Species t: species){
          if(t.getName().equals(pName))
              available=t;
      }
      if(available==null){
          Species newInstance = new Species(pName, pDesc);
          species.add(newInstance);
          return Response.ok(newInstance).build();
      }
      else{
          return Response.status(500).entity(available).build();
      }
          
    }
    
}









