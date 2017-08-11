package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.ClassificacaoMembroQuery.getQueryByIdMinisterio;
import static verbodavida.querys.ClassificacaoMembroQuery.getQueryCountRegisters;

import java.math.BigInteger;
import java.util.List;

import verbodavida.dtos.ClassificacaoMembroDTO;
import verbodavida.eaos.ClassificacaoMembroEAO;
import verbodavida.entities.ClassificacaoMembro;
import verbodavida.services.ClassificacaoMembroService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.vos.ClassificacaoMembroVO;

public class ClassificacaoMembroServiceImpl extends ClassificacaoMembroService<ClassificacaoMembroDTO, ClassificacaoMembroVO> {

	ClassificacaoMembroEAO classificacaoMembroEAO = new ClassificacaoMembroEAO();
	
	@Override
	public PagedResult<ClassificacaoMembroVO> findAll(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<ClassificacaoMembroVO> classificacaoMembroVOList = converterDTOList(ClassificacaoMembroVO.class, classificacaoMembroVOList = classificacaoMembroEAO.findPagedList(
				ClassificacaoMembroVO.class, beanConsultGroup, getQueryByIdMinisterio(), asList("idMinisterio"), asList(idMinisterio)));
		
		BigInteger sizeDB = countRegister(getQueryCountRegisters(), asList("idMinisterio"), asList(idMinisterio));
		
		return new PagedResult<ClassificacaoMembroVO> (sizeDB, classificacaoMembroVOList);
	}


	@Override
	public String delete(Long idClassificacaoMembro) {
		return classificacaoMembroEAO.delete(idClassificacaoMembro);
	}

	@Override
	public String insertList(List<ClassificacaoMembroDTO> classificacaoMembroDTOList) {
		return classificacaoMembroEAO.insertList(converterDTOList(ClassificacaoMembro.class, classificacaoMembroDTOList));
	}

	@Override
	public BigInteger countRegister(String sql, List<String> nameParam, List<Object> valueParam) {
		return classificacaoMembroEAO.executeSQLOneResult(sql, nameParam, valueParam);
	}
	
}
