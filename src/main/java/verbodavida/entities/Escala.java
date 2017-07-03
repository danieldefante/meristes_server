package verbodavida.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="escala", schema="public")
public class Escala  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idEscala;
    
	private Long grupoHasPessoaPessoaIdPessoa;
    
    private Long grupoHasPessoaGrupoIdGrupo;
    
    private Date dataEscala;

    public Escala() {
    }
     
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idescala", unique=true, nullable=false)
    public Long getIdEscala() {
        return this.idEscala;
    }
    
    public void setIdEscala(Long idEscala) {
        this.idEscala = idEscala;
    }
    
    @Column(name="grupo_has_pessoa_pessoa_idpessoa", nullable=false)
    public Long getGrupoHasPessoaPessoaIdPessoa() {
        return this.grupoHasPessoaPessoaIdPessoa;
    }
    
    public void setGrupoHasPessoaPessoaIdPessoa(Long grupoHasPessoaPessoaIdPessoa) {
        this.grupoHasPessoaPessoaIdPessoa = grupoHasPessoaPessoaIdPessoa;
    }

    @Column(name="grupo_has_pessoa_grupo_idGrupo", nullable=false)
    public Long getGrupoHasPessoaGrupoIdGrupo() {
        return this.grupoHasPessoaGrupoIdGrupo;
    }
    
    public void setGrupoHasPessoaGrupoIdGrupo(Long grupoHasPessoaGrupoIdGrupo) {
        this.grupoHasPessoaGrupoIdGrupo = grupoHasPessoaGrupoIdGrupo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataescala", length=13)
    public Date getDataEscala() {
        return this.dataEscala;
    }
    
    public void setDataEscala(Date dataEscala) {
        this.dataEscala = dataEscala;
    }
}


