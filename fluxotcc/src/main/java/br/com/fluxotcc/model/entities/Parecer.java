
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parecer")
public class Parecer implements Serializable{
    
    private static final long serivalVersionUID = 1L;
    @Id
    @GeneratedValue 
    @Column(name = "IdParecer", nullable = false)
    private Integer idParecer;
    
    @Column(name = "Justificativa", length = 2000)
    private String justificativa;

    public Parecer() {
    }

    public Integer getIdParecer() {
        return idParecer;
    }

    public void setIdParecer(Integer idParecer) {
        this.idParecer = idParecer;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idParecer != null ? this.idParecer.hashCode() : 0);
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
        final Parecer other = (Parecer) obj;
        if (this.idParecer != other.idParecer && (this.idParecer == null || !this.idParecer.equals(other.idParecer))) {
            return false;
        }
        return true;
    }
    
            
}
