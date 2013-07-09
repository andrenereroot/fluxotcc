
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "localizacao")
public class Localizacao implements Serializable{

private static final long serialVersionUID =  1L;

 @Id
 @GeneratedValue
 @Column(name = "IdLocalizacao",nullable = false)
 private Integer idLocalizacao;
 
 
 
 //relacionamento entre localizacao  e historico
 @OneToMany(mappedBy = "localizacao", fetch = FetchType.LAZY)
 @ForeignKey(name = "HistoricoLocalizacao")
 private List<Historico> historicos;
 
 
 //relacionamento entre localizacao e TipoUsuario
  @ManyToOne(optional=true, fetch = FetchType.LAZY)
  @ForeignKey(name = "LocalizacaoTipoUsuario") 
  @JoinColumn(name="IdTipoUsuario", referencedColumnName = "IdTipoUsuario")
  private TipoUsuario tipoUsuario;
 
  
  //relacionamento entre localizacao e setor
  @ManyToOne(optional=true, fetch = FetchType.LAZY)
  @ForeignKey(name = "SetorLocalizacao") 
  @JoinColumn(name="IdSetor", referencedColumnName = "IdSetor")
  private Setor setor;
 
 
 

    public Localizacao() {
    }

    public Integer getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Integer idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
