package verbodavida.controllers;

public interface IController {

	String insert(String data);
	
	String update(String data);
	
	String delete(String data);

	String find(String data);

	String findAll(String data);
	
}
