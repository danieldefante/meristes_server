package verbodavida.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="funcao_ministerial", schema="public")
public class FuncaoMinisterial  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idFuncaoMinisterial;
    private Pessoa pessoa;
    private ClassificacaoMembro classificacaoMembro;
    private Set<Escala> escalas = new HashSet<Escala>(0);
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idfuncao_ministerial", unique=true, nullable=false)
    public Long getIdFuncaoMinisterial() {
        return this.idFuncaoMinisterial;
    }
    
    public void setIdFuncaoMinisterial(Long idFuncaoMinisterial) {
        this.idFuncaoMinisterial = idFuncaoMinisterial;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pessoa_idpessoa", nullable=false)
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idclassificacao_membro", nullable=false)
    public ClassificacaoMembro getClassificacaoMembroi() {
        return this.classificacaoMembro;
    }
    
    public void setClassificacaoMembro(ClassificacaoMembro classificacaoMembro) {
        this.classificacaoMembro = classificacaoMembro;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="funcao_ministerial")
    public Set<Escala> getEscalas() {
        return this.escalas;
    }
    
    public void setEscalas(Set<Escala> escalas) {
        this.escalas = escalas;
    }

}


