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
    private Long grupoHasPessoaPessoaIdpessoa;
    private Long grupoHasPessoaGrupoIdgrupo;
    private Date dataescala;

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
    public Long getGrupoHasPessoaPessoaIdpessoa() {
        return this.grupoHasPessoaPessoaIdpessoa;
    }
    
    public void setGrupoHasPessoaPessoaIdpessoa(Long grupoHasPessoaPessoaIdpessoa) {
        this.grupoHasPessoaPessoaIdpessoa = grupoHasPessoaPessoaIdpessoa;
    }

    @Column(name="grupo_has_pessoa_grupo_idgrupo", nullable=false)
    public Long getGrupoHasPessoaGrupoIdgrupo() {
        return this.grupoHasPessoaGrupoIdgrupo;
    }
    
    public void setGrupoHasPessoaGrupoIdgrupo(Long grupoHasPessoaGrupoIdgrupo) {
        this.grupoHasPessoaGrupoIdgrupo = grupoHasPessoaGrupoIdgrupo;
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


