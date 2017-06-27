package verbodavida.controllers;

import verbodavida.eao.PessoaEAO;

public class PessoaController implements IController{

	@Override
	public String insert(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String find(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAll(String data) {

		return PessoaEAO.findAll();
	}

}
