
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
@Table(name = "setor")
public class Setor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdSetor", nullable = false)
    private Integer idSetor;
    
    @Column (name="NomeSetor", nullable = false, length = 80 )
    private String nomeSetor;
    
    
   //relacionamento entre setor  e localizacao
   @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
   @ForeignKey(name = "SetorLocalizacao")
   private List<Localizacao> localizacoes;
   
   //relacionamento entre setor  e histórico
   @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
   @ForeignKey(name = "HistoricoSetor")
   private List<Historico> historicos;

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

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
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
