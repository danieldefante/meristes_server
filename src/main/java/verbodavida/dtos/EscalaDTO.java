package verbodavida.dtos;

import java.math.BigInteger;
import java.sql.Timestamp;

public class EscalaDTO {

	private Long idPessoa;
	
	private String nome;
	
	private String sobrenome;
	
	private Long idClassificacaoMembro;
	
	private Boolean escaladoGrupoAtual;
	
	private Boolean escaladoOutroGrupo;
	
	private Long idEscala;
	
	private Timestamp dataInicial;
	
	private Timestamp dataFinal;
	
	private Long idVinculoPessoaGrupo;
	
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
	
	public Long getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(Long idEscala) {
		this.idEscala = idEscala;
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

	public Long getIdVinculoPessoaGrupo() {
		return idVinculoPessoaGrupo;
	}

	public void setIdVinculoPessoaGrupo(BigInteger idVinculoPessoaGrupo) {
		this.idVinculoPessoaGrupo = idVinculoPessoaGrupo.longValue();
	}
}