package verbodavida.dtos;

import java.util.ArrayList;
import java.util.List;

public class MinisterioDTO {

	private Long idMinisterio;
    
	private String nome;
    
	private String descricao;
	
	private String visao;

	private String normas;
	
	private String observacoes;
    
	private List<GrupoDTO> grupos = new ArrayList<GrupoDTO>();
	
	private List<ClassificacaoMembroDTO> classificacaoMembros = new ArrayList<ClassificacaoMembroDTO>();
	
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
	
	public List<GrupoDTO> getGrupos() {
        return this.grupos;
    }
	    
    public void setGrupos(List<GrupoDTO> grupos) {
        this.grupos = grupos;
    }

    public List<ClassificacaoMembroDTO> getClassificacaoMembros() {
    	return this.classificacaoMembros;
    }
    
    public void setClassificacaoMembros(List<ClassificacaoMembroDTO> classificacaoMembros) {
    	this.classificacaoMembros = classificacaoMembros;
    }

}
