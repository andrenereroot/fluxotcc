
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
@Table(name = "tipousuario")
public class TipoUsuario implements Serializable{
    
@Id
@GeneratedValue
@Column(name="IdTipoUsuario", nullable=false)
private Integer idTipoUsuario; 

@Column (name="TipoUsuario", nullable = false, length = 30 )
private String TipoUsuario;

//relacionamento entre historico  e tipo de usuario que manipulou o processo
 @OneToMany(mappedBy = "tipousuario", fetch = FetchType.LAZY)
 @ForeignKey(name = "HistoricoTipoUsuario")
 private List<Historico> historicos;

 
 //relacionamento entre localizacao  e tipo de usuario que manipulou o processo
 @OneToMany(mappedBy = "tipousuario", fetch = FetchType.LAZY)
 @ForeignKey(name = "LocalizacaoTipoUsuario")
 private List<Localizacao> localizacoes;
 
 
 //relacionamento entre calendario e tipoUsuario
 @OneToMany(mappedBy = "tipousuario", fetch = FetchType.LAZY)
 @ForeignKey(name = "CalendarioTipoUsuario")
 private List<Calendario> calendarios;

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

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }

    public List<Calendario> getCalendarios() {
        return calendarios;
    }

    public void setCalendarios(List<Calendario> calendarios) {
        this.calendarios = calendarios;
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
