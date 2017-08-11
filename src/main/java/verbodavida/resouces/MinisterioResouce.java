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

import verbodavida.dtos.MinisterioDTO;
import verbodavida.resouceconfig.GerericResouce;
import verbodavida.service.impl.MinisterioServiceImpl;
import verbodavida.utils.PagedResult;
import verbodavida.vos.ClassificacaoMembroVO;
import verbodavida.vos.MinisterioVO;

@Path(MinisterioResouce.PATH)
public class MinisterioResouce extends GerericResouce<MinisterioDTO, MinisterioVO>{

	static final String PATH = "/ministerio";
	
    private MinisterioServiceImpl ministerioServiceImpl = new MinisterioServiceImpl();

    @Context
    private UriInfo context;

    public MinisterioResouce() {
    }

    @GET
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public PagedResult<MinisterioVO> findAll(@QueryParam("page") int page, @QueryParam("size") int size) {
    	return ministerioServiceImpl.findAll(page, size);
    }

    @GET
    @Override
    @Path("/{idMinisterio}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MinisterioDTO find(@PathParam("idMinisterio") Long idMinisterio) {
    	
    	return ministerioServiceImpl.find(idMinisterio);
    }
    
    @POST
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String insert(MinisterioDTO ministerioDTO) {

    	return ministerioServiceImpl.insert(ministerioDTO);
	}

    @PUT
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(MinisterioDTO ministerioDTO) {
    	return ministerioServiceImpl.update(ministerioDTO);
    }

    @DELETE
    @Override
    @Path("/{idMinisterio}")
    public String delete(@PathParam("idMinisterio") Long idMinisterio ) {
    	
    	return ministerioServiceImpl.delete(idMinisterio);
    }
    
    @GET
 	@Consumes(MediaType.APPLICATION_JSON)
 	@Produces(MediaType.APPLICATION_JSON)
     public PagedResult<ClassificacaoMembroVO> findClassificacaoByMinisterio(@QueryParam("page") int page, @QueryParam("size") int size) {
     	return ministerioServiceImpl.findClassificacaoByMinisterio(page, size);
     }

}
