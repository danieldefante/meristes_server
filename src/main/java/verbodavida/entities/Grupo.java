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
@Table(name="grupo", schema="public")
public class Grupo  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idGrupo;
    private Ministerio ministerio;
    private String nome;
    private String descricao;
    private Set<VinculoPessoaGrupo> vinculoPessoaGrupos = new HashSet<VinculoPessoaGrupo>(0);
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idgrupo", unique=true, nullable=false)
    public Long getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ministerio_idministerio", nullable=false)
    public Ministerio getMinisterio() {
        return this.ministerio;
    }
    
    public void setMinisterio(Ministerio ministerio) {
        this.ministerio = ministerio;
    }

    @Column(name="nome", length=50)
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
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="grupo")
    public Set<VinculoPessoaGrupo> getVinculoPessoaGrupos() {
        return this.vinculoPessoaGrupos;
    }
    
    public void setVinculoPessoaGrupos(Set<VinculoPessoaGrupo> vinculoPessoaGrupos) {
        this.vinculoPessoaGrupos = vinculoPessoaGrupos;
    }

}
