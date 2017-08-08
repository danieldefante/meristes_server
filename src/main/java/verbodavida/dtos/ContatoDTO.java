package verbodavida.dtos;

public class ContatoDTO {

	private Long idContato;
	private String celular;
	private String celulartwo;
	private String telefone;
	private String telefonetwo;
	private String email;
	
	public Long getIdContato() {
		return idContato;
	}
	
	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getCelularTwo() {
		return celulartwo;
	}
	
	public void setCelularTwo(String celulartwo) {
		this.celulartwo = celulartwo;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefoneTwo() {
		return telefonetwo;
	}
	
	public void setTelefoneTwo(String telefonetwo) {
		this.telefonetwo = telefonetwo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
