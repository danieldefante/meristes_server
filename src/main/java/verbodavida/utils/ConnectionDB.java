package verbodavida.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDB {

	
	public static EntityManager createFactory(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("verbodavida");
		
		return factory.createEntityManager();
	}
	
}
