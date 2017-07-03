package verbodavida.controllers;

import static verbodavida.dtos.ConverterEntity.converterEntetyToListVO;
import static verbodavida.dtos.ConverterEntity.converterEntity;

import java.util.List;

import verbodavida.dtos.PessoaDTO;
import verbodavida.eaos.PessoaEAO;
import verbodavida.entities.Pessoa;
import verbodavida.vos.PessoaVO;

public class PessoaController implements IController<PessoaDTO, PessoaVO> {

	private PessoaEAO pessoaEAO = new PessoaEAO();
	
	@Override
	public String insert(PessoaDTO pessoa) {
		return pessoaEAO.insert(converterEntity(Pessoa.class, pessoa));
	}

	@Override
	public String update(PessoaDTO pessoa) {
		return pessoaEAO.update(converterEntity(Pessoa.class, pessoa));
	}

	@Override
	public String delete(Long id) {
		return pessoaEAO.delete(id);
	}

	@Override
	public PessoaDTO find(Long id) {
		return converterEntity(
				PessoaDTO.class,
				pessoaEAO.find(Pessoa.class, id));
	}

	@Override
	public List<PessoaVO> findAll() {
		
		return converterEntetyToListVO(
				PessoaVO.class,
				pessoaEAO.findAll(Pessoa.class));
	}
}
