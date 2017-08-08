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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ministerio", schema="public")
public class Ministerio  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idMinisterio;
    private String nome;
    private String descricao;
    private String visao;
    private String normas;
    private String observacoes;
    private Set<Grupo> grupos = new HashSet<Grupo>(0);
    private Set<ClassificacaoMembro> classificacaoMembros = new HashSet<ClassificacaoMembro>(0);

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idministerio", unique=true, nullable=false)
    public Long getIdMinisterio() {
        return this.idMinisterio;
    }
    
    public void setIdMinisterio(Long idMinisterio) {
        this.idMinisterio = idMinisterio;
    }
    
    @Column(name="nome", length=40)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name="descricao")
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name="visao")
    public String getVisao() {
        return this.visao;
    }
    
    public void setVisao(String visao) {
        this.visao = visao;
    }

    @Column(name="normas")
    public String getNormas() {
        return this.normas;
    }
    
    public void setNormas(String normas) {
        this.normas = normas;
    }

    @Column(name="observacoes")
    public String getObservacoes() {
        return this.observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="ministerio")
    @Cascade({CascadeType.ALL})
    public Set<Grupo> getGrupos() {
        return this.grupos;
    }
    
    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="ministerio")
    @Cascade({CascadeType.ALL})
    public Set<ClassificacaoMembro> getClassificacaoMembros() {
        return this.classificacaoMembros;
    }
    
    public void setClassificacaoMembros(Set<ClassificacaoMembro> classificacaoMembros) {
        this.classificacaoMembros = classificacaoMembros;
    }

}


