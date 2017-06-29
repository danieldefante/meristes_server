package verbodavida.services;

import java.util.Date;
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

import verbodavida.controllers.PessoaController;
import verbodavida.entities.Contato;
import verbodavida.entities.Endereco;
import verbodavida.entities.Pessoa;

@Path(PessoaService.PATH)
public class PessoaService {

    static final String PATH = "pessoa";
    private PessoaController pessoaController = new PessoaController();

    @Context
    private UriInfo context;

    public PessoaService() {
    }

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> findAll() {
    	
    	return pessoaController.findAll();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Pessoa find(@PathParam("id") Long id) {
    	
//    	return pessoaController.find(id);
    	
    	Pessoa a = new Pessoa();
    		Contato c = new Contato();
    		Date datanascimento = new Date();
	    	c.setCelular("98323223");
	    	c.setCelularTwo("9908088");
	    	c.setEmail("asdf@eddf");
	    	c.setTelefone("23232323");
	    	c.setTelefoneTwo("23423432");
		a.setContato(c);
		a.setDatanascimento(datanascimento);
    		Endereco e = new Endereco();
    		e.setBairro("Veneza");
    		e.setCep("343434");
    		e.setComplemento("saadsffa");
    		e.setNumero(67);
    		e.setRua("Italia");
		a.setEndereco(e);
		a.setNome("Daniel");
		a.setSobrenome("Defante");
		
		
		
		return a;
    }
    
    @POST
	@Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String insert(Pessoa pessoa) {

    	return pessoaController.insert(pessoa);
	}

    @DELETE
    @Path("/delete/{id}")
    public String delete(@PathParam("id") Long id ) {
    	
    	return pessoaController.delete(id);
    }

}
