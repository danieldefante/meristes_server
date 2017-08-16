package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.querys.FuncaoMinisterialQuery.getPagedPessoa;
import static verbodavida.querys.FuncaoMinisterialQuery.getPagedMinisterio;
import static verbodavida.querys.FuncaoMinisterialQuery.getQueryCountRegistersPessoa;
import static verbodavida.querys.FuncaoMinisterialQuery.getQueryCountRegistersMinisterio;

import java.math.BigInteger;
import java.util.List;

import verbodavida.eaos.FuncaoMinisterialEAO;
import verbodavida.services.ClassificacaoMembroService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.vos.FuncaoMinisterialVO;

public class FuncaoMinisterialServiceImpl extends ClassificacaoMembroService<Void, FuncaoMinisterialVO> {

	FuncaoMinisterialEAO funcaoMinisterialEAO = new FuncaoMinisterialEAO();
	
	@Override
	public PagedResult<FuncaoMinisterialVO> findPaged(int page, int size, Long idMinisterio, Long idPessoa) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<FuncaoMinisterialVO> funcaoMinisterialVOList = 
				funcaoMinisterialEAO.executeSQLPaged(FuncaoMinisterialVO.class, beanConsultGroup,
				getPagedPessoa(), asList("idMinisterio", "idPessoa"), asList(idMinisterio, idPessoa));
		
		BigInteger sizeDB = funcaoMinisterialEAO.executeSQLOneResult(getQueryCountRegistersPessoa(), asList("idMinisterio", "idPessoa"), asList(idMinisterio, idPessoa));
		
		return new PagedResult<FuncaoMinisterialVO>(sizeDB, funcaoMinisterialVOList);
	}

	@Override
	public PagedResult<FuncaoMinisterialVO> findPaged(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<FuncaoMinisterialVO> funcaoMinisterialVOList = 
				funcaoMinisterialEAO.executeSQLPaged(FuncaoMinisterialVO.class, beanConsultGroup,
						getPagedMinisterio(), asList("idMinisterio"), asList(idMinisterio));
		
		BigInteger sizeDB = funcaoMinisterialEAO.executeSQLOneResult(getQueryCountRegistersMinisterio(), asList("idMinisterio"), asList(idMinisterio));
		
		return new PagedResult<FuncaoMinisterialVO>(sizeDB, funcaoMinisterialVOList);
	}
}
