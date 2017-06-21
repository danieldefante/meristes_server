/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbodavida.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

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

    /**
     * Retrieves representation of an instance of verbodavida.ServicesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("te")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("teste", "Jesus Cristo");
        return jsonObject.toString();
    }

}
