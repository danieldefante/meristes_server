package verbodavida.querys;

public class EscalaQuery {

	public static String getQueryCountRegistersMembros() {
		return new StringBuilder()
				.append(" select count(*) from Grupo as g")
				.append(" where g.ministerio.idMinisterio = :idMinisterio")
				.toString();
	}
	
}