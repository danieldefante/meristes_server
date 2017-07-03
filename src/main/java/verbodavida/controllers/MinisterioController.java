package verbodavida.controllers;

import static verbodavida.dtos.ConverterEntity.converterEntetyToListVO;
import static verbodavida.dtos.ConverterEntity.converterEntity;

import java.util.List;

import verbodavida.dtos.MinisterioDTO;
import verbodavida.eaos.MinisterioEAO;
import verbodavida.entities.Ministerio;
import verbodavida.vos.MinisterioVO;

public class MinisterioController implements IController<MinisterioDTO, MinisterioVO>{

	private MinisterioEAO ministerioEAO = new MinisterioEAO();

	@Override
	public String insert(MinisterioDTO ministerio) {
		return ministerioEAO.insert(
				converterEntity(Ministerio.class, ministerio));
	}

	@Override
	public String update(MinisterioDTO ministerio) {
		return ministerioEAO.update(ministerio);
	}

	@Override
	public String delete(Long id) {
		return ministerioEAO.delete(id);
	}

	@Override
	public MinisterioDTO find(Long id) {
		 return converterEntity(
				 MinisterioDTO.class,
				 ministerioEAO.find(Ministerio.class, id));
	}

	@Override
	public List<MinisterioVO> findAll() {
		return converterEntetyToListVO(
				MinisterioVO.class, 
				ministerioEAO.findAll(Ministerio.class));
	}

}