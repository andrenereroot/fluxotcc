
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campi")
public class Campi implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdCampi", nullable = false)
    private Integer idCampi;
    
    @Column (name="Nome", nullable = false, length = 80 )
    private String nome;

    public Campi() {
    }

    public Integer getIdCampi() {
        return idCampi;
    }

    public void setIdCampi(Integer idCampi) {
        this.idCampi = idCampi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.idCampi != null ? this.idCampi.hashCode() : 0);
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
        final Campi other = (Campi) obj;
        if (this.idCampi != other.idCampi && (this.idCampi == null || !this.idCampi.equals(other.idCampi))) {
            return false;
        }
        return true;
    }
    
    
}
