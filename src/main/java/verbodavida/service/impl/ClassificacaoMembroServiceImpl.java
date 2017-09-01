package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.querys.ClassificacaoMembroQuery.getPaged;
import static verbodavida.querys.ClassificacaoMembroQuery.getQueryCountRegisters;

import java.math.BigInteger;
import java.util.List;

import verbodavida.dtos.ClassificacaoMembroDTO;
import verbodavida.eaos.ClassificacaoMembroEAO;
import verbodavida.services.ClassificacaoMembroService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.VDVException;
import verbodavida.vos.ClassificacaoMembroVO;

public class ClassificacaoMembroServiceImpl extends ClassificacaoMembroService<ClassificacaoMembroDTO, ClassificacaoMembroVO> {

	ClassificacaoMembroEAO classificacaoMembroEAO = new ClassificacaoMembroEAO();
	
	@Override
	public PagedResult<ClassificacaoMembroVO> findPaged(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<ClassificacaoMembroVO> classificacaoMembroVOList = 
				classificacaoMembroEAO.executeSQLPaged(ClassificacaoMembroVO.class, beanConsultGroup,
				getPaged(), asList("idMinisterio"), asList(idMinisterio));
		
		BigInteger sizeDB = classificacaoMembroEAO.executeSQLOneResult(getQueryCountRegisters(), 
				asList("idMinisterio"), asList(idMinisterio));
		
		if (classificacaoMembroVOList != null && sizeDB != null){
			return new PagedResult<ClassificacaoMembroVO>(sizeDB, classificacaoMembroVOList);
		} else {
			throw new VDVException("Erro ao buscar classificacao de membros.");
		}
	}
	
//	@Override
//	public PagedResult<ClassificacaoMembroVO> findPaged(int page, int size, Long idMinisterio, Long idPessoa) {
//		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
//		
//		List<ClassificacaoMembroVO> classificacaoMembroVOList = 
//				classificacaoMembroEAO.executeSQLPaged(ClassificacaoMembroVO.class, beanConsultGroup,
//				getPaged(), asList("idMinisterio", "idPessoa"), asList(idMinisterio, idPessoa));
//		
//		BigInteger sizeDB = classificacaoMembroEAO.executeSQLOneResult(getQueryCountRegisters());
//		
////		if(!classificacaoMembroVOList.isEmpty() && !sizeDB.equals(null)){
//			
//			return new PagedResult<ClassificacaoMembroVO>(sizeDB, classificacaoMembroVOList);
////		}else {
////			throw new VDVException("Erro ao buscar classificação de membros.");
////		}
//	}
}
