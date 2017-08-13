package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.GrupoQuery.getQuery;
import static verbodavida.querys.GrupoQuery.getQueryCountMembros;
import static verbodavida.querys.GrupoQuery.getQueryCountRegisters;
import static verbodavida.querys.GrupoQuery.getSQLMembrosGrupo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import verbodavida.dtos.GrupoDTO;
import verbodavida.eaos.GrupoEAO;
import verbodavida.eaos.PessoaEAO;
import verbodavida.eaos.VincularPessoaGrupoEAO;
import verbodavida.entities.Grupo;
import verbodavida.entities.Pessoa;
import verbodavida.entities.VinculoPessoaGrupo;
import verbodavida.querys.GrupoQuery;
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
		Grupo grupo = grupoEAO.find(Grupo.class, getQuery(), asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		if(!grupo.equals(null)) {
			
			GrupoDTO grupoDTO = converterDTO(GrupoDTO.class, grupo); 
			return grupoDTO;
		}else {
			throw new VDVException("Erro ao buscar grupo.");
		}
		
	}
	
	@Override
	public PagedResult<GrupoVO> findPaged(int page, int size, Long idMinisterio) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<GrupoVO> grupoVOList = grupoEAO.executeSQLPaged(GrupoVO.class, beanConsultGroup, GrupoQuery.getPaged(),
								    Arrays.asList("idMinisterio"), Arrays.asList(idMinisterio));
		
		BigInteger sizeDB = grupoEAO.executeSQLOneResult(getQueryCountRegisters(), asList("idMinisterio"), asList(idMinisterio));
		
		return new PagedResult<GrupoVO>(sizeDB, grupoVOList);
	}

	@Override
	public String insert(GrupoDTO grupoDTO) {
		Grupo grupo = converterDTO(Grupo.class, grupoDTO);

		if(!grupo.equals(null)){
			
			return grupoEAO.insert(grupo);
		}else{
			throw new VDVException("Erro ao inserir grupo.");
		}
	}

	@Override
	public String update(GrupoDTO grupoDTO) {
		Grupo grupo = converterDTO(Grupo.class, grupoDTO);
		
		if(!grupo.equals(null)){
			
			return grupoEAO.update(grupo);
		}else{
			throw new VDVException("Erro ao atualizar grupo.");
		}
	}

	@Override
	public String delete(Long idGrupo) {
		Grupo grupo = grupoEAO.find(Grupo.class, idGrupo);
		
		if(!grupo.equals(null)) {
			
			return grupoEAO.delete(idGrupo);
		}else {
			throw new VDVException("Erro ao deletar grupo.");
		}
	}

	@Override
	public String insertList(List<GrupoDTO> grupoDTOList) {
		
		List<Grupo> grupoList = converterDTOList(Grupo.class, grupoDTOList);
		
		if(!grupoList.isEmpty()){
			
			return grupoEAO.insertList(grupoList);
		}else{
			throw new VDVException("Erro ao inserir grupos.");
		}
	}

	public String vincularPessoa(Long idMinisterio, Long idGrupo, Long idPessoa) {
		Pessoa pessoa = new PessoaEAO().find(Pessoa.class, idPessoa);
		Grupo grupo = grupoEAO.find(Grupo.class, idGrupo);


		if(!pessoa.equals(null) && !grupo.equals(null)){
			VinculoPessoaGrupo vinculoPessoaGrupo = new VinculoPessoaGrupo();
			vinculoPessoaGrupo.setPessoa(pessoa);
			vinculoPessoaGrupo.setGrupo(grupo);
			vinculoPessoaGrupo.setDataVinculacao(new Date());
			VincularPessoaGrupoEAO vincularPessoaGrupoEAO = new VincularPessoaGrupoEAO();
			
			return vincularPessoaGrupoEAO.insert(vinculoPessoaGrupo);
		
		} else {
		
			throw new VDVException("Erro ao vincular pessoa ao grupo.");
		}
		 
	}

	public PagedResult<PessoaVO> pagedMembros(int page, int size, Long idMinisterio, Long idGrupo) {
		
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<PessoaVO> pessoaVOList = grupoEAO.executeSQLPaged(PessoaVO.class, beanConsultGroup, getSQLMembrosGrupo(), 
				asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		BigInteger sizeBD = grupoEAO.executeSQLOneResult(getQueryCountMembros(), asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		if (!pessoaVOList.equals(null) && !sizeBD.equals(null)) {
			
			return new PagedResult<PessoaVO>(sizeBD, pessoaVOList);
		} else {
			throw new VDVException("Erro ao encontar membros.");
		}
	}

}
