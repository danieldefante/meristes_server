package verbodavida.service.impl;

import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.querys.PessoaQuery.getPaged;
import static verbodavida.querys.PessoaQuery.getQueryCountRegisters;

import java.math.BigInteger;
import java.util.List;

import verbodavida.dtos.PessoaDTO;
import verbodavida.eaos.PessoaEAO;
import verbodavida.entities.Pessoa;
import verbodavida.services.PessoaService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.VDVException;
import verbodavida.vos.PessoaVO;

public class PessoaServiceImpl extends PessoaService<PessoaDTO, PessoaVO> {

	private PessoaEAO pessoaEAO = new PessoaEAO();
	
	@Override
	public PagedResult<PessoaVO> findPaged(int page, int size) {
		BeanConsultGroup beanConsultaGroup = new BeanConsultGroup(page, size);
		
		List<PessoaVO> pessoaVOList = pessoaEAO.executeSQLPaged(PessoaVO.class, beanConsultaGroup, getPaged());
		
		BigInteger sizeDB = pessoaEAO.executeSQLOneResult(getQueryCountRegisters());
		
			
		return new PagedResult<PessoaVO>(sizeDB, pessoaVOList);
	}

	@Override
	public PessoaDTO find(Long idPessoa) {
		Pessoa pessoa = pessoaEAO.find(Pessoa.class, idPessoa);

		if(!pessoa.equals(null)){
			PessoaDTO pessoaDTO = converterDTO( PessoaDTO.class, pessoa);
			
			return pessoaDTO;
		}else {
			throw new VDVException("Erro ao buscar pessoa.");
		}
	}

	@Override
	public String insert(PessoaDTO pessoaDTO) {
		Pessoa pessoa = converterDTO(Pessoa.class, pessoaDTO);
		
		if(!pessoa.equals(null)){
			
			return pessoaEAO.insert(pessoa);
		}else {
			throw new VDVException("Erro ao inserir pessoa.");
		}
	}

	@Override
	public String update(PessoaDTO pessoaDTO) {
		Pessoa pessoa = converterDTO(Pessoa.class, pessoaDTO);
		
		if(!pessoa.equals(null)){
			
			return pessoaEAO.update(pessoa);
		}else {
			throw new VDVException("Erro ao atualizar pessoa.");
		}
	}

	@Override
	public String delete(Long idPessoa) {
		Pessoa pessoa = pessoaEAO.find(Pessoa.class, idPessoa);
		
		if(!pessoa.equals(null)){
			return pessoaEAO.delete(idPessoa);
		}else {
			throw new VDVException("Erro ao excluir pessoa.");
		}
	}

}
