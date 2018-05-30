package hu.javalife.heroesofempires.hero.rest;

import hu.javalife.heroesofempires.hero.dao.model.Hero;
import hu.javalife.heroesofempires.hero.dao.model.HeroDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hero")
@Api(value = "/hero", consumes = "application/json")
public class HeroResource {

    @Inject
    HeroDao dao;

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Get Hero by Id", response = Hero.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Hero getHero(@PathParam("id") int pIndex) {
        return dao.getById(pIndex);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() {
        return Response.ok(dao.getAll()).build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Delete by index")
    public void doDelete(@PathParam("id") int pIndex){
        dao.delete(pIndex);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(value ="new hero", 
            notes = "add new Hero",
            response = Hero.class)
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Name of hero not available"),
        @ApiResponse(code = 200, message = "Hero ok")
    })
    public Response addHero(
            @ApiParam(value = "name of hero", required = true) @FormParam("name") String pName,
            @ApiParam(value = "description of hero", required = true) @FormParam("desc") String pDesc) {
        
            Hero newHero = new Hero(pName, pDesc);        
            return Response.ok(dao.add(newHero)).build();
    }

}
