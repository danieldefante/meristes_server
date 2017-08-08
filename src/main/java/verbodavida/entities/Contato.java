package verbodavida.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="contato" ,schema="public")

public class Contato  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idContato;
	private String celular;
	private String celulartwo;
	private String telefone;
	private String telefonetwo;
	private String email;
	private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);

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
    public String getCelulartwo() {
        return this.celulartwo;
    }
    
    public void setCelulartwo(String celulartwo) {
        this.celulartwo = celulartwo;
    }

    @Column(name="telefone", length=30)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name="telefonetwo", length=30)
    public String getTelefonetwo() {
        return this.telefonetwo;
    }
    
    public void setTelefonetwo(String telefonetwo) {
        this.telefonetwo = telefonetwo;
    }

    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch=FetchType.LAZY, mappedBy="contato", cascade = CascadeType.ALL)
    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}


