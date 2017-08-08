package verbodavida.dtos;

import java.util.Date;

public class PessoaDTO {

	private Long idPessoa;

	private ContatoDTO contato;

	private EnderecoDTO endereco;

	private String nome;

	private String sobrenome;
	
	private Date dataNascimento;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public ContatoDTO getContato() {
		return contato;
	}

	public void setContato(ContatoDTO contato) {
		this.contato = contato;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
