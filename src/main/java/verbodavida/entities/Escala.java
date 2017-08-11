package verbodavida.entities;
// Generated Aug 8, 2017 1:05:09 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Escala generated by hbm2java
 */
@Entity
@Table(name="escala"
    ,schema="public"
)
public class Escala  implements java.io.Serializable {


     private int idescala;
     private VinculoPessoaGrupo vinculoPessoaGrupo;
     private Date dataescala;

    public Escala() {
    }

	
    public Escala(int idescala, VinculoPessoaGrupo vinculoPessoaGrupo) {
        this.idescala = idescala;
        this.vinculoPessoaGrupo = vinculoPessoaGrupo;
    }
    public Escala(int idescala, VinculoPessoaGrupo vinculoPessoaGrupo, Date dataescala) {
       this.idescala = idescala;
       this.vinculoPessoaGrupo = vinculoPessoaGrupo;
       this.dataescala = dataescala;
    }
   
     @Id 

    
    @Column(name="idescala", unique=true, nullable=false)
    public int getIdescala() {
        return this.idescala;
    }
    
    public void setIdescala(int idescala) {
        this.idescala = idescala;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vinculo_pessoa_grupo_idvinculo_pessoa_grupo", nullable=false)
    public VinculoPessoaGrupo getVinculoPessoaGrupo() {
        return this.vinculoPessoaGrupo;
    }
    
    public void setVinculoPessoaGrupo(VinculoPessoaGrupo vinculoPessoaGrupo) {
        this.vinculoPessoaGrupo = vinculoPessoaGrupo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataescala", length=13)
    public Date getDataescala() {
        return this.dataescala;
    }
    
    public void setDataescala(Date dataescala) {
        this.dataescala = dataescala;
    }




}


