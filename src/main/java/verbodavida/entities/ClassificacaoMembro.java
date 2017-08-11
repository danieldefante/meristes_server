package verbodavida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classificacao_membro", schema="public"
)
public class ClassificacaoMembro  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idClassificacaoMembro;
    private Ministerio ministerio;
    private String descricao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name="idclassificacao_membro", unique=true, nullable=false)
    public Long getIdClassificacaoMembro() {
        return this.idClassificacaoMembro;
    }
    
    public void setIdClassificacaoMembro(Long idClassificacaoMembro) {
        this.idClassificacaoMembro = idClassificacaoMembro;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ministerio_idministerio", nullable=false)
    public Ministerio getMinisterio() {
        return this.ministerio;
    }
    
    public void setMinisterio(Ministerio ministerio) {
        this.ministerio = ministerio;
    }

    @Column(name="descricao")
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}


