package verbodavida.querys;

import verbodavida.dtos.MinisterioDTO;
import verbodavida.utils.PersistDB;

public class MinisterioQuery implements IQuery {

	
	public static String queryCreate(Long idministerio) {
		
		return new StringBuilder()
				.append(" from ministerio ")
				.append(" where idministerio = '1'")
				.toString();
	}

	
	
	
	public static void main(String[] args) {
		
		String queryCreate = queryCreate(1L);
		
		System.out.println(queryCreate);
		
		MinisterioDTO m = (MinisterioDTO) PersistDB.executeQuery(queryCreate);
		
	}
}
