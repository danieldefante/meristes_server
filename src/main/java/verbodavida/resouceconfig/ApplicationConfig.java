package verbodavida.resouceconfig;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


/**
 *
 * @author Daniel
 */
@ApplicationPath("service")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("resouces");
    }
}