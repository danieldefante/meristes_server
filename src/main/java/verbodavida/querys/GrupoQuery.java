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
				.append(" SELECT COUNT(*) FROM grupo ")
				.append(" WHERE ministerio_idministerio = :idMinisterio")
				.toString();
	}

	public static String getQueryAllMembros() {
		
		return new StringBuilder()
				.append(" from Pessoa as p")
				.append(" where p.idPessoa =  ministerio.idMinisterio = :idMinisterio")
				.toString();
	}
	
//	(SELECT COUNT(*) FROM pessoa INNER JOIN vinculo_pessoa_grupo ON (vinculo_pessoa_grupo.pessoa_idpessoa = pessoa.idpessoa) 
//	INNER JOIN grupo ON ( grupo.idgrupo = vinculo_pessoa_grupo.grupo_idgrupo ) 
//	INNER JOIN escala ON ( escala.vinculo_pessoa_grupo_idvinculo_pessoa_grupo = vinculo_pessoa_grupo.idvinculo_pessoa_grupo ) 
//	WHERE grupo.ministerio_idministerio = 3 AND grupo.idgrupo = 1 ) 


	public static String getSQLMembrosGrupo() {
		return new StringBuilder()
				.append(" from Pessoa as p ")
				.append(" left join fetch p.vinculoPessoaGrupos v ")
				.append(" left join fetch v.grupo as g ")
				.append(" left join fetch g.ministerio m ")
				.append(" where m.idMinisterio = :idMinisterio and g.idGrupo = :idGrupo ")
				.append(" ")
				.toString();
//		return new StringBuilder()
//			.append(" SELECT p.idpessoa AS \"idPessoa\", p.contato_idcontato, p.endereco_idendereco, p.nome, p.sobrenome, p.datanascimento, ")
//			.append(" CASE WHEN EXISTS ")
//			.append(" ( SELECT vinculo_pessoa_grupo_idvinculo_pessoa_grupo FROM escala ")
//			.append(" INNER JOIN vinculo_pessoa_grupo ON (vinculo_pessoa_grupo.idvinculo_pessoa_grupo = escala.vinculo_pessoa_grupo_idvinculo_pessoa_grupo) ")
//			.append(" WHERE vinculo_pessoa_grupo_idvinculo_pessoa_grupo = e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo ")
//			.append(" ) THEN true ELSE false END AS escalado FROM pessoa p ")
//			.append(" INNER JOIN vinculo_pessoa_grupo ON (vinculo_pessoa_grupo.pessoa_idpessoa = p.idpessoa) ")
//			.append(" INNER JOIN grupo ON ( grupo.idgrupo = vinculo_pessoa_grupo.grupo_idgrupo ) ")
//			.append(" LEFT JOIN escala as e ON ( e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo = vinculo_pessoa_grupo.idvinculo_pessoa_grupo ) ")
//			.append(" WHERE grupo.ministerio_idministerio = :idMinisterio AND grupo.idgrupo = :idGrupo ")
//			.toString();
	}
	
	public static String getQueryCountPessoasByGrupo() {
		return new StringBuilder()
			.append(" SELECT COUNT(*) FROM pessoa AS p ")
			.append(" INNER JOIN vinculo_pessoa_grupo ON (vinculo_pessoa_grupo.pessoa_idpessoa = p.idpessoa) ")
			.append(" INNER JOIN grupo ON ( grupo.idgrupo = vinculo_pessoa_grupo.grupo_idgrupo ) ")
			.append(" LEFT JOIN escala as e ON ( e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo = vinculo_pessoa_grupo.idvinculo_pessoa_grupo ) ")
			.append(" WHERE grupo.ministerio_idministerio = :idMinisterio AND grupo.idgrupo = :idGrupo ")
			.toString();
	}


}