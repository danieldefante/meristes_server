package verbodavida.servicesimpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import verbodavida.controllers.MinisterioController;
import verbodavida.dtos.MinisterioDTO;
import verbodavida.services.IService;
import verbodavida.vos.MinisterioVO;

@Path("/ministerio")
public class MinisterioService implements IService<MinisterioDTO, MinisterioVO>{

    private MinisterioController ministerioController = new MinisterioController();

    @Context
    private UriInfo context;

    public MinisterioService() {
    }

    @GET
    @Override
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MinisterioVO> findAll() {
    	
    	return ministerioController.findAll();
    }

    @GET
    @Override
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MinisterioDTO find(@PathParam("id") Long id) {
    	
    	return ministerioController.find(id);
    }
    
    @POST
    @Override
	@Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String insert(MinisterioDTO ministerioDTO) {

    	return ministerioController.insert(ministerioDTO);
	}

    @PUT
    @Override
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(MinisterioDTO ministerioDTO) {
    	
    	return ministerioController.insert(ministerioDTO);
    }

    @DELETE
    @Override
    @Path("/delete/{id}")
    public String delete(@PathParam("id") Long id ) {
    	
    	return ministerioController.delete(id);
    }

}
