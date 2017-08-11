package verbodavida.vos;

public class PessoaVO {

	private Long idPessoa;

	private String nome;

	private String sobrenome;
	
	private Boolean escalado;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa.longValue();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Boolean getEscalado() {
		return escalado;
	}

	public void setEscalado(Boolean escalado) {
		this.escalado = escalado;
	}
}
