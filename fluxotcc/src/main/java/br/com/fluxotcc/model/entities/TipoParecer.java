
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
@Table(name = "tipoparecer")
public class TipoParecer implements Serializable{
    
    private static final long serivalVersionUID = 1L;
    
    @Id
    @GeneratedValue 
    @Column(name = "IdTipoParecer", nullable = false)
    private Integer idTipoParecer;
    
    @Column(name = "NomeTipoParecer", length = 100)
    private String nomeTipoParecer;
    
    
    //relacionamento entre  parecer e tipoParecer
    @OneToMany(mappedBy = "tipoparecer", fetch = FetchType.LAZY)
    @ForeignKey(name = "ParecerTipoParecer")
    private List<Parecer> pareceres;

    
    public TipoParecer() {
    }

    public Integer getIdTipoParecer() {
        return idTipoParecer;
    }

    public void setIdTipoParecer(Integer idTipoParecer) {
        this.idTipoParecer = idTipoParecer;
    }

    public String getNomeTipoParecer() {
        return nomeTipoParecer;
    }

    public void setNomeTipoParecer(String nomeTipoParecer) {
        this.nomeTipoParecer = nomeTipoParecer;
    }

    public List<Parecer> getPareceres() {
        return pareceres;
    }

    public void setPareceres(List<Parecer> pareceres) {
        this.pareceres = pareceres;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idTipoParecer != null ? this.idTipoParecer.hashCode() : 0);
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
        final TipoParecer other = (TipoParecer) obj;
        if (this.idTipoParecer != other.idTipoParecer && (this.idTipoParecer == null || !this.idTipoParecer.equals(other.idTipoParecer))) {
            return false;
        }
        return true;
    }
    
    
}
