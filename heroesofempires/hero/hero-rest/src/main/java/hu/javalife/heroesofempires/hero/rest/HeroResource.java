package hu.javalife.heroesofempires.hero.rest;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/hero")
@ApplicationScoped
public class HeroResource {
    private Hero hero = new Hero();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet() {
		return Response.ok(hero).build();
	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
        @Path("/dirct")
	public Hero doGetHero() {
		return hero;
	}
        
        @POST
	@Produces(MediaType.APPLICATION_JSON)
	public Hero setHero(@FormParam("name") String pName) {
            hero.setName(pName);
            return hero;
	}
        
        
        
}