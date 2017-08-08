package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.ClassificacaoMembroQuery.getQueryByIdMinisterio;
import static verbodavida.querys.ClassificacaoMembroQuery.getQueryCountRegisters;

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
	public PagedResult findAll(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<ClassificacaoMembroVO> classificacaoMembroVOList = converterDTOList(ClassificacaoMembroVO.class, classificacaoMembroVOList = classificacaoMembroEAO.findListByHQL(
				beanConsultGroup, getQueryByIdMinisterio(), asList("idMinisterio"), asList(idMinisterio)));
		
		return new PagedResult(countRegister(asList("idMinisterio"), asList(idMinisterio)), classificacaoMembroVOList);
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
	public Long countRegister(List<String> nameParam, List<Object> valueParam) {
		return (Long) classificacaoMembroEAO.executeHQLOneResult(getQueryCountRegisters(), nameParam, valueParam);
	}
	
}
