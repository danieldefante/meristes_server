package verbodavida.validators;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import verbodavida.eaos.EscalaEAO;
import verbodavida.entities.Escala;
import verbodavida.utils.OQJFException;

public class ValidatorEscala implements IValidador<Escala> {

	public void validarEscalaConflito(Escala escala) {
		EscalaEAO escalaEAO = new EscalaEAO();
		
		List<Escala> listEscalaConflito = escalaEAO.findConflito(escala.getVinculoPessoaGrupo().getIdVinculoPessoaGrupo(), 
																 escala.getDataInicial(), 
																 escala.getDataFinal());
		
		if(listEscalaConflito != null ){
			
			if(!listEscalaConflito.isEmpty()){
				throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Escala em Conflito!");
			}	
		}
	}

	@Override
	public void fieldsRequireds(Escala escala) {

		String[] nameFields = {"vinculoPessoaGrupo", "dataInicial", "dataFinal"};
		
		ValidatorFields.fieldsRequired(escala, nameFields);
		

	}

}
