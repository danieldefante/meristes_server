package verbodavida.serviceImpl;

import java.util.Date;
import verbodavida.service.IService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;

import verbodavida.controllers.PessoaController;
import verbodavida.entities.Pessoa;
import verbodavida.utils.PersistDB;

/**
 * REST Web Service
 *
 * @author daniel
 */
@Path(PessoaService.PATH)
public class PessoaService implements IService {

	static final String PATH = "pessoas";

	@Context
	private UriInfo context;

	public PessoaService() {
	}


	@POST
	@Path("insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public String insert(String data) {
		
		
		
		
		
		return null;
	}

	@Override
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Path("find")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String find(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Path("findall")
//	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findAll() {
		String data = "ds";

		
		
		PessoaController pessoaController = new	PessoaController();
		 String a = pessoaController.findAll(data);
		
		
		JSONArray ja = new JSONArray();

		ja.put("GET");
		ja.put("serviço");
		ja.put("retorno");
		ja.put("teste");
		ja.put("bioid");

		return ja.toString();
		
		
	}


	@GET
	@Path("testeget")
	@Produces(MediaType.APPLICATION_JSON)
	public String testeget() throws Exception {

            
            Pessoa pessoa = new Pessoa();
            
//            pessoa.setCelular("234234234");
//            pessoa.setDatanascimento(new Date());
//            pessoa.setNome("Espirito santo");
//            pessoa.setSobrenome("Eterno");
//            pessoa.setTelefone("679878787");
            PersistDB.persistDB(pessoa);
            
		JSONArray ja = new JSONArray();

		ja.put("GET");
		ja.put("serviço");
		ja.put("retorno");
		ja.put("teste");
		ja.put("bioid");

		return ja.toString();
	}
}