package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.GrupoQuery.getQuery;
import static verbodavida.querys.GrupoQuery.getQueryAllMembros;
import static verbodavida.querys.GrupoQuery.getQueryByIdMinisterio;
import static verbodavida.querys.GrupoQuery.getQueryCountRegisters;

import java.util.List;

import verbodavida.dtos.GrupoDTO;
import verbodavida.eaos.GrupoEAO;
import verbodavida.entities.Grupo;
import verbodavida.entities.Pessoa;
import verbodavida.querys.GrupoQuery;
import verbodavida.services.GrupoService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.vos.GrupoVO;
import verbodavida.vos.PessoaVO;

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
		
		List<Grupo> listGrupo = grupoEAO.findListByHQL(beanConsultGroup, getQueryByIdMinisterio(), asList("idMinisterio"), asList(idMinisterio));
		
		List<GrupoVO> grupoVOList = converterDTOList(GrupoVO.class, listGrupo);
		
		return new PagedResult(countRegister(getQueryCountRegisters(), asList("idMinisterio"), asList(idMinisterio)), grupoVOList);
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
	public Long countRegister(String query, List<String> nameParam, List<Object> valueParam) {
		return (Long) grupoEAO.executeHQLOneResult(query, nameParam, valueParam);
	}

	public PagedResult findAllMembros(int page, int size, Long idMinisterio, Long idGrupo) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);

		List<Pessoa> pessoaList = grupoEAO.findListByHQL(beanConsultGroup, getQueryAllMembros(), asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		List<PessoaVO> pessoaVO = converterDTOList(PessoaVO.class, pessoaList);
		
		return new PagedResult(countRegister(GrupoQuery.getQueryCountRegistersMembros(), asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo)), pessoaVO);
		
	}
	
}
