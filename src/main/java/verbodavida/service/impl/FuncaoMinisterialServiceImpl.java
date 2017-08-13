package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.querys.FuncaoMinisterialQuery.getPaged;
import static verbodavida.querys.FuncaoMinisterialQuery.getQueryCountRegisters;

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
				getPaged(), asList("idMinisterio", "idPessoa"), asList(idMinisterio, idPessoa));
		
		BigInteger sizeDB = funcaoMinisterialEAO.executeSQLOneResult(getQueryCountRegisters(), asList("idMinisterio", "idPessoa"), asList(idMinisterio, idPessoa));
		
		return new PagedResult<FuncaoMinisterialVO>(sizeDB, funcaoMinisterialVOList);
	}
}
