package verbodavida.querys;

public class FuncaoMinisterialQuery {


	public static String getPagedPessoa() {
		return new StringBuilder()
				.append(" SELECT f.idfuncao_ministerial AS \"idFuncaoMinisterial\" , c.descricao ")
				.append("FROM funcao_ministerial f ")
				.append("INNER JOIN classificacao_membro c ON(c.idclassificacao_membro = f.classificacao_membro_idclassificacao_membro) ")
				.append("INNER JOIN pessoa p ON(p.idpessoa = f.pessoa_idpessoa) ")
				.append("WHERE c.ministerio_idministerio = :idMinisterio AND p.idpessoa = :idPessoa")
				.toString();
	}
	
	public static String getQueryCountRegistersPessoa() {
		
		return new StringBuilder()
				.append(" SELECT COUNT(*) ")
				.append(" FROM funcao_ministerial f ")
				.append(" INNER JOIN classificacao_membro c ON(c.idclassificacao_membro = f.classificacao_membro_idclassificacao_membro) ")
				.append(" INNER JOIN pessoa p ON(p.idpessoa = f.pessoa_idpessoa) ")
				.append(" WHERE c.ministerio_idministerio = :idMinisterio AND p.idpessoa = :idPessoa ")
				.toString();
	}

	public static String getPagedMinisterio() {
		return new StringBuilder()
				.append(" SELECT cm.descricao, cm.idclassificacao_membro AS \"idFuncaoMinisterial\" FROM classificacao_membro cm ")
				.append(" WHERE ministerio_idministerio = :idMinisterio ")
				.toString();
	}
	
	public static String getQueryCountRegistersMinisterio() {
		return new StringBuilder()
				.append(" SELECT COUNT(*) FROM classificacao_membro ")
				.append(" WHERE ministerio_idministerio = :idMinisterio ")
				.toString();
	}

}