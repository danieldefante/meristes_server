package verbodavida.resouces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import verbodavida.dtos.PessoaDTO;
import verbodavida.resouceconfig.GerericResouce;
import verbodavida.service.impl.PessoaServiceImpl;
import verbodavida.utils.PagedResult;
import verbodavida.vos.PessoaVO;

@Path(PessoaResouce.PATH)
public class PessoaResouce extends GerericResouce<PessoaDTO, PessoaVO>{

    private PessoaServiceImpl pessoaServiceImpl = new PessoaServiceImpl();
    
    static final String PATH = "/pessoa";

    @Context
    private UriInfo context;

    public PessoaResouce() {
    }

    @GET
    @Override
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PagedResult<PessoaVO> findPaged(@QueryParam("page") int page, @QueryParam("size") int size) {
    	
    	return pessoaServiceImpl.findPaged(page, size);
    }

    @GET
    @Override
    @Path("/{idPessoa}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PessoaDTO find(@PathParam("idPessoa") Long idPessoa) {
    	
    	return pessoaServiceImpl.find(idPessoa);
    }
    
    @POST
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String insert(PessoaDTO pessoaDTO) {

    	return pessoaServiceImpl.insert(pessoaDTO);
	}

    @PUT
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(PessoaDTO pessoaDTO) {

    	return pessoaServiceImpl.update(pessoaDTO);
    }

    @DELETE
    @Override
    @Path("/{idPessoa}")
    public String delete(@PathParam("idPessoa") Long idPessoa ) {
    	
    	return pessoaServiceImpl.delete(idPessoa);
    }

}
