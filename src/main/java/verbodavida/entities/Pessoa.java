package verbodavida.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="pessoa", schema="public")
public class Pessoa  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idPessoa;
    private Endereco endereco;
    private Contato contato;
    private String nome;
    private String sobrenome;
    private Date datanascimento;
    private Set<VinculoPessoaGrupo> vinculoPessoaGrupos = new HashSet<VinculoPessoaGrupo>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpessoa", unique=true, nullable=false)
    public Long getIdPessoa() {
        return this.idPessoa;
    }
    
    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="contato_idcontato", nullable=false)
    public Contato getContato() {
        return this.contato;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="endereco_idendereco", nullable=false)
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    @Column(name="nome", length=50)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="sobrenome", length=50)
    public String getSobrenome() {
        return this.sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datanascimento", length=13)
    public Date getDatanascimento() {
        return this.datanascimento;
    }
    
    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="pessoa")
    public Set<VinculoPessoaGrupo> getVinculoPessoaGrupos() {
        return this.vinculoPessoaGrupos;
    }
    
    public void setVinculoPessoaGrupos(Set<VinculoPessoaGrupo> vinculoPessoaGrupos) {
        this.vinculoPessoaGrupos = vinculoPessoaGrupos;
    }
}


