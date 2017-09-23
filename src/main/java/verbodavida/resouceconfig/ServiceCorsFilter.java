package verbodavida.resouceconfig;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceCorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:4200");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, application/json");
//        		+ "accept, "
//        		+ "authorization, "
//        		+ "x-requested-with, "
//        		+ "application/x-www-form-urlencoded, "
//        		+ "multipart/form-data, "
//        		+ "text/plain, "
//        		+ "application/xml");                       
    }    
}