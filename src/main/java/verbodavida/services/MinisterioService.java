package verbodavida.services;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import verbodavida.controllers.MinisterioController;
import verbodavida.entities.Ministerio;

@Path(MinisterioService.PATH)
public class MinisterioService {

    static final String PATH = "ministerio";
    private MinisterioController ministerioController = new MinisterioController();

    @Context
    private UriInfo context;

    public MinisterioService() {
    }

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ministerio> findAll() {
    	
    	return ministerioController.findAll();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Ministerio find(@PathParam("id") Long id) {
    	
    	return ministerioController.find(id);
    }
    
    @POST
	@Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String insert(Ministerio ministerio) {

    	return ministerioController.insert(ministerio);
	}

    @DELETE
    @Path("/delete/{id}")
    public String delete(@PathParam("id") Long id ) {
    	
    	return ministerioController.delete(id);
    }

}
