package verbodavida.querys;

public class ClassificacaoMembroQuery {


	public static String getPaged() {
		return new StringBuilder()
				.append(" SELECT idclassificacao_membro AS \"idClassificacaoMembro\", descricao FROM classificacao_membro ")
				.append(" where ministerio_idministerio = :idMinisterio ORDER BY descricao ASC ")
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
				.append(" SELECT COUNT(*) FROM classificacao_membro ")
				.append(" WHERE ministerio_idministerio = :idMinisterio")
				.toString();
	}

}