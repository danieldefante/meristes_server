package verbodavida.utils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public final class OQJFException extends WebApplicationException {
	
	private static final long serialVersionUID = 1149241039409861914L;
	
	public OQJFException(Status status, String msg){
		
		super(setMessage(status, msg));
    }

	private static Response setMessage(Status status, String msg) {
		return Response.status(status).entity(msg).build();
	}

}
