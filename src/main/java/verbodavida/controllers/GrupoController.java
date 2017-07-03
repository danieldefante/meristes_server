package verbodavida.controllers;

import static verbodavida.dtos.ConverterEntity.converterEntetyToListVO;
import static verbodavida.dtos.ConverterEntity.converterEntity;
import static verbodavida.utils.PersistDB.deleteEntity;
import static verbodavida.utils.PersistDB.findAllEntity;
import static verbodavida.utils.PersistDB.insertEntity;
import static verbodavida.utils.PersistDB.updateEntity;

import java.util.List;

import verbodavida.dtos.GrupoDTO;
import verbodavida.entities.Grupo;
import verbodavida.utils.PersistDB;
import verbodavida.vos.GrupoVO;

public class GrupoController implements IController<GrupoDTO, GrupoVO> {

	@Override
	public List<GrupoVO> findAll() {
		return converterEntetyToListVO(
				GrupoVO.class,
				findAllEntity(Grupo.class));
	}

	@Override
	public GrupoDTO find(Long id) {
		return converterEntity(
				GrupoDTO.class,
				PersistDB.findEntity(Grupo.class, id));
	}

	@Override
	public String insert(GrupoDTO grupoDTO) {
		return insertEntity(
				converterEntity(Grupo.class, grupoDTO));
	}

	@Override
	public String update(GrupoDTO grupoDTO) {
		return updateEntity(
				converterEntity(Grupo.class, grupoDTO));
	}

	@Override
	public String delete(Long id) {
		return deleteEntity(id);
	}

	
}
