package verbodavida.vos;

import java.math.BigInteger;

public class PessoaVO {

	private Long idPessoa;

	private String nome;

	private String sobrenome;
	
	private boolean ativo;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(BigInteger idPessoa) {
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

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
