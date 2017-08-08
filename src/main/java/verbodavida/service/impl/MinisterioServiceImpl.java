package verbodavida.service.impl;

import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.MinisterioQuery.getQueryCountRegisters;

import java.util.List;
import java.util.Set;

import verbodavida.dtos.MinisterioDTO;
import verbodavida.eaos.MinisterioEAO;
import verbodavida.entities.ClassificacaoMembro;
import verbodavida.entities.Grupo;
import verbodavida.entities.Ministerio;
import verbodavida.services.MinisterioService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.vos.MinisterioVO;

public class MinisterioServiceImpl extends MinisterioService<MinisterioDTO, MinisterioVO> {

	private MinisterioEAO ministerioEAO = new MinisterioEAO();

	@Override
	public String insert(MinisterioDTO ministerioDTO) {
		String data = null;
		Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);
		
		Set<ClassificacaoMembro> classificacaoMembros = ministerio.getClassificacaoMembros();
		classificacaoMembros.forEach(classMembro->{
			classMembro.setMinisterio(ministerio);
		});
		
		
		Set<Grupo> grupos = ministerio.getGrupos();
		grupos.forEach(grupo->{
			grupo.setMinisterio(ministerio);
		});
		
		data = ministerioEAO.insert(ministerio);
			
		return data;
	}

	@Override
	public String update(MinisterioDTO ministerio) {
		
		return ministerioEAO.update(
				converterDTO(Ministerio.class, ministerio));
	}

	@Override
	public String delete(Long idMinisterio) {
		return ministerioEAO.delete(idMinisterio);
	}

	@Override
	public MinisterioDTO find(Long idMinisterio) {
		 return converterDTO(
				 MinisterioDTO.class,
				 ministerioEAO.find(Ministerio.class, idMinisterio));
	}

	@Override
	public PagedResult findAll(int page, int size) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		List<MinisterioVO> ministerioVOList = converterDTOList(MinisterioVO.class, 
				ministerioEAO.findAll(Ministerio.class, beanConsultGroup));
		
		return new PagedResult(countRegister(), ministerioVOList);
	}
	
	@Override
	public Long countRegister() {
		return (Long) ministerioEAO.executeHQLOneResult(getQueryCountRegisters(), null, null);
	}

}