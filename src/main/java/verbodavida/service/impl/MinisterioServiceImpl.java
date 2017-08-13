package verbodavida.service.impl;

import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.querys.MinisterioQuery.getPaged;
import static verbodavida.querys.MinisterioQuery.getQueryCountRegisters;

import java.math.BigInteger;
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
import verbodavida.utils.VDVException;
import verbodavida.vos.MinisterioVO;

public class MinisterioServiceImpl extends MinisterioService<MinisterioDTO, MinisterioVO> {

	private MinisterioEAO ministerioEAO = new MinisterioEAO();

	@Override
	public String insert(MinisterioDTO ministerioDTO) {
		Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);
		
		if(!ministerio.equals(null)){
			
			criarPopularClassificacao(ministerio);
			
			criarPopularGrupo(ministerio);
	
			return ministerioEAO.insert(ministerio);
		}

			throw new VDVException("Erro ao inserir ministério.");
	}

	@Override
	public String update(MinisterioDTO ministerioDTO) {
		
		if(!ministerioEAO.find(Ministerio.class, ministerioDTO.getIdMinisterio()).equals(null)){
			Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);

			if(!ministerio.equals(null)){
				criarPopularClassificacao(ministerio);
				
				criarPopularGrupo(ministerio);
				
				return ministerioEAO.update(ministerio);
			}else {
				
				throw new VDVException("Erro ao atualizar ministério.");
			}
			
		} else {
			throw new VDVException("Erro ao atualizar ministério.");
		}
		
	}

	@Override
	public String delete(Long idMinisterio) {
		
		Ministerio ministerio = ministerioEAO.find(Ministerio.class, idMinisterio);

		if(!ministerio.equals(null)){
			
			return ministerioEAO.delete(idMinisterio);
		}else {
			throw new VDVException("Erro ao excluir ministério.");
		}
	}

	@Override
	public MinisterioDTO find(Long idMinisterio) {
		 
		Ministerio ministerio = ministerioEAO.find(Ministerio.class, idMinisterio);
		
		if(!ministerio.equals(null)){
			
			return converterDTO(MinisterioDTO.class, ministerio);
		}else {
			
			throw new VDVException("Erro ao buscar ministério.");
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