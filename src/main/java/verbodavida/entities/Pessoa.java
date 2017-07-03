package verbodavida.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="pessoa", schema="public")
public class Pessoa  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPessoa;
    
	private Contato contato;
    
	private Endereco endereco;
    
	private String nome;
    
	private String sobrenome;
    
	private Date dataNascimento;

    public Pessoa() {
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpessoa", unique=true, nullable=false)
    public Long getIdPessoa() {
        return this.idPessoa;
    }
    
    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="contato_idcontato", nullable=false)
    public Contato getContato() {
        return this.contato;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }

//    @LazyCollection(LazyCollectionOption.FALSE)
//  @JsonIgnore
//    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
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
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

/*{
    "idpessoa":"0",
    "nome":"Daniel",
    "sobrenome":"Defante",
     "datanascimento":"1498697766590",
 "contato":{ 
                   "idcontato":"0",
                   "celular":"98323223",
                   "celular2":"9908088",
                   "telefone":"23232323",
                   "telefone2":"23423432",
                   "email":"asdf@eddf"
    },
    "endereco":{
                        "idendereco":"0",
                        "rua":"Italia",
                        "numero":"67",
                        "cep":"343434",
                        "bairro":"Veneza",
                        "complemento":"saadsffa"
    }
}
*/