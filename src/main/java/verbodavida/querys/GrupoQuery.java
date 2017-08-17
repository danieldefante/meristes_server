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

	public static String getPaged() {
		
		return new StringBuilder()
				.append(" SELECT idgrupo AS \"idGrupo\", nome FROM grupo ")
				.append(" WHERE ministerio_idministerio = :idMinisterio ORDER BY nome ASC ")
				.toString();
	}
	
	public static String getQueryCountRegisters() {
		
		return new StringBuilder()
				.append(" SELECT COUNT(*) FROM grupo ")
				.append(" WHERE ministerio_idministerio = :idMinisterio")
				.toString();
	}

	public static String getQueryAllMembros() {
		
		return new StringBuilder()
				.append(" from Pessoa as p")
				.append(" where p.idPessoa =  ministerio.idMinisterio = :idMinisterio ")
				.toString();
	}

	public static String getSQLMembrosGrupo() {
		return new StringBuilder()
			.append(" SELECT p.idpessoa as \"idPessoa\", p.nome, p.sobrenome,")
			.append("CASE WHEN EXISTS( ")
			.append("SELECT * FROM escala e ")
			.append("INNER JOIN vinculo_pessoa_grupo vg ON(v.idvinculo_pessoa_grupo = e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo) ")
			.append("WHERE e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo = v.grupo_idgrupo ")
			.append(") THEN true ELSE false END AS \"escaladoVinculado\" ")
			.append("FROM pessoa p ")
			.append("INNER JOIN vinculo_pessoa_grupo v ON (v.pessoa_idpessoa = p.idpessoa) ")
			.append("WHERE v.grupo_idgrupo = :idGrupo ")
			.append("ORDER BY p.nome ASC ")
			.toString();
	}
	
	public static String getQueryCountMembros() {
		return new StringBuilder()
			.append(" SELECT COUNT(*) FROM pessoa AS p ")
			.append(" INNER JOIN vinculo_pessoa_grupo ON (vinculo_pessoa_grupo.pessoa_idpessoa = p.idpessoa) ")
			.append(" INNER JOIN grupo ON ( grupo.idgrupo = vinculo_pessoa_grupo.grupo_idgrupo ) ")
			.append(" LEFT JOIN escala as e ON ( e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo = vinculo_pessoa_grupo.idvinculo_pessoa_grupo ) ")
			.append(" WHERE grupo.ministerio_idministerio = :idMinisterio AND grupo.idgrupo = :idGrupo ")
			.toString();
	}
	
	public static String getQueryPessoasVinculo() {
		return new StringBuilder()
			.append(" SELECT p.idpessoa, p.nome, p.sobrenome, ")
			.append(" 		CASE WHEN v.grupo_idgrupo = :idGrupo AND v.ativo AND g.ministerio_idministerio = :idMinisterio")
			.append(" 		THEN true ELSE false END AS ativo ")
			.append("   FROM pessoa p ")
			.append(" LEFT JOIN vinculo_pessoa_grupo v ON (v.pessoa_idpessoa = p.idpessoa) ")
			.append(" LEFT JOIN grupo g ON (g.idgrupo = v.grupo_idgrupo) ")
			.append(" ORDER BY p.nome ASC ")
			.toString();
//		return new StringBuilder()
//				.append("SELECT p.idpessoa as \"idPessoa\", p.nome, p.sobrenome, ")
//				.append("	CASE WHEN EXISTS( ")
//				.append("		SELECT * FROM vinculo_pessoa_grupo v ")
//				.append("		INNER JOIN grupo g ON (g.idgrupo = v.grupo_idgrupo ) ")
//				.append("		INNER JOIN pessoa pa ON (pa.idpessoa = v.pessoa_idpessoa) ")
//				.append("		LEFT JOIN funcao_ministerial f ON (f.pessoa_idpessoa = pa.idpessoa) ")
//				.append("		WHERE v.pessoa_idpessoa = p.idpessoa ")
//				.append("		AND v.grupo_idgrupo = :idGrupo ")
//				.append("		AND g.ministerio_idministerio = :idMinisterio ")
//				.append("		AND f.idfuncao_ministerial = :idFuncaoMinisterial ")
//				.append("	) THEN true ELSE false END AS \"escaladoVinculado\" ")
//				.append("FROM pessoa p ")
//				.append("ORDER BY p.nome ASC ")
//				.toString();
	}
	


}