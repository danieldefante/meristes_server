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
@Table(name="endereco", schema="public")
public class Endereco  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idEndereco;
    private String rua;
    private int numero;
    private String cep;
    private String bairro;
    private String complemento;
    private Set<Pessoa> pessoas = new HashSet<Pessoa>(0);

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idendereco", unique=true, nullable=false)
    public Long getIdEndereco() {
        return this.idEndereco;
    }
    
    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    @Column(name="rua", length=50)
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    @Column(name="numero")
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name="cep", length=10)
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    @Column(name="bairro", length=50)
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name="complemento", length=30)
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch=FetchType.LAZY, mappedBy="endereco", cascade = CascadeType.ALL)
    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}


