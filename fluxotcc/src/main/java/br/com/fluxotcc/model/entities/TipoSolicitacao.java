
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tiposolicitacao")
public class TipoSolicitacao implements Serializable{
    
  @Id
  @GeneratedValue
  @Column(name = "IdTipoSolicitacao",nullable = false)
  private Integer idTipoSolicitacao;
  
  
  @Column(name = "NomeTipoSolicitacao", nullable = true, length = 100)
  private String nomeTipoSolicitacao;

    public TipoSolicitacao() {
    }

    public Integer getIdTipoSolicitacao() {
        return idTipoSolicitacao;
    }

    public void setIdTipoSolicitacao(Integer idTipoSolicitacao) {
        this.idTipoSolicitacao = idTipoSolicitacao;
    }

    public String getNomeTipoSolicitacao() {
        return nomeTipoSolicitacao;
    }

    public void setNomeTipoSolicitacao(String nomeTipoSolicitacao) {
        this.nomeTipoSolicitacao = nomeTipoSolicitacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idTipoSolicitacao != null ? this.idTipoSolicitacao.hashCode() : 0);
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
        final TipoSolicitacao other = (TipoSolicitacao) obj;
        if (this.idTipoSolicitacao != other.idTipoSolicitacao && (this.idTipoSolicitacao == null || !this.idTipoSolicitacao.equals(other.idTipoSolicitacao))) {
            return false;
        }
        return true;
    }
    
  
}
