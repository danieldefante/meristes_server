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
import javax.ws.rs.core.MediaType;
import verbodavida.controllers.GrupoController;
import verbodavida.dtos.GrupoDTO;
import verbodavida.services.IService;
import verbodavida.vos.GrupoVO;

@Path("/grupo")
public class GrupoService implements IService<GrupoDTO, GrupoVO>{
	
	private GrupoController grupoController = new GrupoController();

	@GET
	@Override
	@Path("/findall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<GrupoVO> findAll() {
		return grupoController.findAll();
	}

	@GET
	@Override
	@Path("/find/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GrupoDTO find(@PathParam("id") Long id) {
		return grupoController.find(id);
	}

	@POST
	@Override
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(GrupoDTO grupoDTO) {
		return grupoController.insert(grupoDTO);
	}

	@PUT
	@Override
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(GrupoDTO grupoDTO) {
		return grupoController.update(grupoDTO);
	}

	@DELETE
	@Override
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(Long id) {
		return grupoController.delete(id);
	}
	
}
