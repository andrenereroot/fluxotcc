
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status implements Serializable{
    
private static final long serialVersionUID =  1L;

@Id
@GeneratedValue
@Column(name="IdStatus", nullable=false)
private Integer idStatus;

@Column(name="NomeStatus", length = 20, nullable = true)
private String nomeStatus;

    public Status() {
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.idStatus != null ? this.idStatus.hashCode() : 0);
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
        final Status other = (Status) obj;
        if (this.idStatus != other.idStatus && (this.idStatus == null || !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }


}
