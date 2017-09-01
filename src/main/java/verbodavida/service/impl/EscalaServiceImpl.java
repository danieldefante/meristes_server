package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.querys.GrupoQuery.getMembrosGrupoEscalados;
import static verbodavida.querys.GrupoQuery.getQueryCountMembros;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;

import verbodavida.dtos.ConverterEntity;
import verbodavida.dtos.EscalaDTO;
import verbodavida.dtos.PessoaEscaladaDTO;
import verbodavida.eaos.EscalaEAO;
import verbodavida.entities.Escala;
import verbodavida.services.EscalaService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.VDVException;
import verbodavida.validators.ValidatorEscala;
import verbodavida.vos.EscalaVO;

public class EscalaServiceImpl extends EscalaService<EscalaDTO, EscalaVO, PessoaEscaladaDTO> {

	EscalaEAO escalaEAO = new EscalaEAO();
	
	@Override
	public List<EscalaVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EscalaDTO find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(EscalaDTO escalaDTO) {
		
		Escala escala = ConverterEntity.converterDTO(Escala.class, escalaDTO);
		
		ValidatorEscala validadorEscala = new ValidatorEscala(escala);
		
		validadorEscala.validarEscalaConflito();
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(EscalaDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PagedResult<PessoaEscaladaDTO> pagedMembrosFromEscala(int page, int size, Long idMinisterio, Long idGrupo, PessoaEscaladaDTO pessoaEscaladaDTO) {
		
		System.out.println(pessoaEscaladaDTO.getDataInicial());
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");    
		String dataInicial = fmt.format(pessoaEscaladaDTO.getDataInicial());
		String dataFinal = fmt.format(pessoaEscaladaDTO.getDataFinal());
		System.out.println(dataInicial +" - "+ dataFinal);
		
	

		
		
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<PessoaEscaladaDTO> pessoaEscaladaDTOList = escalaEAO.executeSQLPaged(PessoaEscaladaDTO.class, beanConsultGroup, getMembrosGrupoEscalados(), 
					asList("idGrupo", "idClassificacaoMembro", "dataInicial", "dataFinal"),
					asList(idGrupo, pessoaEscaladaDTO.getIdClassificacaoMembro(), pessoaEscaladaDTO.getDataInicial(), pessoaEscaladaDTO.getDataFinal()));

		
		
		BigInteger sizeBD = escalaEAO.executeSQLOneResult(getQueryCountMembros(), 
				asList("idMinisterio", "idGrupo"),
				asList(idMinisterio, idGrupo));
		
		if (pessoaEscaladaDTOList != null && sizeBD != null) {
			
			return new PagedResult<PessoaEscaladaDTO>(sizeBD, pessoaEscaladaDTOList);
		} else {
			throw new VDVException("Erro ao encontar membros.");
		}
	}
	

}
