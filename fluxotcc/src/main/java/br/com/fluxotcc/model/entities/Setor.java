
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "setor")
public class Setor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdSetor", nullable = false)
    private Integer idSetor;
    
    @Column (name="NomeSetor", nullable = false, length = 80 )
    private String nomeSetor;

    public Setor() {
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.idSetor != null ? this.idSetor.hashCode() : 0);
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
        final Setor other = (Setor) obj;
        if (this.idSetor != other.idSetor && (this.idSetor == null || !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }
    
}
