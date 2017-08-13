package verbodavida.vos;

import java.math.BigInteger;

public class ClassificacaoMembroVO {

	private Long idClassificacaoMembro;

    private String descricao;

	public Long getIdClassificacaoMembro() {
		return idClassificacaoMembro;
	}

	public void setIdClassificacaoMembro(BigInteger idClassificacaoMembro) {
		this.idClassificacaoMembro = idClassificacaoMembro.longValue();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
