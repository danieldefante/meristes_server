package verbodavida.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contato", schema="public")
public class Contato  implements Serializable {

    private static final long serialVersionUID = 1L;
	
    private Long idContato;
     
    private String celular;
     
    private String celularTwo;
     
    private String telefone;
     
    private String telefoneTwo;
     
    private String email;
     
//    private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);

    public Contato() {
    }
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcontato", unique=true, nullable=false)
    public Long getIdContato() {
        return this.idContato;
    }
    
    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }
    
    @Column(name="celular", length=30)
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Column(name="celulartwo", length=30)
    public String getCelularTwo() {
        return this.celularTwo;
    }
    
    public void setCelularTwo(String celularTwo) {
        this.celularTwo = celularTwo;
    }
    
    @Column(name="telefone", length=30)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Column(name="telefonetwo", length=30)
    public String getTelefoneTwo() {
        return this.telefoneTwo;
    }
    
    public void setTelefoneTwo(String telefoneTwo) {
        this.telefoneTwo = telefoneTwo;
    }

    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JsonIgnore
//    @OneToMany(fetch=FetchType.LAZY, mappedBy="contato")
//    public Set<Pessoa> getPessoas() {
//        return this.pessoas;
//    }
//    
//    public void setPessoas(Set<Pessoa> pessoas) {
//        this.pessoas = pessoas;
//    }

}


