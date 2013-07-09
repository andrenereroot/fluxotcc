
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localizacao")
public class Localizacao implements Serializable{

private static final long serialVersionUID =  1L;

 @Id
 @GeneratedValue
 @Column(name = "IdLocalizacao",nullable = false)
 private Integer idLocalizacao;

    public Localizacao() {
    }

    public Integer getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idLocalizacao != null ? this.idLocalizacao.hashCode() : 0);
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
        final Localizacao other = (Localizacao) obj;
        if (this.idLocalizacao != other.idLocalizacao && (this.idLocalizacao == null || !this.idLocalizacao.equals(other.idLocalizacao))) {
            return false;
        }
        return true;
    }
 
    
}
