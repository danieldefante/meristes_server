package verbodavida.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="escala", schema="public")
public class Escala implements Serializable {

	private static final long serialVersionUID = 1L;

    private long idescala;
    private VinculoPessoaGrupo vinculoPessoaGrupo;
    private long funcaoMinisterialIdfuncaoMinisterial;
    private Date dataInicial;
    private Date dataFinal;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idescala", unique=true, nullable=false)
    public long getIdescala() {
        return this.idescala;
    }
    
    public void setIdescala(long idescala) {
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

    
    @Column(name="funcao_ministerial_idfuncao_ministerial", nullable=false)
    public long getFuncaoMinisterialIdfuncaoMinisterial() {
        return this.funcaoMinisterialIdfuncaoMinisterial;
    }
    
    public void setFuncaoMinisterialIdfuncaoMinisterial(long funcaoMinisterialIdfuncaoMinisterial) {
        this.funcaoMinisterialIdfuncaoMinisterial = funcaoMinisterialIdfuncaoMinisterial;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_inicial", length=13)
    public Date getDataInicial() {
        return this.dataInicial;
    }
    
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_final", length=13)
    public Date getDataFinal() {
        return this.dataFinal;
    }
    
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}