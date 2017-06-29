package verbodavida.controllers;

import java.util.List;

public interface IController<T> {

	String insert(T entity);
	
	String update(T entity);
	
	String delete(Long id);

	T find(Long id);

	List<T> findAll();
	
}
  