package verbodavida.dtos;

import verbodavida.entities.Contato;
import verbodavida.entities.Endereco;

public class PessoaDTO {

	private Long idPessoa;

	private Contato contato;

	private Endereco endereco;

	private String nome;

	private String sobrenome;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

//	@JsonIgnore
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

//	@JsonIgnore
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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


}
