
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

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
    
    //relacionamento entre parecer e tipoParecer
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "ParecerTipoParecer")
    @JoinColumn(name = "IdTipoParecer", referencedColumnName = "IdTipoParecer")
    private TipoParecer tipoparecer;
    
    //relacionamento entre usuario e parecer
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "UsuarioParecer") 
    @JoinColumn(name="IdUsuario", referencedColumnName = "IdUsuario")
    private Usuario usuario;
    
    
    //relacionamento entre precesso e parecer
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "ProcessoParecer") 
    @JoinColumn(name="IdProcesso", referencedColumnName = "IdProcesso")
    private Processo processo;

    public Parecer(Integer idParecer, String justificativa, TipoParecer tipoParecer, Usuario usuario, Processo processo) {
        this.idParecer = idParecer;
        this.justificativa = justificativa;
        this.tipoparecer = tipoParecer;
        this.usuario = usuario;
        this.processo = processo;
    }

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

    public TipoParecer getTipoparecer() {
        return tipoparecer;
    }

    public void setTipoparecer(TipoParecer tipoparecer) {
        this.tipoparecer = tipoparecer;
    }

 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
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
