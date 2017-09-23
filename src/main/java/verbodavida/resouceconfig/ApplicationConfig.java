package verbodavida.resouceconfig;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import verbodavida.resouces.EscalaResouce;
import verbodavida.resouces.GrupoResouce;
import verbodavida.resouces.MinisterioResouce;
import verbodavida.resouces.PessoaResouce;


/**
 *
 * @author Daniel
 */
@ApplicationPath("service")
public class ApplicationConfig extends Application  {

	private Set<Object> singletons = new HashSet<>();
    
	public ApplicationConfig() {
    	singletons.add(new PessoaResouce());
    	singletons.add(new EscalaResouce());
    	singletons.add(new MinisterioResouce());
    	singletons.add(new GrupoResouce());
    	singletons.add(new ServiceCorsFilter());
//        packages("resouces");

    }
    
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}