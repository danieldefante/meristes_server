package verbodavida.eaos;

import static verbodavida.querys.EscalaQuery.getHQLEscalaConflito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import verbodavida.entities.Escala;

public class EscalaEAO extends IEAO {
	
	public List<Escala> findConflito(Long idVinculoPessoaGrupo, Date dataInicial, Date dataFinal){
		return executeHQLResultList(Escala.class, 
								   getHQLEscalaConflito(), 
								   Arrays.asList("idVinculoPessoaGrupo", "dataInicial", "dataFinal"), 
								   Arrays.asList(idVinculoPessoaGrupo, dataInicial, dataFinal));
	}

}
