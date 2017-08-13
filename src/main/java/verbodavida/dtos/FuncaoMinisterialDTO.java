package verbodavida.dtos;

import java.util.Date;

public class FuncaoMinisterialDTO {

	private Long idFuncaoMinisterial;
	private GrupoDTO grupo;
	private PessoaDTO pessoa;
	private Date dataVinculacao;
	
	public Long getIdFuncaoMinisterial() {
		return idFuncaoMinisterial;
	}
	
	public void setIdFuncaoMinisterial(Long idFuncaoMinisterial) {
		this.idFuncaoMinisterial = idFuncaoMinisterial;
	}
	
	public GrupoDTO getGrupo() {
		return grupo;
	}
	
	public void setGrupo(GrupoDTO grupo) {
		this.grupo = grupo;
	}
	
	public PessoaDTO getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
	public Date getDataVinculacao() {
		return dataVinculacao;
	}
	
	public void setDataVinculacao(Date dataVinculacao) {
		this.dataVinculacao = dataVinculacao;
	}
}
