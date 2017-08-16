package verbodavida.vos;

import java.math.BigInteger;

public class PessoaVO {

	private Long idPessoa;

	private String nome;

	private String sobrenome;
	
	private boolean escaladoVinculado;

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

	public boolean getEscaladoVinculado() {
		return escaladoVinculado;
	}

	public void setEscaladoVinculado(boolean escaladoVinculado) {
		this.escaladoVinculado = escaladoVinculado;
	}

}
