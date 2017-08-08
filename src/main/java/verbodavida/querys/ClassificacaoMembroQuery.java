package verbodavida.querys;

public class ClassificacaoMembroQuery {


	public static String getQueryByIdMinisterio() {
		
		return new StringBuilder()
				.append(" from ClassificacaoMembro as c ")
				.append(" where c.ministerio.idMinisterio = :idMinisterio ")
				.toString();
	}

	public static String getQuery() {
		
		return new StringBuilder()
				.append(" from ClassificacaoMembro as c ")
				.append(" where c.ministerio.idMinisterio = :idMinisterio ")
				.append(" and c.idClassificacaoMembro = :idClassificacaoMembro ")
				.toString();
	}
	
	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" select count(*) from ClassificacaoMembro as c")
				.append(" where c.ministerio.idMinisterio = :idMinisterio")
				.toString();
	}

}