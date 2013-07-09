
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "curso")
public class Curso implements Serializable{
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdCurso",nullable = false)
    private Integer idCurso;
    
    
    @Column(name="NomeCurso", length = 40, nullable = true)
    private String nomeCurso; 
    
    @Column(name="Turno", length = 20, nullable = true)
    private String nomeTurno; 

    public Curso() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeTurno() {
        return nomeTurno;
    }

    public void setNomeTurno(String nomeTurno) {
        this.nomeTurno = nomeTurno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (this.idCurso != null ? this.idCurso.hashCode() : 0);
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
        final Curso other = (Curso) obj;
        if (this.idCurso != other.idCurso && (this.idCurso == null || !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }
    
    
    
}
