package verbodavida.service.impl;

import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.querys.PessoaQuery.getPaged;
import static verbodavida.querys.PessoaQuery.getQueryCountRegisters;
import static verbodavida.utils.CrudRespost.respost;
import static verbodavida.utils.EnumVDVException.PESSOA_DELETE_ERROR;
import static verbodavida.utils.EnumVDVException.PESSOA_DELETE_SUCCESS;
import static verbodavida.utils.EnumVDVException.PESSOA_SAVE_ERROR;
import static verbodavida.utils.EnumVDVException.PESSOA_SAVE_SUCCESS;

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

		if(pessoa != null){
			PessoaDTO pessoaDTO = converterDTO( PessoaDTO.class, pessoa);
			
			return pessoaDTO;
		}else {
			throw new VDVException("Erro ao buscar pessoa.");
		}
	}

	@Override
	public String insert(PessoaDTO pessoaDTO) {
		Pessoa pessoa = converterDTO(Pessoa.class, pessoaDTO);
		
		if(pessoa != null){
			
			Long respost = pessoaEAO.insert(pessoa);
			return respost != null ? respost(PESSOA_SAVE_SUCCESS.getMsg(), true, respost) : respost(PESSOA_SAVE_ERROR.getMsg(), false, respost);
		}else {
			throw new VDVException("Erro ao inserir pessoa.");
		}
	}

	@Override
	public String update(PessoaDTO pessoaDTO) {
		Pessoa pessoa = converterDTO(Pessoa.class, pessoaDTO);
		
		if(pessoa != null){
			
			Boolean respost = pessoaEAO.update(pessoa);
			return respost == true ? respost(PESSOA_SAVE_SUCCESS.getMsg(), respost, null) : respost(PESSOA_SAVE_ERROR.getMsg(), respost, null);
		}else {
			throw new VDVException("Erro ao atualizar pessoa.");
		}
	}

	@Override
	public String delete(Long idPessoa) {
		Pessoa pessoa = pessoaEAO.find(Pessoa.class, idPessoa);
		
		if(pessoa != null){
			Boolean respost =  pessoaEAO.delete(idPessoa);
			return respost == true ? respost(PESSOA_DELETE_SUCCESS.getMsg(), respost, null) : respost(PESSOA_DELETE_ERROR.getMsg(), respost, null);
		}else {
			throw new VDVException("Erro ao excluir pessoa.");
		}
	}

}
