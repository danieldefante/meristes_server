package verbodavida.dtos;

import java.util.HashSet;
import java.util.Set;

public class MinisterioDTO {

	private Long idMinisterio;
    
	private String nome;
    
	private String descricao;
	
	private String visao;

	private String normas;
	
	private String observacoes;
    
	private Set<GrupoDTO> grupos = new HashSet<GrupoDTO>(0);
	
	private Set<ClassificacaoMembroDTO> classificacaoMembros = new HashSet<ClassificacaoMembroDTO>(0);
	
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
	
	public String getVisao() {
		return visao;
	}
    
    public void setVisao(String visao) {
		this.visao = visao;
	}
    
    public String getNormas() {
		return normas;
	}
    
    public void setNormas(String normas) {
		this.normas = normas;
	}
    
    public String getObservacoes() {
		return observacoes;
	}
    
    public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public Set<GrupoDTO> getGrupos() {
        return this.grupos;
    }
	    
    public void setGrupos(Set<GrupoDTO> grupos) {
        this.grupos = grupos;
    }

    public Set<ClassificacaoMembroDTO> getClassificacaoMembros() {
    	return this.classificacaoMembros;
    }
    
    public void setClassificacaoMembros(Set<ClassificacaoMembroDTO> classificacaoMembros) {
    	this.classificacaoMembros = classificacaoMembros;
    }

}
