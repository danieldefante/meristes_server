package verbodavida.resouceconfig;

import java.util.List;

import verbodavida.utils.PagedResult;

public class GerericResouce<T, R> {

	public List<R> findAll(){
		return null;
	};

	public PagedResult findAll(int page, int size) {
		return null;
	}

	public PagedResult findAll(int page, int size, Long id){
		return null;
	};

	public T find(Long id){
		return null;
	};

	public T find(Long idParent, Long id){
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

	public String delete(Long idParent, Long id){
		return null;
	}


}
