package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.dtos.ConverterEntity.converterDTO;
import static verbodavida.dtos.ConverterEntity.converterDTOList;
import static verbodavida.querys.MinisterioQuery.getQueryCountRegisters;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import verbodavida.dtos.MinisterioDTO;
import verbodavida.eaos.ClassificacaoMembroEAO;
import verbodavida.eaos.MinisterioEAO;
import verbodavida.entities.ClassificacaoMembro;
import verbodavida.entities.Grupo;
import verbodavida.entities.Ministerio;
import verbodavida.querys.ClassificacaoMembroQuery;
import verbodavida.services.MinisterioService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.VDVException;
import verbodavida.vos.ClassificacaoMembroVO;
import verbodavida.vos.MinisterioVO;

public class MinisterioServiceImpl extends MinisterioService<MinisterioDTO, MinisterioVO> {

	private MinisterioEAO ministerioEAO = new MinisterioEAO();

	@Override
	public String insert(MinisterioDTO ministerioDTO) {
		Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);
		
		Set<ClassificacaoMembro> classificacaoMembros = ministerio.getClassificacaoMembros();
		classificacaoMembros.forEach(classMembro->{
			classMembro.setMinisterio(ministerio);
		});
		
		
		Set<Grupo> grupos = ministerio.getGrupos();
		grupos.forEach(grupo->{
			grupo.setMinisterio(ministerio);
		});
		
		return ministerioEAO.insert(ministerio);
	}

	@Override
	public String update(MinisterioDTO ministerioDTO) {
		
		if(!ministerioEAO.find(Ministerio.class, ministerioDTO.getIdMinisterio()).equals(null)){
			Ministerio ministerio = converterDTO(Ministerio.class, ministerioDTO);

			Set<ClassificacaoMembro> classificacaoMembros = ministerio.getClassificacaoMembros();
			classificacaoMembros.forEach(classMembro->{
				classMembro.setMinisterio(ministerio);
			});
			
			Set<Grupo> grupos = ministerio.getGrupos();
			grupos.forEach(grupo->{
				grupo.setMinisterio(ministerio);
			});
			
			return ministerioEAO.update(ministerio);
		} else {
			throw new VDVException("Ministério não encontrado.");
		}
		
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
	public PagedResult<MinisterioVO>  findAll(int page, int size) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		List<MinisterioVO> ministerioVOList = converterDTOList(MinisterioVO.class, 
				ministerioEAO.findAll(Ministerio.class, beanConsultGroup));
		
		BigInteger sizeDB = countRegister(getQueryCountRegisters(), null, null);
		
		return new PagedResult<MinisterioVO>(sizeDB, ministerioVOList);
	}

	public PagedResult<ClassificacaoMembroVO>  findClassificacaoByMinisterio(int page, int size) {
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		ClassificacaoMembroEAO classificacaoMembroEAO = new ClassificacaoMembroEAO();
		List<ClassificacaoMembro> classificacaoMembroList = classificacaoMembroEAO.findPagedList(ClassificacaoMembro.class, beanConsultGroup,
				ClassificacaoMembroQuery.getQueryByIdMinisterio(), asList("idMinisterio"), asList("idMinisterio"));
		
		return null;
	}
	
	@Override
	public BigInteger countRegister(String query, List<String> nameParams, List<Object> params) {
		return ministerioEAO.executeSQLOneResult(query, null, null);
	}

}