package verbodavida.dtos;

public class GrupoDTO {

	private Long idGrupo;
    
	private Long idMinisterio;
	
    private String nome;

    private String descricao;

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Long getIdMinisterio() {
		return idMinisterio;
	}
	
	public void setIdMinisterio(Long idMinisterio) {
		this.idMinisterio = idMinisterio;
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
