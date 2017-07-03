package verbodavida.entities;

import java.io.Serializable;

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
@Table(name="grupo", schema="public")
public class Grupo  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idGrupo;
    
	private Ministerio ministerio;
    
    private String nome;

    private String descricao;

    public Grupo() {
    }
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idgrupo", unique=true, nullable=false)
    public Long getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    @ManyToOne(fetch=FetchType.EAGER)
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
}

//{"grupos": "nome":"sala 0-4", "descricao":"todas as crianças",{"nome":"Teatro","descricao":"teatro do evangelismo vai ser tremendo"}}
