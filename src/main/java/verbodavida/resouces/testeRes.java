package verbodavida.resouces;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import verbodavida.vos.PessoaVO;

@Path(testeRes.PATH)
public class testeRes {

    
    static final String PATH = "/teste";

    @Context
    private UriInfo context;

    public testeRes() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
    	
    	List<PessoaVO> result = new ArrayList<PessoaVO>();
    	
    	PessoaVO e = new PessoaVO();
    	e.setIdPessoa(1L);
    	e.setNome("joso");
    	e.setSobrenome("marmota");
		result.add(e);
		
		PessoaVO a = new PessoaVO();
		a.setIdPessoa(2L);
		a.setNome("josnao");
		a.setSobrenome("mamamama");
		result.add(a);
		
		JSONObject j = new JSONObject();
		j.put("data", result);
    	return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(j.toString())
                .build();
    	
    }


}
