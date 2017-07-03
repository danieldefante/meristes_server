package verbodavida.dtos;

import java.util.HashSet;
import java.util.Set;

public class MinisterioDTO {

	private Long idMinisterio;
    
	private String nome;
    
	private String descricao;
    
	private Set<GrupoDTO> grupos = new HashSet<GrupoDTO>(0);

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

	public Set<GrupoDTO> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<GrupoDTO> grupos) {
		this.grupos = grupos;
	}

}
