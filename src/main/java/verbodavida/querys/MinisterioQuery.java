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
				.append(" SELECT COUNT(*) FROM ministerio ")
				.toString();
	}

	public static String getPaged() {
		return new StringBuilder()
				.append(" SELECT idministerio as \"idMinisterio\", nome, descricao FROM ministerio ORDER BY nome ASC ")
				.toString();
	}
}
