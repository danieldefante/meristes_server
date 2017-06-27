
package verbodavida.serviceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * REST Web Service
 *
 * @author daniel
 */
@Path("nha")

public class ServicosOutros {

    @Context
    private UriInfo context;

//    @Inject
//    private OutletService outletService;
   
    public ServicosOutros() {
    }

    
    
  
   
   @GET
   @Path("testegets")  
//   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public String testeget() throws Exception{
        

        
        JSONArray  ja = new JSONArray();

        ja.put("GET");
        ja.put("serviço");
        ja.put("retorno");
        ja.put("teste");
        ja.put("bioid");
        
        return ja.toString();
        
//        PessoaController pessoaController = new	PessoaController();
//		 return pessoaController.findAll("s");
   }
   
   @POST
   @Path("testepost")  
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public String testepost(String dataJson) throws Exception{
        
        JSONObject k = new JSONObject(dataJson);
        

        
        JSONArray  ja = new JSONArray();

        ja.put("POST");
        ja.put("serviço");
        ja.put("retorno");
        ja.put(k.get("valores"));

        
        return ja.toString();
   }
   

   
}
