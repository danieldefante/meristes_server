package verbodavida.querys;

public class GrupoQuery {


	public static String getQueryByIdMinisterio() {
		
		return new StringBuilder()
				.append(" from Grupo as g ")
				.append(" where g.ministerio.idMinisterio = :idMinisterio ")
				.toString();
	}

	public static String getQuery() {
		
		return new StringBuilder()
				.append(" from Grupo as g ")
				.append(" where g.ministerio.idMinisterio = :idMinisterio ")
				.append(" and g.idGrupo = :idGrupo ")
				.toString();
	}
	
	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" select count(*) from Grupo as g")
				.append(" where g.ministerio.idMinisterio = :idMinisterio")
				.toString();
	}

}