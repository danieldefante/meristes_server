package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.GrupoQuery.getQuery;
import static verbodavida.querys.GrupoQuery.getQueryByIdMinisterio;
import static verbodavida.querys.GrupoQuery.getQueryCountRegisters;

import java.util.List;

import verbodavida.dtos.GrupoDTO;
import verbodavida.eaos.GrupoEAO;
import verbodavida.entities.Grupo;
import verbodavida.services.GrupoService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.vos.GrupoVO;

public class GrupoServiceImpl extends GrupoService<GrupoDTO, GrupoVO> {

	GrupoEAO grupoEAO = new GrupoEAO();

	@Override
	public GrupoDTO find(Long idMinisterio, Long idGrupo) {
		Grupo grupo = (Grupo) grupoEAO.executeHQLOneResult(getQuery(), asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		return grupo != null ? converterDTO(GrupoDTO.class, grupo) : null; 
	}
	
	@Override
	public PagedResult findAll(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<GrupoVO> grupoVOList = converterDTOList(GrupoVO.class, grupoVOList = grupoEAO.findListByHQL(
				beanConsultGroup, getQueryByIdMinisterio(), asList("idMinisterio"), asList(idMinisterio)));
		
		return new PagedResult(countRegister(asList("idMinisterio"), asList(idMinisterio)), grupoVOList);
	}

	@Override
	public String insert(GrupoDTO grupoDTO) {
		return grupoEAO.insert(
				converterDTO(Grupo.class, grupoDTO));
	}

	@Override
	public String update(GrupoDTO grupoDTO) {
		return grupoEAO.update(
				converterDTO(Grupo.class, grupoDTO));
	}

	@Override
	public String delete(Long id) {
		return grupoEAO.delete(id);
	}

	@Override
	public String insertList(List<GrupoDTO> grupoDTOList) {
		return grupoEAO.insertList(converterDTOList(Grupo.class, grupoDTOList));
	}

	@Override
	public Long countRegister(List<String> nameParam, List<Object> valueParam) {
		return (Long) grupoEAO.executeHQLOneResult(getQueryCountRegisters(), nameParam, valueParam);
	}
	
}
