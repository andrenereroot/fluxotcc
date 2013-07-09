
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario implements Serializable{
    
@Id
@GeneratedValue
@Column(name="IdTipoUsuario", nullable=false)
private Integer idTipoUsuario; 

@Column (name="TipoUsuario", nullable = false, length = 30 )
private String TipoUsuario;

    public TipoUsuario() {
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.idTipoUsuario != null ? this.idTipoUsuario.hashCode() : 0);
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
        final TipoUsuario other = (TipoUsuario) obj;
        if (this.idTipoUsuario != other.idTipoUsuario && (this.idTipoUsuario == null || !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }
    

}
