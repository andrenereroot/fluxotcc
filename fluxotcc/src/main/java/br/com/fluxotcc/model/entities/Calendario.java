
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name ="calendario")
public class Calendario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue
    @Column(name="IdCalendario", nullable=false)
    private Integer idCalendario;
    
    @Column(name="Titulo", length = 80)
    private String titulo;
    private String descricao;
    
    @Column (name="Inicio", nullable = false )
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar inicio;
    
    @Column (name="DataFinal", nullable = false )
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataFinal;
    
    @Column (name="HoraFinal", nullable = false )
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar horaFinal;
    
    @Column (name="Periodo", nullable = false, length = 80 )
    private String periodo;
    
    @Column (name="Recorrencia", nullable = false, length = 80 )
    private String recorrencia;
    
    
    //relacionamento entre tipo de calendario e tipoUsuario
    @ManyToOne(optional=true, fetch = FetchType.LAZY)
    @ForeignKey(name = "CalendarioTipoUsuario") 
    @JoinColumn(name="IdTipoUsuario", referencedColumnName = "IdTipoUsuario")
    private TipoUsuario tipousuario;

    public Calendario() {
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Calendar getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

  
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.idCalendario != null ? this.idCalendario.hashCode() : 0);
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
        final Calendario other = (Calendario) obj;
        if (this.idCalendario != other.idCalendario && (this.idCalendario == null || !this.idCalendario.equals(other.idCalendario))) {
            return false;
        }
        return true;
    }
    
    
    
    
}
