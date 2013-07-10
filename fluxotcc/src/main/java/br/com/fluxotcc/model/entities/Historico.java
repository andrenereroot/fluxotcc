
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="historico")
public class Historico implements Serializable{
    
     private static final long serialVersionUID =  1L;
     
     @Id
     @GeneratedValue
     @Column(name="IdHistorico",nullable = false)
     private Integer idHistorico;
     
     @Column(name="DataOcorrencia", nullable = false)
     @Temporal(javax.persistence.TemporalType.DATE)
     private Date dataOcorrencia; 
     
     @Column(name="HoraOcorrencia",nullable =false)
     @Temporal(javax.persistence.TemporalType.TIME)
     private Date horaOcorrencia;
     
     @Column(name="Ocorrencia",nullable = false,  length = 800 )
     private String ocorrencia;
     
     //Relacionamento um para um de historico com processo
     @OneToOne(optional=false, fetch= FetchType.LAZY)
     @ForeignKey(name="HistoricoProcesso")
     @JoinColumn(name = "IdProcesso", referencedColumnName = "IdProcesso")
     private Processo processo;
     
     
     //relacionamento entre localizacao e histórico
     @ManyToOne(optional=true, fetch = FetchType.LAZY)
     @ForeignKey(name = "HistoricoLocalizacao") 
     @JoinColumn(name="IdLocalizacao", referencedColumnName = "IdLocalizacao")
     private Localizacao localizacao;
     
     
     //relacionamento entre tipo de usuario e histórico
     @ManyToOne(optional=true, fetch = FetchType.LAZY)
     @ForeignKey(name = "HistoricoTipoUsuario") 
     @JoinColumn(name="IdTipoUsuario", referencedColumnName = "IdTipoUsuario")
     private TipoUsuario tipoUsuario;
     
     //relacionamento entre tipo de setor e histórico
     @ManyToOne(optional=true, fetch = FetchType.LAZY)
     @ForeignKey(name = "HistoricoSetor") 
     @JoinColumn(name="IdSetor", referencedColumnName = "IdSetor")
     private Setor setor;

    public Historico() {
    }

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public void setHoraOcorrencia(Date horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
        hash = 23 * hash + (this.idHistorico != null ? this.idHistorico.hashCode() : 0);
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
        final Historico other = (Historico) obj;
        if (this.idHistorico != other.idHistorico && (this.idHistorico == null || !this.idHistorico.equals(other.idHistorico))) {
            return false;
        }
        return true;
    }
     
      
     
}
