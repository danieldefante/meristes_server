package verbodavida.dtos;

public class ClassificacaoMembroDTO {

	private Long idClassificacaoMembro;
    
	private Long idMinisterio;

    private String descricao;

	public Long getIdClassificacaoMembro() {
		return idClassificacaoMembro;
	}

	public void setIdClassificacaoMembro(Long idClassificacaoMembro) {
		this.idClassificacaoMembro = idClassificacaoMembro;
	}

	public Long getIdMinisterio() {
		return idMinisterio;
	}
	
	public void setIdMinisterio(Long idMinisterio) {
		this.idMinisterio = idMinisterio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
