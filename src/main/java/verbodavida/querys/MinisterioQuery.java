package verbodavida.querys;

public class MinisterioQuery {


	public static String queryCreate() {
		
		return new StringBuilder()
				.append(" from Ministerio ")
				.append(" where idMinisterio = :idMinisterio")
				.toString();
	}
	
	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" select count(*) from Ministerio ")
				.toString();
	}
}
