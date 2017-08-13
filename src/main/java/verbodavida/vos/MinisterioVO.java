package verbodavida.vos;

import java.math.BigInteger;

public class MinisterioVO {
	
	private Long idMinisterio;
    
	private String nome;
    
	private String descricao;

	public Long getIdMinisterio() {
		return idMinisterio;
	}

	public void setIdMinisterio(BigInteger idMinisterio) {
		this.idMinisterio = idMinisterio.longValue();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
