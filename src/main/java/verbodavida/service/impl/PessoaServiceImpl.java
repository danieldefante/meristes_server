package verbodavida.service.impl;

import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.PessoaQuery.getQueryCountRegisters;

import java.util.List;

import verbodavida.dtos.PessoaDTO;
import verbodavida.eaos.PessoaEAO;
import verbodavida.entities.Pessoa;
import verbodavida.services.PessoaService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.vos.PessoaVO;

public class PessoaServiceImpl extends PessoaService<PessoaDTO, PessoaVO> {

	private PessoaEAO pessoaEAO = new PessoaEAO();
	
	@Override
	public PagedResult findAll(int page, int size) {
		BeanConsultGroup beanConsultaGroup = new BeanConsultGroup(page, size);
		List<PessoaVO> pessoaVOList = converterDTOList(PessoaVO.class,
				pessoaEAO.findAll(Pessoa.class, beanConsultaGroup));
		return new PagedResult(countRegister(), pessoaVOList);
	}

	@Override
	public PessoaDTO find(Long idPessoa) {
		Pessoa pessoa = pessoaEAO.find(Pessoa.class, idPessoa);

		return pessoa == null ? null : 
			converterDTO( PessoaDTO.class, pessoa);
	}

	@Override
	public String insert(PessoaDTO pessoaDTO) {
		return pessoaEAO.insert(converterDTO(Pessoa.class, pessoaDTO));
	}

	@Override
	public String update(PessoaDTO pessoa) {
		return pessoaEAO.update(converterDTO(Pessoa.class, pessoa));
	}

	@Override
	public String delete(Long id) {
		return pessoaEAO.delete(id);
	}
	
	@Override
	public Long countRegister() {
		return (Long) pessoaEAO.executeHQLOneResult(getQueryCountRegisters(), null, null);
	}

}
