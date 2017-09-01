package verbodavida.validators;

import verbodavida.entities.Pessoa;
import verbodavida.utils.VDVException;

public class ValidatorPessoa implements IValidador<Pessoa> {
	
	@Override
	public Boolean camposObrigatorios(Pessoa pessoa) {

		
		return null;
	}

	public void validarPessoaConflito(){
	
	}

	public static void main(String[] args) {
		throw new VDVException("dsadssdad");
				
		
	}

}
