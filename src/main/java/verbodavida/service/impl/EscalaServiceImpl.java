package verbodavida.service.impl;

import java.util.List;

import verbodavida.dtos.ConverterEntity;
import verbodavida.dtos.EscalaDTO;
import verbodavida.eaos.EscalaEAO;
import verbodavida.entities.Escala;
import verbodavida.services.EscalaService;
import verbodavida.validators.ValidadorEscala;
import verbodavida.vos.EscalaVO;

public class EscalaServiceImpl extends EscalaService<EscalaDTO, EscalaVO> {

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
		
		ValidadorEscala validadorEscala = new ValidadorEscala(escala);
		
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
	

}
