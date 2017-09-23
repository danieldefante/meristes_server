package verbodavida.service.impl;

import static java.util.Arrays.asList;
import static verbodavida.querys.GrupoQuery.getMembrosGrupoEscalados;
import static verbodavida.querys.GrupoQuery.getQueryCountMembros;
import static verbodavida.utils.CrudRespost.respost;
import static verbodavida.utils.EnumVDVException.ESCALA_SAVE_ERROR;
import static verbodavida.utils.EnumVDVException.ESCALA_SAVE_SUCCESS;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import verbodavida.dtos.EscalaDTO;
import verbodavida.eaos.EscalaEAO;
import verbodavida.eaos.VinculoPessoaGrupoEAO;
import verbodavida.entities.Escala;
import verbodavida.entities.VinculoPessoaGrupo;
import verbodavida.services.EscalaService;
import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PagedResult;
import verbodavida.utils.OQJFException;
import verbodavida.validators.ValidatorEscala;
import verbodavida.vos.EscalaVO;

public class EscalaServiceImpl extends EscalaService<EscalaDTO, EscalaVO> {

	private EscalaEAO escalaEAO = new EscalaEAO();
	private ValidatorEscala validatorEscala = new ValidatorEscala();
	
//	@Override
//	public List<EscalaVO> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public EscalaDTO find(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public String insert(EscalaDTO escalaDTO) {
		
		Escala escala = resolverEscalaDTO(escalaDTO);

		validatorEscala.fieldsRequireds(escala);
		validatorEscala.validarEscalaConflito(escala);
		
		Long respost = escalaEAO.insert(escala);

		return respost != null ? respost(ESCALA_SAVE_SUCCESS.getMsg(), true, respost) : respost(ESCALA_SAVE_ERROR.getMsg(), false, respost);
	}

	private Escala resolverEscalaDTO(EscalaDTO escalaDTO) {
		Escala escala = new Escala();
		VinculoPessoaGrupoEAO vinculoPessoaGrupoEAO = new VinculoPessoaGrupoEAO();

		VinculoPessoaGrupo vinculoPessoaGrupo = vinculoPessoaGrupoEAO.find(VinculoPessoaGrupo.class, escalaDTO.getIdVinculoPessoaGrupo());
		
		if(escalaDTO.getIdEscala() != null){
			//consultar
			escala.setIdescala(escalaDTO.getIdEscala());			
		}
		escala.setVinculoPessoaGrupo(vinculoPessoaGrupo);
		escala.setDataInicial(escalaDTO.getDataInicial());
		escala.setDataFinal(escalaDTO.getDataFinal());
		
		return escala;
	}

//	@Override
//	public String update(EscalaDTO entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	nha
	@Override
	public String delete(Long idEscala) {
		System.out.println(idEscala);
		return null;
	}
	
	public PagedResult<EscalaDTO> pagedMembrosFromEscala(int page, int size, Long idMinisterio, Long idGrupo, EscalaDTO escalaDTO) {
		
		BeanConsultGroup beanConsultGroup = new BeanConsultGroup(page, size);
		
		List<EscalaDTO> escalaDTOList = escalaEAO.executeSQLPaged(EscalaDTO.class, beanConsultGroup, getMembrosGrupoEscalados(), 
					asList("idGrupo", "idClassificacaoMembro", "dataInicial", "dataFinal"),
					asList(idGrupo, escalaDTO.getIdClassificacaoMembro(), escalaDTO.getDataInicial(), escalaDTO.getDataFinal()));

		
		
		BigInteger sizeBD = escalaEAO.executeSQLOneResult(getQueryCountMembros(), 
				asList("idMinisterio", "idGrupo"),
				asList(idMinisterio, idGrupo));
		
		if (escalaDTOList != null && sizeBD != null) {
			
			return new PagedResult<EscalaDTO>(sizeBD, escalaDTOList);
		} else {
			throw new OQJFException(Status.INTERNAL_SERVER_ERROR,"Erro ao encontar membros.");
		}
	}
	

}
