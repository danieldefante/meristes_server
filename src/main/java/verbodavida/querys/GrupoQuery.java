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

	public static String getMembrosGrupoEscalados() {
		return new StringBuilder()
				.append(" select p.idpessoa as \"idPessoa\", p.nome, p.sobrenome ")
				
				
				
				.append(" ,case when ( ")
				.append(" ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') >= e.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') <= e.data_final ) ")
				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') <= e.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') >= e.data_final )")
				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < e.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') < e.data_final and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > e.data_inicial ) ")
				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') > e.data_inicial and to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < e.data_final and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > e.data_final ) ")
				.append(" ) then true else false end as \"escaladoGrupoAtual\" ")
				
				
				
				.append(" ,case when exists (select * from escala es ")
				.append(" inner join vinculo_pessoa_grupo vpg on(vpg.idvinculo_pessoa_grupo = es.vinculo_pessoa_grupo_idvinculo_pessoa_grupo) ")
				.append(" where ( ")
				.append(" ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') >= es.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') <= es.data_final ) ")
				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') <= es.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') >= es.data_final ) ")
				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < es.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') < es.data_final and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > es.data_inicial ) ")
				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') > es.data_inicial and to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < es.data_final and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > es.data_final ) ") 
				.append(" ) and vpg.pessoa_idpessoa = v.pessoa_idpessoa and vpg.grupo_idgrupo != v.grupo_idgrupo ")
				.append(" ) then true else false end as \"escaladoOutroGrupo\" ")
				
				
				
				
				
				.append(" from pessoa p ")
				.append(" inner join vinculo_pessoa_grupo v on(v.pessoa_idpessoa = p.idpessoa) ")
				.append(" inner join grupo g on (g.idgrupo = v.grupo_idgrupo) ")
				.append(" inner join ministerio m on(m.idministerio = g.ministerio_idministerio) ")
				.append(" left join escala e on(e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo = v.idvinculo_pessoa_grupo) ")
				.append(" where v.grupo_idgrupo = :idGrupo and v.ativo = true and v.classificacao_membro_idclassificacao_membro = :idClassificacaoMembro ")
				.append(" ORDER BY p.nome ASC ")
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
			.append(" SELECT p.idpessoa as \"idPessoa\", p.nome, p.sobrenome, ")
			.append(" 		CASE WHEN EXISTS( ") 
			.append(" 		SELECT * FROM vinculo_pessoa_grupo v ")
			.append(" 		INNER JOIN grupo g ON (g.idgrupo = v.grupo_idgrupo) ")
			.append(" 		WHERE v.pessoa_idpessoa = p.idpessoa ")
			.append(" 		AND v.grupo_idgrupo = :idGrupo")
			.append(" 		AND g.ministerio_idministerio = :idMinisterio")
			.append(" 		AND classificacao_membro_idclassificacao_membro = :idClassificacaoMembro")
			.append(" 		AND v.ativo = true ")
			.append("   )THEN true ELSE false END AS ativo ")
			.append(" FROM pessoa p ")
			.append(" ORDER BY p.nome ASC ")
			.toString();
	}
	


}