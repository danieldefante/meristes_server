package verbodavida.validators;

import verbodavida.eaos.EscalaEAO;
import verbodavida.entities.Escala;
import verbodavida.utils.VDVException;

public class ValidadorEscala implements IValidador {

	EscalaEAO escalaEAO = new EscalaEAO();
	
	Escala escala = new Escala();
	
	public ValidadorEscala(Escala escala) {
		this.escala = escala;
	}
	
	public void validarEscalaConflito(){
	
//		Escala escala = escalaEAO.find(Escala.class, this.escala.getIdEscala());
//		
//		if(escala != null){
//			
//			throw new VDVException("dsadssdad");
//		}
	}
	
	@Override
	public <T> Boolean camposObrigatorios(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args) {
		throw new VDVException("dsadssdad");
				
		
	}
}
