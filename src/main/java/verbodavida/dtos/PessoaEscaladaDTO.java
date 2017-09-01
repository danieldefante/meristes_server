package verbodavida.dtos;

import java.math.BigInteger;
import java.sql.Timestamp;

public class PessoaEscaladaDTO {

	private Long idPessoa;
	private String nome;
	private String sobrenome;
	private Long idClassificacaoMembro;
	private Boolean escaladoGrupoAtual;
	private Boolean escaladoOutroGrupo;
	private Timestamp dataInicial;
	private Timestamp dataFinal;
	
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
	
	public Boolean getEscaladoGrupoAtual() {
		return escaladoGrupoAtual;
	}
	
	public void setEscaladoGrupoAtual(Boolean escaladoGrupoAtual) {
		this.escaladoGrupoAtual = escaladoGrupoAtual;
	}
	
	public Boolean getEscaladoOutroGrupo() {
		return escaladoOutroGrupo;
	}
	
	public void setEscaladoOutroGrupo(Boolean escaladoOutroGrupo) {
		this.escaladoOutroGrupo = escaladoOutroGrupo;
	}
	
	public Timestamp getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Timestamp dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Timestamp getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Timestamp dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Long getIdClassificacaoMembro() {
		return idClassificacaoMembro;
	}

	public void setIdClassificacaoMembro(Long idClassificacaoMembro) {
		this.idClassificacaoMembro = idClassificacaoMembro;
	}
}