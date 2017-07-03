package verbodavida.services;

import java.util.List;

public interface IService<T, R> {

	public List<R> findAll();

	public T find(Long id);

	public String insert(T entity);
	
	public String update(T entity);
	
	public String delete(Long id);
	

	
	
}
