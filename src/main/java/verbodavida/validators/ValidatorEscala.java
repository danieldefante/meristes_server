package verbodavida.validators;

import verbodavida.eaos.EscalaEAO;
import verbodavida.entities.Escala;
import verbodavida.utils.VDVException;

public class ValidatorEscala implements IValidador<Escala> {

	EscalaEAO escalaEAO = new EscalaEAO();
	
	public void validarEscalaConflito(Escala escala){
	
//		Escala escala = escalaEAO.find(Escala.class, this.escala.getIdEscala());
//		
//		if(escala != null){
//			
//			throw new VDVException("dsadssdad");
//		}
	}
	
	public static void main(String[] args) {
		throw new VDVException("dsadssdad");
				
		
	}

	@Override
	public Boolean camposObrigatorios(Escala entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
