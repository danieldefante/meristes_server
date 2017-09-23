package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.GrupoQuery.getQuery;
import static verbodavida.querys.GrupoQuery.getQueryCountRegisters;
import static verbodavida.querys.GrupoQuery.getQueryPessoasVinculo;
import static verbodavida.querys.VinculoPessoaGrupoQuery.getQueryVinculoPessoaGrupo;
import static verbodavida.utils.CrudRespost.respost;
import static verbodavida.utils.EnumVDVException.VINCULOPESSOAGRUPO_DESVINCULAR_SUCCESS;
import static verbodavida.utils.EnumVDVException.VINCULOPESSOAGRUPO_SAVE_ERROR;
import static verbodavida.utils.EnumVDVException.VINCULOPESSOAGRUPO_SAVE_SUCCESS;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import verbodavida.dtos.GrupoDTO;
import verbodavida.eaos.ClassificacaoMembroEAO;
import verbodavida.eaos.GrupoEAO;
import verbodavida.eaos.PessoaEAO;
import verbodavida.eaos.VinculoPessoaGrupoEAO;
import verbodavida.entities.ClassificacaoMembro;
import verbodavida.entities.Grupo;
import verbodavida.entities.Pessoa;
import verbodavida.entities.VinculoPessoaGrupo;
import verbodavida.querys.GrupoQuery;
import verbodavida.querys.PessoaQuery;
import verbodavida.services.GrupoService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.OQJFException;
import verbodavida.vos.GrupoVO;
import verbodavida.vos.PessoaVO;

public class GrupoServiceImpl extends GrupoService<GrupoDTO, GrupoVO> {

	GrupoEAO grupoEAO = new GrupoEAO();

	@Override
	public GrupoDTO find(Long idMinisterio, Long idGrupo) {
		Grupo grupo = grupoEAO.find(Grupo.class, getQuery(), asList("idMinisterio", "idGrupo"), asList(idMinisterio, idGrupo));
		
		if(grupo != null) {
			
			GrupoDTO grupoDTO = converterDTO(GrupoDTO.class, grupo); 
			return grupoDTO;
		}else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR,"Erro ao buscar grupo.");
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

		if(grupo != null) {
			Long retorno = grupoEAO.insert(grupo);
			
			return retorno != null ? "true":"false";
		}else{
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao inserir grupo.");
		}
	}

	@Override
	public String update(GrupoDTO grupoDTO) {
		Grupo grupo = converterDTO(Grupo.class, grupoDTO);
		
		if(grupo != null) {
			
			Boolean retorno =  grupoEAO.update(grupo);
			return retorno ? "true": "false";
		}else{
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao atualizar grupo.");
		}
	}

	@Override
	public String delete(Long idGrupo) {
		Grupo grupo = grupoEAO.find(Grupo.class, idGrupo);
		
		if(grupo != null) {
			
			Boolean retorno = grupoEAO.delete(idGrupo);

			return retorno ? "true": "false";
		}else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao deletar grupo.");
		}
	}

	@Override
	public String insertList(List<GrupoDTO> grupoDTOList) {
		
		List<Grupo> grupoList = converterDTOList(Grupo.class, grupoDTOList);
		
		if(!grupoList.isEmpty()){
			
			Boolean retorno = grupoEAO.insertList(grupoList);
			
			return retorno ? "true": "false";
			
		}else{
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao inserir grupos.");
		}
	}

	public String vincularPessoa(Long idMinisterio, Long idGrupo, Long idClassificacaoMembro, PessoaVO pessoaVO) {
		PessoaEAO pessoaEAO = new PessoaEAO();
		VinculoPessoaGrupoEAO vinculoPessoaGrupoEAO = new VinculoPessoaGrupoEAO();
		ClassificacaoMembroEAO classificacaoMembroEAO = new ClassificacaoMembroEAO();
		
		Grupo grupo = grupoEAO.find(Grupo.class, idGrupo);

		ClassificacaoMembro classificacaoMembro = classificacaoMembroEAO.find(ClassificacaoMembro.class, idClassificacaoMembro);

		if(pessoaVO != null && grupo != null && classificacaoMembro != null){
			
			Pessoa pessoa = pessoaEAO.find(Pessoa.class, pessoaVO.getIdPessoa());
			
			if(pessoa != null){
				VinculoPessoaGrupoEAO vincularPessoaGrupoEAO = new VinculoPessoaGrupoEAO();

				VinculoPessoaGrupo vinculoPessoaGrupo = vinculoPessoaGrupoEAO.find(VinculoPessoaGrupo.class, 
						getQueryVinculoPessoaGrupo(), 
						asList("idMinisterio", "idGrupo", "idClassificacaoMembro", "idPessoa"), 
						asList(idMinisterio, idGrupo, idClassificacaoMembro, pessoaVO.getIdPessoa()));
				
				if(pessoaVO.getAtivo() && vinculoPessoaGrupo == null){
					VinculoPessoaGrupo novoVinculoPessoaGrupo = new VinculoPessoaGrupo();
					novoVinculoPessoaGrupo.setClassificacaoMembro(classificacaoMembro);
					novoVinculoPessoaGrupo.setPessoa(pessoa);
					novoVinculoPessoaGrupo.setGrupo(grupo);
					novoVinculoPessoaGrupo.setDataVinculacao(new Timestamp(System.currentTimeMillis()));
					novoVinculoPessoaGrupo.setAtivo(pessoaVO.getAtivo());
					
					Long respost = vincularPessoaGrupoEAO.insert(novoVinculoPessoaGrupo);
					return respost != null ? respost(VINCULOPESSOAGRUPO_SAVE_SUCCESS.getMsg(), true, respost) : respost(VINCULOPESSOAGRUPO_SAVE_ERROR.getMsg(), false, respost);
				} else if(vinculoPessoaGrupo != null){
					
					if(vinculoPessoaGrupo.getAtivo() != pessoaVO.getAtivo()){
						vinculoPessoaGrupo.setAtivo(pessoaVO.getAtivo());
						Boolean respost = vincularPessoaGrupoEAO.update(vinculoPessoaGrupo);
						
						if(!pessoaVO.getAtivo()) {
							return respost == true ? respost(VINCULOPESSOAGRUPO_DESVINCULAR_SUCCESS.getMsg(), respost, null) : respost(VINCULOPESSOAGRUPO_SAVE_ERROR.getMsg(), respost, null);
						}else {
							return respost == true ? respost(VINCULOPESSOAGRUPO_SAVE_SUCCESS.getMsg(), respost, null) : respost(VINCULOPESSOAGRUPO_SAVE_ERROR.getMsg(), respost, null);

						}
					}
				}
				
			} else {
				throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao encontrar pessoa.");
			}
			
		} else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Dados inválidos!");
		}
		return null;
	}

	public PagedResult<PessoaVO> pagedPessoasVinculo(int page, int size, Long idMinisterio, Long idGrupo, Long idClassificacaoMembro) {
		
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<PessoaVO> pessoaVOList = grupoEAO.executeSQLPaged(PessoaVO.class, beanConsultGroup, getQueryPessoasVinculo(), 
				asList("idMinisterio", "idGrupo", "idClassificacaoMembro"), asList(idMinisterio, idGrupo, idClassificacaoMembro));
		
		BigInteger sizeBD = grupoEAO.executeSQLOneResult(PessoaQuery.getQueryCountRegisters());
		
		if (pessoaVOList != null && sizeBD != null) {
			
			return new PagedResult<PessoaVO>(sizeBD, pessoaVOList);
		} else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao encontar membros.");
		}
	}
}
