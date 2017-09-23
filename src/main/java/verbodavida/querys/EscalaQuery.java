package verbodavida.querys;

public class EscalaQuery {

	public static String getQueryCountRegistersMembros() {
		return new StringBuilder()
				.append(" select count(*) from Grupo as g")
				.append(" where g.ministerio.idMinisterio = :idMinisterio")
				.toString();
	}
	
	public static String getHQLEscalaConflito(){
		return new StringBuilder()
			.append(" from Escala e ")
			.append(" where ( ")
			.append(" ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') >= e.dataInicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') <= e.dataFinal ) ")
			.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') <= e.dataInicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') >= e.dataFinal ) ")
			.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < e.dataInicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') < e.dataFinal and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > e.dataInicial ) ")
			.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') > e.dataInicial and to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < e.dataFinal and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > e.dataFinal )  ")
			.append(" ) and e.vinculoPessoaGrupo.idVinculoPessoaGrupo  = :idVinculoPessoaGrupo ")
			.toString();
//		return new StringBuilder()
//				.append(" select * from escala e ")
//				.append(" inner join vinculo_pessoa_grupo v on(v.idvinculo_pessoa_grupo = e.vinculo_pessoa_grupo_idvinculo_pessoa_grupo) ")
//				.append(" where ( ")
//				.append(" ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') >= e.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') <= e.data_final ) ")
//				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') <= e.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') >= e.data_final ) ")
//				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < e.data_inicial and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') < e.data_final and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > e.data_inicial ) ")
//				.append(" or ( to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') > e.data_inicial and to_timestamp( :dataInicial , 'YYYY-MM-DD HH24:MI:SS') < e.data_final and to_timestamp( :dataFinal , 'YYYY-MM-DD HH24:MI:SS') > e.data_final )  ")
//				.append(" ) and v.idvinculo_pessoa_grupo  = :idVinculoPessoaGrupo ")
//				.toString();
		
	}
}