package verbodavida.vos;

import java.math.BigInteger;

public class FuncaoMinisterialVO {

	private Long idFuncaoMinisterial;

    private String descricao;

	public Long getIdFuncaoMinisterial() {
		return idFuncaoMinisterial;
	}

	public void setIdFuncaoMinisterial(BigInteger idFuncaoMinisterial) {
		this.idFuncaoMinisterial = idFuncaoMinisterial.longValue();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
