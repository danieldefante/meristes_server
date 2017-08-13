package verbodavida.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="vinculo_pessoa_grupo", schema="public")
public class VinculoPessoaGrupo  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idVinculoPessoaGrupo;
    private Grupo grupo;
    private Pessoa pessoa;
    private Date dataVinculacao;
    private Set<Escala> escalas = new HashSet<Escala>(0);

   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvinculo_pessoa_grupo", unique=true, nullable=false)
    public Long getIdVinculoPessoaGrupo() {
        return this.idVinculoPessoaGrupo;
    }
    
    public void setIdVinculoPessoaGrupo(Long idVinculoPessoaGrupo) {
        this.idVinculoPessoaGrupo = idVinculoPessoaGrupo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grupo_idgrupo", nullable=false)
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pessoa_idpessoa", nullable=false)
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_vinculacao", length=13)
    public Date getDataVinculacao() {
        return this.dataVinculacao;
    }
    
    public void setDataVinculacao(Date dataVinculacao) {
        this.dataVinculacao = dataVinculacao;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="vinculo_pessoa_grupo")
    public Set<Escala> getEscalas() {
        return this.escalas;
    }
    
    public void setEscalas(Set<Escala> escalas) {
        this.escalas = escalas;
    }
}


