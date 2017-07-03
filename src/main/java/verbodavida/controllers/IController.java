package verbodavida.controllers;

import java.util.List;

public interface IController<T, R> {

	List<R> findAll();
	
	T find(Long id);
	
	String insert(T entity);

	String update(T entity);

	String delete(Long id);
	
}
  