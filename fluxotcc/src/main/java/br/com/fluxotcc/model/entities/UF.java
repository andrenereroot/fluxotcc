
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="uf")
public class UF implements Serializable{
       
private static final long serialVersionUID =  1L;
    
@Id
@GeneratedValue
@Column(name="IdUF", nullable=false)
private Integer idUF;

@Column(name="NomeStatus", length = 20, nullable = true)
private String nomeStatus; 

@OneToMany(mappedBy = "uf", fetch = FetchType.LAZY)
@ForeignKey(name = "CidadeUF")
private List<Cidade> cidades;

   


public UF() {
    }

    public Integer getIdUF() {
        return idUF;
    }

    public void setIdUF(Integer idUF) {
        this.idUF = idUF;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }
    
     public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idUF != null ? this.idUF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UF other = (UF) obj;
        if (this.idUF != other.idUF && (this.idUF == null || !this.idUF.equals(other.idUF))) {
            return false;
        }
        return true;
    }

    

}
