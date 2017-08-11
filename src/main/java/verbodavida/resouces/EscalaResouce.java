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
import javax.ws.rs.core.MediaType;

import verbodavida.dtos.EscalaDTO;
import verbodavida.resouceconfig.GerericResouce;
import verbodavida.service.impl.EscalaServiceImpl;
import verbodavida.utils.PagedResult;
import verbodavida.vos.EscalaVO;

@Path(EscalaResouce.PATH)
public class EscalaResouce extends GerericResouce<EscalaDTO, EscalaVO> {

	private EscalaServiceImpl escalaServiceImpl = new EscalaServiceImpl();
	
	static final String PATH = GrupoResouce.PATH +"/{idGrupo}/escala";
	
	@GET
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResult<EscalaVO> findAll(@QueryParam("page") int page, @QueryParam("size") int size) {
		 escalaServiceImpl.findAll(page, size);
		 return null;
	}

	@GET
	@Override
	@Path("/{idEscala}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EscalaDTO find(@PathParam("idEscala") Long idEscala) {
		return escalaServiceImpl.find(idEscala);
	}

	@POST
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(EscalaDTO escalaDTO) {
		return escalaServiceImpl.insert(escalaDTO);
	}

	@PUT
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(EscalaDTO escalaDTO) {
		return escalaServiceImpl.update(escalaDTO);
	}

	@DELETE
	@Override
	@Path("/{idEscala}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("idEscala") Long idEscala) {
		return escalaServiceImpl.delete(idEscala);
	}
}
