package verbodavida.eaos;

import static verbodavida.utils.PersistDB.findEntity;
import static verbodavida.utils.PersistDB.findAllEntity;
import static verbodavida.utils.PersistDB.insertEntity;
import static verbodavida.utils.PersistDB.updateEntity;
import static verbodavida.utils.PersistDB.deleteEntity;

import java.util.List;

public class IEAO {

	public <T> List<T> findAll(Class<T> clazz) {
		return findAllEntity(clazz);
	}

	public <T> T find(Class<T> clazz, Long id) {
		return findEntity(clazz, id);
	}

	public <T> String insert(T entity) {
		return insertEntity(entity);
	}

	public <T> String update(T entity) {
		return updateEntity(entity);
	}

	public String delete(Long id) {
		return deleteEntity(id);
	}
}
