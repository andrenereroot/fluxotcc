
package br.com.fluxotcc.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "turno")
public class Turno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdTurno", nullable=false)
    private Integer idTurno;
    
    @Column (name="Turno", nullable = false, length = 10 )
    private String turno;
    
    //relacionamento emtes aluno e turno
    @OneToMany(mappedBy = "turno", fetch = FetchType.LAZY)
    @ForeignKey(name = "TurnoAluno")
    private List<Aluno> alunos;
    
    
    
  //relacionamento muitos para muitos entre turno e cursos
  @ManyToMany
  @JoinTable(name = "Turno_Curso",
  joinColumns =@JoinColumn(name ="IdTurno"),
  inverseJoinColumns=@JoinColumn(name ="IdCurso"))
  private List<Curso> cursos;
 
    
    
    public Turno() {
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

 
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.idTurno != null ? this.idTurno.hashCode() : 0);
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
        final Turno other = (Turno) obj;
        if (this.idTurno != other.idTurno && (this.idTurno == null || !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }
    
    
}
