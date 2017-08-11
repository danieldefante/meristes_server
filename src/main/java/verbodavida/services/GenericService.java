package verbodavida.services;

import java.math.BigInteger;
import java.util.List;

import verbodavida.utils.PagedResult;

public class GenericService<T, R> {

	public List<R> findAll(){
		return null;
	};

	public PagedResult<R> findAll(int page, int size){
		return null;
	};
	
	public PagedResult<R> findAll(int page, int size, Long id){
		return null;
	};
	
	public T find(Long id){
		return null;
	};
	
	public T find(Long idParent, Long id) {
		return null;
	};
	
	public String insert(T entity){
		return null;
	};
	
	public String update(T entity){
		return null;
	};

	public String delete(Long id){
		return null;
	};
	
	public List<T> find(List<String> nameParams, List<Object> params){
		return null;
	}

	public String insertList(List<T> entityDTOList) {
		return null;
	}

	public BigInteger countRegister(String query, List<String> nameParams, List<Object> params) {
		return null;
	}
	
}
  