package verbodavida.controllers;

import java.util.List;
import verbodavida.eao.PessoaEAO;
import verbodavida.entities.Pessoa;

public class PessoaController implements IController<Pessoa> {

	private PessoaEAO pessoaEAO = new PessoaEAO();
	
	@Override
	public String insert(Pessoa pessoa) {
		return pessoaEAO.insert(pessoa);
	}

	@Override
	public String update(Pessoa pessoa) {
		return pessoaEAO.update(pessoa);
	}

	@Override
	public String delete(Long id) {
		return pessoaEAO.delete(id);
	}

	@Override
	public Pessoa find(Long id) {
		return pessoaEAO.find(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> findAll() {
		return pessoaEAO.findAll(Pessoa.class);
	}
}
