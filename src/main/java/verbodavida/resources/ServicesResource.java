/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbodavida.resources;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import verbodavida.entities.Ministerio;
import verbodavida.entities.Pessoa;
import static verbodavida.utils.FactoryGeneric.insertDB;
import verbodavida.utils.PersistDB;

/**
 * REST Web Service
 *
 * @author daniel
 */
@Path("teste")
public class ServicesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicesResource
     */
    public ServicesResource() {
    }
    
    @GET
    @Path("te")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        Ministerio ministerio = new Ministerio();

        ministerio.setNome("Teatro");
        ministerio.setDescricao("teatro do evangelismo vai ser tremendo");
//        em.persist(ministerio);
        try {
            PersistDB.persistDB(ministerio);
        } catch (Exception ex) {
            Logger.getLogger(ServicesResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("teste", "Jesus Cristo");
        return jsonObject.toString();
    }

}
