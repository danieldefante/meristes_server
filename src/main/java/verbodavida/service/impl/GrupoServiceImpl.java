package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.GrupoQuery.getQuery;
import static verbodavida.querys.GrupoQuery.getQueryByIdMinisterio;
import static verbodavida.querys.GrupoQuery.getQueryCountPessoasByGrupo;
import static verbodavida.querys.GrupoQuery.getQueryCountRegisters;
import static verbodavida.querys.GrupoQuery.getSQLMembrosGrupo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import verbodavida.dtos.GrupoDTO;
import verbodavida.eaos.GrupoEAO;
import verbodavida.eaos.PessoaEAO;
import verbodavida.eaos.VincularPessoaGrupoEAO;
import verbodavida.entities.Grupo;
import verbodavida.entities.Pessoa;
import verbodavida.entities.VinculoPessoaGrupo;
import verbodavida.services.GrupoService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.VDVException;
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
	public PagedResult<GrupoVO> findAll(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<Grupo> listGrupo = grupoEAO.findPagedList(Grupo.class, beanConsultGroup, getQueryByIdMinisterio(), asList("idMinisterio"), asList(idMinisterio));
		
		List<GrupoVO> grupoVOList = converterDTOList(GrupoVO.class, listGrupo);
		
		return new PagedResult<GrupoVO>(countRegister(getQueryCountRegisters(), asList("idMinisterio"), asList(idMinisterio)), grupoVOList);
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

	public String vincularPessoa(Long idMinisterio, Long idGrupo, Long idPessoa) {
		Pessoa pessoa = new PessoaEAO().find(Pessoa.class, idPessoa);
		Grupo grupo = grupoEAO.find(Grupo.class, idGrupo);


		if(pessoa != null && grupo != null){
			VinculoPessoaGrupo vinculoPessoaGrupo = new VinculoPessoaGrupo();
			vinculoPessoaGrupo.setPessoa(pessoa);
			vinculoPessoaGrupo.setGrupo(grupo);
			vinculoPessoaGrupo.setDataVinculacao(new Date());
			VincularPessoaGrupoEAO vincularPessoaGrupoEAO = new VincularPessoaGrupoEAO();
			
			return vincularPessoaGrupoEAO.insert(vinculoPessoaGrupo);
		
		} else {
		
			throw new VDVException("Erro ao encontar Pessoa ou Grupo.");
		}
		 
	}

	public PagedResult<PessoaVO> findMembrosByIdGrupo(int page, int size, Long idMinisterio, Long idGrupo) {
		
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<Pessoa> pessoaList = grupoEAO.findPagedList(Pessoa.class, beanConsultGroup, getSQLMembrosGrupo(), 
				asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		if (pessoaList.equals(null)) {
			return new PagedResult<PessoaVO>(new BigInteger("0"), new ArrayList<PessoaVO>());
		} else {
			List<PessoaVO> pessoaVOList = converterDTOList(PessoaVO.class, pessoaList);
			
			BigInteger sizeBD = countRegister(getQueryCountPessoasByGrupo(),
					asList("idMinisterio", "idGrupo"), 
					asList(idMinisterio, idGrupo));
			
			return new PagedResult<PessoaVO>(sizeBD, pessoaVOList);
		}
	}
	
	@Override
	public BigInteger countRegister(String query, List<String> nameParams, List<Object> params) {
		return grupoEAO.executeSQLOneResult(query, nameParams, params);
	}


}
