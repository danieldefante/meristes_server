package verbodavida.eaos;

import static verbodavida.utils.PersistDB.deleteEntity;
import static verbodavida.utils.PersistDB.findAllEntity;
import static verbodavida.utils.PersistDB.findEntity;
import static verbodavida.utils.PersistDB.insertEntity;
import static verbodavida.utils.PersistDB.updateEntity;

import java.util.List;

import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PersistDB;

public class IEAO {

	public <T> List<T> findAll(Class<T> clazz) {
		return findAllEntity(clazz);
	}

	public <T> List<T> findAll(Class<T> clazz, BeanConsultGroup beanConsultGroup) {
		return findAllEntity(clazz, beanConsultGroup);
	}

	public <T> T find(Class<T> clazz, Long id) {
		return findEntity(clazz, id);
	}

	public <T> List<T> findListByHQL(BeanConsultGroup beanConsultGroup, String sql, List<String> nameParam, List<Object> valueParam) {
		return PersistDB.executeHQL(beanConsultGroup, sql,  nameParam,  valueParam);
	}

	public Object executeHQLOneResult(String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeHQLOneResult( sql,  namesParamList,  valuesParamList);
	}

	public <T> String insert(T entity) {
		return insertEntity(entity);
	}

	public <T> String insertList(List<T> entitys) {
		return insertList(entitys);
	}

	public <T> String update(T entity) {
		return updateEntity(entity);
	}

	public String delete(Long id) {
		return deleteEntity(id);
	}
	
}
