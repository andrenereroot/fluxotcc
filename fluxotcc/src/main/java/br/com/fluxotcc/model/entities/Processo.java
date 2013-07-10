
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "processo")
public class Processo implements Serializable{
    
private static final long serialVersionUID =  1L;  

@Id
@GeneratedValue 
@Column(name = "IdProcesso", nullable = false)
private Integer idProcesso;

@Column(name = "Justificativa", length = 2000)
private String justificativa;

//Relacionamento um para um de historico com processo
@OneToOne(mappedBy = "processo", fetch = FetchType.LAZY)
@ForeignKey(name="HistoricoProcesso")
private Historico historico;

 
//relacionamento entre processo e parecer
@OneToMany(mappedBy = "processo", fetch = FetchType.LAZY)
@ForeignKey(name = "ProcessoParecer")
private List<Parecer> pareceres;

 //relacionamento entre aluno e processo
 @ManyToOne(optional=true, fetch = FetchType.LAZY)
 @ForeignKey(name = "AlunoProcesso") 
 @JoinColumn(name="IdAluno", referencedColumnName = "IdAluno")
 private Aluno aluno;
 
 
  //relacionamento entre prioridade e processo
 @ManyToOne(optional=true, fetch = FetchType.LAZY)
 @ForeignKey(name = "PrioridadeProcesso") 
 @JoinColumn(name="IdPrioridade", referencedColumnName = "IdPrioridade")
 private Prioridade prioridade;
 
 
 //relacionamento entre status e processo
 @ManyToOne(optional=false, fetch = FetchType.LAZY)
 @ForeignKey(name = "ProcessoStatus") 
 @JoinColumn(name="IdStatus", referencedColumnName = "IdStatus")
 private Status status;

 public Processo() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Parecer> getPareceres() {
        return pareceres;
    }

    public void setPareceres(List<Parecer> pareceres) {
        this.pareceres = pareceres;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.idProcesso != null ? this.idProcesso.hashCode() : 0);
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
        final Processo other = (Processo) obj;
        if (this.idProcesso != other.idProcesso && (this.idProcesso == null || !this.idProcesso.equals(other.idProcesso))) {
            return false;
        }
        return true;
    }

 

}
