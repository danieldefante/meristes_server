package verbodavida.service.impl;

import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.querys.MinisterioQuery.getPaged;
import static verbodavida.querys.MinisterioQuery.getQueryCountRegisters;
import static verbodavida.utils.CrudRespost.respost;
import static verbodavida.utils.EnumVDVException.MINISTERIO_DELETE_ERROR;
import static verbodavida.utils.EnumVDVException.MINISTERIO_DELETE_SUCCESS;
import static verbodavida.utils.EnumVDVException.MINISTERIO_SAVE_ERROR;
import static verbodavida.utils.EnumVDVException.MINISTERIO_SAVE_SUCCESS;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response.Status;

import verbodavida.dtos.MinisterioDTO;
import verbodavida.eaos.MinisterioEAO;
import verbodavida.entities.ClassificacaoMembro;
import verbodavida.entities.Grupo;
import verbodavida.entities.Ministerio;
import verbodavida.services.MinisterioService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.OQJFException;
import verbodavida.utils.PagedResult;
import verbodavida.vos.MinisterioVO;

public class MinisterioServiceImpl extends MinisterioService<MinisterioDTO, MinisterioVO> {

	private MinisterioEAO ministerioEAO = new MinisterioEAO();

	@Override
	public String insert(MinisterioDTO ministerioDTO) {
		Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);
		
		if(ministerio != null){
			
			criarPopularClassificacao(ministerio);
			
			criarPopularGrupo(ministerio);
	
			Long respost = ministerioEAO.insert(ministerio);
			return respost != null ? respost(MINISTERIO_SAVE_SUCCESS.getMsg(), true, respost) : respost(MINISTERIO_SAVE_ERROR.getMsg(), false, respost);
		}

			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao inserir ministério.");
	}

	@Override
	public String update(MinisterioDTO ministerioDTO) {
		
		if(ministerioEAO.find(Ministerio.class, ministerioDTO.getIdMinisterio()) != null ){
			Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);

			if(ministerio != null){
				criarPopularClassificacao(ministerio);
				
				criarPopularGrupo(ministerio);
				Boolean respost = ministerioEAO.update(ministerio);
				return respost == true ? respost(MINISTERIO_SAVE_SUCCESS.getMsg(), respost, null) : respost(MINISTERIO_SAVE_ERROR.getMsg(), respost, null);
			}else {
				
				throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao atualizar ministério.");
			}
			
		} else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao atualizar ministério.");
		}
		
	}

	@Override
	public String delete(Long idMinisterio) {
		
		Ministerio ministerio = ministerioEAO.find(Ministerio.class, idMinisterio);

		if(ministerio != null){
			
			Boolean respost = ministerioEAO.delete(idMinisterio);
			return respost == true ? respost(MINISTERIO_DELETE_SUCCESS.getMsg(), respost, null) : respost(MINISTERIO_DELETE_ERROR.getMsg(), respost, null);
		}else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao excluir ministério.");
		}
	}

	@Override
	public MinisterioDTO find(Long idMinisterio) {
		 
		Ministerio ministerio = ministerioEAO.find(Ministerio.class, idMinisterio);
		
		if(ministerio != null){
			
			return converterDTO(MinisterioDTO.class, ministerio);
		}else {
			
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR, "Erro ao buscar ministério.");
		}
	}

	@Override
	public PagedResult<MinisterioVO> findPaged(int page, int size) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<MinisterioVO> ministerioVOList = ministerioEAO.executeSQLPaged(MinisterioVO.class, beanConsultGroup, getPaged());
		
		BigInteger sizeDB = ministerioEAO.executeSQLOneResult(getQueryCountRegisters());
		
			
		return new PagedResult<MinisterioVO>(sizeDB, ministerioVOList);
	}

	private void criarPopularClassificacao(Ministerio ministerio) {
		Set<ClassificacaoMembro> classificacaoMembros = ministerio.getClassificacaoMembros();
		
		if(!classificacaoMembros.isEmpty()){
			
			classificacaoMembros.forEach(classMembro -> {
				classMembro.setMinisterio(ministerio);
			});
		}else{
			ClassificacaoMembro classificacaoMembro = new ClassificacaoMembro();
			classificacaoMembro.setDescricao("Sem classificação");
		}
	}
	
	private void criarPopularGrupo(Ministerio ministerio) {
		Set<Grupo> grupos = ministerio.getGrupos();
		if(!grupos.isEmpty()){
			
			grupos.forEach(grupo->{
				grupo.setMinisterio(ministerio);
			});
			
		}else{
			Grupo grupo = new Grupo();
			grupo.setNome("Principal");
			grupo.setDescricao("Este ministério consiste somente em um grupo");
		}
	}
}