package verbodavida.dtos;

import java.util.Date;

import verbodavida.entities.VinculoPessoaGrupo;

public class EscalaDTO {

	private Long idEscala;
	private VinculoPessoaGrupo vinculoPessoaGrupo;
	private Date dataInicial;
	private Date dataFinal;
	
	public Long getIdEscala() {
		return idEscala;
	}
	public void setIdEscala(Long idEscala) {
		this.idEscala = idEscala;
	}
	
	public VinculoPessoaGrupo getVinculoPessoaGrupo() {
		return vinculoPessoaGrupo;
	}
	
	public void setVinculoPessoaGrupo(VinculoPessoaGrupo vinculoPessoaGrupo) {
		this.vinculoPessoaGrupo = vinculoPessoaGrupo;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
