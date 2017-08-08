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

import verbodavida.dtos.GrupoDTO;
import verbodavida.resouceconfig.GerericResouce;
import verbodavida.service.impl.GrupoServiceImpl;
import verbodavida.utils.PagedResult;
import verbodavida.vos.GrupoVO;

@Path(GrupoResouce.PATH)
public class GrupoResouce extends GerericResouce<GrupoDTO, GrupoVO>{
	
	static final String PATH = MinisterioResouce.PATH +"/{idMinisterio}/grupo";
	
	private GrupoServiceImpl grupoServiceImpl = new GrupoServiceImpl();

	@GET
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResult findAll(@QueryParam("page") int page, @QueryParam("size") int size, @PathParam("idMinisterio") Long idMinisterio) {
		return grupoServiceImpl.findAll(page, size, idMinisterio);
	}

	@GET
	@Override
	@Path("/{idGrupo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GrupoDTO find(@PathParam("idMinisterio") Long idMinisterio, @PathParam("idGrupo") Long idGrupo ) {
		
		return grupoServiceImpl.find(idMinisterio, idGrupo);
	}

	@POST
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(GrupoDTO grupoDTO) {
		return grupoServiceImpl.insert(grupoDTO);
	}

	@PUT
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(GrupoDTO grupoDTO) {
		return grupoServiceImpl.update(grupoDTO);
	}

	@DELETE
	@Override
	@Path("/{idGrupo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("idMinisterio") Long idMinisterio, @PathParam("idGrupo") Long idGrupo) {
		return grupoServiceImpl.delete(idGrupo);
	}
	
}
