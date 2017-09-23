package verbodavida.eaos;

import static verbodavida.utils.PersistDB.deleteEntity;
import static verbodavida.utils.PersistDB.findAllEntity;
import static verbodavida.utils.PersistDB.findEntity;
import static verbodavida.utils.PersistDB.insertEntity;
import static verbodavida.utils.PersistDB.insertListEntitys;
import static verbodavida.utils.PersistDB.updateEntity;
import static verbodavida.utils.PersistDB.updateListEntitys;

import java.util.List;

import verbodavida.utils.BeanConsultGroup;
import verbodavida.utils.PersistDB;

public class IEAO {

	
	///FINDS

	public <T> T find(Class<T> clazz, Long id) {
		return findEntity(clazz, id);
	}
	
	public <T> T find(Class<T> clazz, String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeHQLOneResult( sql,  namesParamList,  valuesParamList);
	}

	///LISTS
	public <T> List<T> findAll(Class<T> clazz) {
		return findAllEntity(clazz);
	}
	
//	public <T> List<T> findPagedList(Class<T> clazz, BeanConsultGroup beanConsultGroup) {
//		return findAllEntity(clazz, beanConsultGroup);
//	}

//	public <T> List<T> findPagedList(Class<T> clazz, BeanConsultGroup beanConsultGroup, String sql, List<String> nameParam, List<Object> valueParam) {
//		return PersistDB.executeHQL(clazz, beanConsultGroup, sql,  nameParam,  valueParam);
//	}



	
	///SQLS
	public <T> T executeSQLOneResult(String sql) {
		return PersistDB.executeSQLOneResult(sql);
	}
	
	public <T> T executeSQLOneResult(Class<T> clazz, String sql) {
		return PersistDB.executeSQLOneResult(clazz, sql);
	}
	
	public <T> T executeSQLOneResult(String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeSQLOneResult(sql, namesParamList,  valuesParamList);
	}

	public <T> T executeSQLOneResult(Class<T> clazz, String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeSQLOneResult(clazz, sql, namesParamList,  valuesParamList);
	}

	public <T> List<T> executeSQLResultList(Class<T> clazz, String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeSQLReturnList(clazz, sql, namesParamList,  valuesParamList);
	}
	
	///HQLa
	
	public <T> List<T> executeHQLResultList(Class<T> clazz, String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeHQL(clazz, sql, namesParamList,  valuesParamList);
	}


//	public Object executeSQL(String sql, List<String> namesParamList, List<Object> valuesParamList) {
//		return PersistDB.executeSQL( sql,  namesParamList,  valuesParamList);
//	}

	//PAGED
	public <T> List<T> executeSQLPaged(BeanConsultGroup beanConsultGroup, String sql) {
		return PersistDB.executeSQL(beanConsultGroup, sql);
	}
	
	public <T> List<T> executeSQLPaged(Class<T> clazz, BeanConsultGroup beanConsultGroup, String sql) {
		return PersistDB.executeSQL(clazz,  beanConsultGroup, sql);
	}
	
	public <T> List<T> executeSQLPaged(Class<T> clazz, BeanConsultGroup beanConsultGroup, String sql, List<String> namesParamList, List<Object> valuesParamList) {
		return PersistDB.executeSQL(clazz, beanConsultGroup,  sql,  namesParamList,  valuesParamList);
	}

	
	
	
	//COMUN
	
	public <T> Long insert(T entity) {
		return insertEntity(entity);
	}

	public <T> Boolean insertList(List<T> entitys) {
		return insertListEntitys(entitys);
	}

	public <T> Boolean update(T entity) {
		return updateEntity(entity);
	}

	public <T> Boolean updateList(List<T> entitys) {
		return updateListEntitys(entitys);
	}

	public Boolean delete(Long id) {
		return deleteEntity(id);
	}
	
}
