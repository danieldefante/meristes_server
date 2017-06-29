package verbodavida.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ministerio", schema="public")
public class Ministerio implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long idMinisterio;
    
	private String nome;
    
	private String descricao;
    
	private Set<Grupo> grupos = new HashSet<Grupo>(0);

    public Ministerio() {
    }

	
    public Ministerio(Long idMinisterio) {
        this.idMinisterio = idMinisterio;
    }
    public Ministerio(Long idMinisterio, String nome, String descricao, Set<Grupo> grupos) {
       this.idMinisterio = idMinisterio;
       this.nome = nome;
       this.descricao = descricao;
       this.grupos = grupos;
    }
   
    @Id 
    @Column(name="idMinisterio", unique=true, nullable=false)
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

//    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy="ministerio")
    public Set<Grupo> getGrupos() {
        return this.grupos;
    }
    
    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
}


