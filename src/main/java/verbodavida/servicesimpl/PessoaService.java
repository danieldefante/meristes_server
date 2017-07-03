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

import verbodavida.controllers.PessoaController;
import verbodavida.dtos.PessoaDTO;
import verbodavida.services.IService;
import verbodavida.vos.PessoaVO;

@Path("/pessoa")
public class PessoaService implements IService<PessoaDTO, PessoaVO>{

    private PessoaController pessoaController = new PessoaController();

    @Context
    private UriInfo context;

    public PessoaService() {
    }

    @GET
    @Override
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PessoaVO> findAll() {
    	
    	return pessoaController.findAll();
    }

    @GET
    @Override
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PessoaDTO find(@PathParam("id") Long id) {
    	
    	return pessoaController.find(id);
    }
    
    @POST
    @Override
	@Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String insert(PessoaDTO pessoaDTO) {

    	return pessoaController.insert(pessoaDTO);
	}

    @PUT
    @Override
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(PessoaDTO pessoaDTO) {
    	
    	return pessoaController.update(pessoaDTO);
    }

    @DELETE
    @Override
    @Path("/delete/{id}")
    public String delete(@PathParam("id") Long id ) {
    	
    	return pessoaController.delete(id);
    }

}
